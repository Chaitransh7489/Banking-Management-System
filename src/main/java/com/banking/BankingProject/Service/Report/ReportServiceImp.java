package com.banking.BankingProject.Service.Report;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.BankingProject.Repositry.BankingAccountMasterReopsitry;

@Service
public class ReportServiceImp implements ReportService {

    @Autowired
    private BankingAccountMasterReopsitry  reoo ;


    @Override
    public List<Object[]> getAll(LocalDate toDate,LocalDate fromeDate){
        
        return reoo.getAllReport( fromeDate, toDate);
        
        
    }

    @Override
    public List<Object[]> getIndivisual(String acno ,LocalDate toDate,LocalDate fromeDate){
    
        return reoo.getIndivisualReport( acno ,fromeDate, toDate);
    }

}
