package com.banking.BankingProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="custmerid_detail")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custid;
    private String fullName;
    private String address;
    private long mobNo;
    private String gender ;
    private String email;
    private String aadhar;
    private String pan;
    
    public Long getCustid(){
        return custid ;
    }
    public void setCustid(Long custid){
        this.custid=custid;
    }
    public String getFullName(){
        return fullName ;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public String getAddress(){
        return address ;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public long getMobNo(){
        return mobNo ;
    }
    public void setMobNO(long mobNo){
        this.mobNo=mobNo;
    }
    public String getGender(){
        return gender ;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getEmail(){
        return email ;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getAadhar(){
        return aadhar ;
    }
    public void setAadhar(String aadhar){
        this.aadhar=aadhar;
    }
    public String getPan(){
        return pan ;
    }
    public void setPan(String pan){
        this.pan=pan;
    }
    
}
