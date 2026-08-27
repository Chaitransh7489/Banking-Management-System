package com.banking.BankingProject.Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.banking.BankingProject.Entity.AccountTypeMaster;
import com.banking.BankingProject.Entity.accountmaster;
import com.banking.BankingProject.Entity.recon;
import com.banking.BankingProject.Entity.CustomerDetails;
import com.banking.BankingProject.Service.CreatServic.CreatCustomerDetails;
import com.banking.BankingProject.Service.OpenAccountService.OpenAccountServic;
import com.banking.BankingProject.Service.Report.ReportServiceImp;
import com.banking.BankingProject.Service.TranstionServic.ReconServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

public class controller {
    @Autowired
    private CreatCustomerDetails cust ;

    @Autowired
    private OpenAccountServic openAcc ;

    @Autowired
    private ReconServic recoo;

    @Autowired
    private ReportServiceImp reService;


    @PostMapping("/Create")
    public String Create(@RequestBody CustomerDetails user){
        return cust.Create(user);
    }

    @GetMapping("Fetch/{id}")
    public CustomerDetails getById(@PathVariable Long id){
        return openAcc.getById(id);
    }

    @PostMapping("/Open")
    public String Open(@RequestBody accountmaster account){
        return openAcc.Open(account);
    }
    
    @GetMapping("/GetAccountTypes")
    public List<AccountTypeMaster> getAccountTypes() {
        
        return openAcc.getAccountTypes();
    }

    @PostMapping("/tran")
    public String Transfer(@RequestBody recon tran){
        return recoo.Transfer(tran);
    }

    @GetMapping("/VerifyAccount")
    public accountmaster verifyAccount(@RequestParam String acctype, @RequestParam String acno) {
    return recoo.verifyAccount(acctype, acno);
    }

    @GetMapping("/ReportGenreat")
    public List<Object[]> getAll( 
                            @RequestParam LocalDate toDate ,
                            @RequestParam LocalDate fromDate){
        return reService.getAll(toDate,fromDate);
    }

    @GetMapping("/Indivisual")
    public List<Object[]> getIndivisual(
        @RequestParam String acno ,@RequestParam LocalDate toDate , @RequestParam LocalDate fromDate ){

            return reService.getIndivisual(acno,toDate,fromDate);
        }
    


        
    
    
}
