package com.banking.BankingProject.Service.TranstionServic;


import org.springframework.web.bind.annotation.RequestParam;
import com.banking.BankingProject.Entity.accountmaster;
import com.banking.BankingProject.Entity.recon;


public interface ReconServic {
    public String Transfer(recon tran);
    public accountmaster verifyAccount(@RequestParam String acctype, @RequestParam String acno);
}
