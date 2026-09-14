package com.banking.BankingProject.Service.CreatServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.BankingProject.Entity.CustomerDetails;
import com.banking.BankingProject.Repositry.BankingRepositry;

@Service

public class CreatCustomerDetailsImp implements CreatCustomerDetails {

    @Autowired
    private BankingRepositry reo ;

    @Override
    public String Create(CustomerDetails user){
        CustomerDetails saved=reo.save(user);
        saved.getCustid();
        System.out.println(saved.getCustid());
        return "Created Successfully..Your Id is :"+saved.getCustid();

        }
}
