package com.banking.BankingProject.Service.TranstionServic;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.banking.BankingProject.Entity.accountmaster;
import com.banking.BankingProject.Entity.recon;
import com.banking.BankingProject.Repositry.Accounttypemasterrepositry;
import com.banking.BankingProject.Repositry.BankingAccountMasterReopsitry;
import com.banking.BankingProject.Repositry.TransactionRepositry;
import jakarta.transaction.Transactional;

@Service
public class ReconServicImp implements ReconServic{

    @Autowired
    private BankingAccountMasterReopsitry reoo;

    @Autowired
    private TransactionRepositry tranRepo;

    @Autowired
    private Accounttypemasterrepositry typeRepo;
    
    @Transactional
    @Override
        public String Transfer(recon tran){
            accountmaster tranMaster=reoo.findByAcctypeAndAcno(tran.getAcctype(),tran.getAcno());
            if(tranMaster==null){
                return "Invalid Account Number";
            }
            tran.setTransactionDt(LocalDate.now());
            Long balance=tranMaster.getAvailableBalance();
            if(tran.getTransaction().equals("Cash")){
                if(tran.getTranType().equals("Credit")){
                    tran.setTranType(tran.getTranType());
                    if(balance==null){
                        balance=tran.getCramt();
                    }else{
                        balance=balance+tran.getCramt();
                    }
                    tranMaster.setAvailableBalance(balance);
                    tran.setCramt(tran.getCramt());
                    tran.setDramt(tran.getDramt()==null ? 0 : tran.getDramt());
                    tranRepo.save(tran);
                    return "Successfully Amount Credit ";

                }else if(tran.getTranType().equals("Debit")){
                    if(balance==null){
                        return "Your Account Balance is Empty";
                    }else if(balance<tran.getDramt()){
                        return "Insufficient Amount ";
                    }else{
                        balance=balance-tran.getDramt();
                    }
                    tranMaster.setAvailableBalance(balance);
                    tran.setTranType(tran.getTranType());
                    tran.setDramt(tran.getDramt());
                    tran.setCramt(tran.getCramt()==null ? 0 : tran.getCramt());
                    tranRepo.save(tran);
                    return "Successfully Amount Debit ";
                }
            }else if(tran.getTransaction().equals("transfer")){
                if(tran.getTranType().equals("Debit")){
                    tran.setTranType(tran.getTranType());
                    if(balance==null){
                        return "Your Account Balance is Empty";
                    }else if(balance<=tran.getDramt()){
                        return "Insufficient Amount ";
                    }else{
                        balance=balance-tran.getDramt();
                    }
                    tranMaster.setAvailableBalance(balance);
                    tran.setDramt(tran.getDramt());
                    tran.setCramt(tran.getCramt()==null ? 0 : tran.getCramt());
                    tran.setRevicerAccountNo(tran.getRevicerAccountNo());
                    
                }
                tranRepo.save(tran);
                return "Successfully Amount Transfer ";
                
            
            }
            return "Successfully  Process  ";
            
        }

        @Override
        public accountmaster verifyAccount(@RequestParam String acctype, @RequestParam String acno){
            return reoo.findByAcctypeAndAcno(acctype, acno);
        }

}
