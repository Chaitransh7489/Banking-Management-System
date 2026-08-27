package com.banking.BankingProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account_type_master")
public class AccountTypeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String acctype ;
    private String accNature ;
    private String branch ;


    public Long getId(){
        return id ;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getAcctype(){
        return acctype ;
    }
    public void setAcctype(String acctype){
        this.acctype=acctype;
    }
    public String getAccNature(){
        return accNature ;
    }
    public void setAccNature(String accNature){
        this.accNature=accNature;
    }
    public String getBranch(){
        return branch ;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }
}
