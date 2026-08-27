package com.banking.BankingProject.Service.OpenAccountService;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.BankingProject.Entity.AccountTypeMaster;
import com.banking.BankingProject.Entity.CustomerDetails;
import com.banking.BankingProject.Entity.accountmaster;
import com.banking.BankingProject.Repositry.Accounttypemasterrepositry;
import com.banking.BankingProject.Repositry.BankingAccountMasterReopsitry;
import com.banking.BankingProject.Repositry.BankingRepositry;
@Service
public class OpenAccountServicImp implements OpenAccountServic{

    @Autowired
    private BankingAccountMasterReopsitry reoo;

    @Autowired
    private BankingRepositry bankreo ;

    @Autowired
    private Accounttypemasterrepositry typeRepo ;
    
    
    @Override
        public String Open(accountmaster account){
            AccountTypeMaster typeMaster = typeRepo.findByAcctype(account.getAcctype());
            if(typeMaster == null){
                return "Invalid Account Type ";
            }
            // String acctype = typeMaster.getAcctype();
            account.setAcno(generateAccountNo(typeMaster.getAcctype()));
            account.setOpeningDt(String.valueOf(new Date()));
            accountmaster saved=reoo.save(account);
            saved.getAcno();
            return "Created Successfully..Your Account Number is :"+ saved.getAcno();
        }

        @Override
        public String generateAccountNo(String acctype){
            String top="90";
            top=top+acctype;
            int maxNumber=reoo.getMax();
            String acno= String.valueOf(maxNumber);
            int count=acno.length();
            if(count==1){
                acno="00000"+acno;
            }else if(count == 2){
                acno="0000"+acno;
            }else if(count == 3){
                acno="000"+acno;
            }else if(count == 4){
                acno="00"+acno;
            }
            return top + acno + "01";
        }

        @Override
        public CustomerDetails getById(Long id){
            CustomerDetails data=bankreo.findById(id).orElse(null);
        return data ;
        }

        @Override
        public List<AccountTypeMaster> getAccountTypes(){
            return typeRepo.findAll();
        }
}
