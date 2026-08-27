package com.banking.BankingProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="account_master")
public class accountmaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String acno ;
    private String acctype;
    private String custname ;
    private String openingDt ;
    private String closingDt ;
    private String lastTranDt ;
    private Long custid ;
    private Long availableBalance;

    public Long getId(){
        return id ;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getAcno(){
        return acno ;
    }
    public void setAcno(String acno){
        this.acno=acno;
    }
    public String getAcctype(){
        return acctype ;
    }
    public Long getAvailableBalance(){
        return availableBalance;
    }
    public void setAcctype(String acctype){
        this.acctype=acctype;
    }

    public String getCustname(){
        return custname ;
    }
    public void setCustname(String custname){
        this.custname=custname;
    }
    public String getOpeningDt(){
        return openingDt ;
    }
    public void setOpeningDt(String openingDt){
        this.openingDt=openingDt;
    }
    public String getClosingDt(){
        return closingDt ;
    }
    public void setClosingDt(String closingDt){
        this.closingDt=closingDt;
    }
    public String getLastTranDt(){
        return lastTranDt ;
    }
    public void setLastTranDt(String lastTranDt){
        this.lastTranDt=lastTranDt;
    }
    public Long getCustid(){
        return custid ;
    }
    public void setCustid(Long custid){
        this.custid=custid;
    }
    public void setAvailableBalance(Long availableBalance){
        this.availableBalance=availableBalance;
    }
}

