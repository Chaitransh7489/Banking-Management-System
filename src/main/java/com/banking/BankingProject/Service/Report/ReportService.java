package com.banking.BankingProject.Service.Report;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    public List<Object[]> getAll(LocalDate toDate,LocalDate fromeDate);
    public List<Object[]> getIndivisual(String acno ,LocalDate toDate,LocalDate fromeDate);
}
