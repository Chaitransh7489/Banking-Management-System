package com.banking.BankingProject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.BankingProject.Entity.AccountTypeMaster;
public interface Accounttypemasterrepositry extends JpaRepository<AccountTypeMaster ,Long> {
    AccountTypeMaster findByAcctype(String acctype);
    AccountTypeMaster findByAccNature(String accNature);
}
