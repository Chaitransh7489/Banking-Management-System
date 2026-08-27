package com.banking.BankingProject.Service.OpenAccountService;

import java.util.List;

import com.banking.BankingProject.Entity.AccountTypeMaster;
import com.banking.BankingProject.Entity.CustomerDetails;
import com.banking.BankingProject.Entity.accountmaster;

public interface OpenAccountServic {
    public String Open(accountmaster account);
    public String generateAccountNo(String acctype);
    public CustomerDetails getById(Long id);
    public List<AccountTypeMaster> getAccountTypes();

}
