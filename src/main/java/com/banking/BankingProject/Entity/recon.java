package com.banking.BankingProject.Entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class recon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acctype ;
    private String acno ;
    private Long cramt;
    private Long dramt;
    private LocalDate transactionDt;
    private String transaction;
    private String tranType;
    private String revicerAccountNo;


    public Long getID(){
        return id;
    }
    public String getAcctype(){
        return acctype;
    }
    public String getAcno(){
        return acno;
    }
    public Long getCramt(){
        return cramt;
    }
    public Long getDramt(){
        return dramt;
    }
    public String getTranType(){
        return tranType;
    }
    public LocalDate getTransactionDt(){
        return transactionDt;
    }
    public String getTransaction(){
        return transaction ;
    }
    public String getRevicerAccountNo(){
        return revicerAccountNo;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setAcctype(String acctype){
        this.acctype=acctype;
    }
    public void setAcno(String acno){
        this.acno=acno;
    }
    public void setCramt(Long cramt){
        this.cramt=cramt;
    }
    public void setDramt(Long dramt){
        this.dramt=dramt;
    }
    public void setTransactionDt(LocalDate transactionDt){
        this.transactionDt=transactionDt;
    }
    public void setTransaction(String transaction){
        this.transaction=transaction;
    }
    public void setTranType(String tranType){
        this.tranType=tranType;
    }
    public void setRevicerAccountNo(String revicerAccountNO){
        this.revicerAccountNo=revicerAccountNO;
    }

}
