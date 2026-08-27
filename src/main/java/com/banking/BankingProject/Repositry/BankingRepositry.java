package com.banking.BankingProject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;


import com.banking.BankingProject.Entity.CustomerDetails;


public interface BankingRepositry extends JpaRepository<CustomerDetails, Long>{


}


