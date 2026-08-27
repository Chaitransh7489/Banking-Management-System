package com.banking.BankingProject.Repositry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.banking.BankingProject.Entity.accountmaster;

public interface BankingAccountMasterReopsitry extends JpaRepository<accountmaster, Long>{
    
    @Query(value = "SELECT COALESCE(MAX(CAST(SUBSTRING(acno,5,6) AS UNSIGNED)),0)+1 FROM account_master",nativeQuery = true)
    int getMax();
    
    accountmaster findByAcno(String acno);
    accountmaster findByAcctypeAndAcno(String acctype , String acno );

    // ==========================================
    // 1. DYNAMIC ALL REPORT QUERY
    // ==========================================
    @Query(value = """
    select b.custid, b.acno, a.full_name, a.email, a.mob_no, a.pan, c.cramt, c.dramt, c.tran_type, c.dt, d.balance
    from custmerid_detail as a join account_master b
    on a.custid=b.custid left join
    (select acno, cramt, dramt, tran_type, date_format(transaction_Dt,'%Y%m%d') as dt  from recon
    where DATE(transaction_Dt) >= :fromeDate and DATE(transaction_Dt) <= :toDate) as c on b.acno=c.acno
    left join
    (select c.acno, IFNULL(SUM(ifnull(c.cramt,0)-ifnull(c.dramt,0)),0) AS balance from recon c
    where DATE(transaction_Dt) >= :fromeDate and DATE(transaction_Dt) <= :toDate group by c.acno) as d
    on b.acno=d.acno where (c.cramt is not null or c.dramt is not null ) order by b.acno
    """, nativeQuery = true)
    List<Object[]> getAllReport(LocalDate fromeDate,LocalDate toDate);

    // ==========================================
    // 2. DYNAMIC INDIVIDUAL REPORT QUERY
    // ==========================================
    @Query(value = """
    select b.custid, b.acno, a.full_name, a.email, a.mob_no, a.pan, c.cramt, c.dramt, c.tran_type, c.dt, d.balance
    from custmerid_detail as a join account_master b
    on a.custid=b.custid left join
    (select acno, cramt, dramt, tran_type, date_format(transaction_Dt,'%Y%m%d') as dt  from recon
    where acno = :acno and DATE(transaction_Dt) >= :fromeDate and DATE(transaction_Dt) <= :toDate) as c on b.acno=c.acno
    left join
    (select c.acno, IFNULL(SUM(ifnull(c.cramt,0)-ifnull(c.dramt,0)),0) AS balance from recon c
    where acno = :acno and DATE(transaction_Dt) >= :fromeDate and DATE(transaction_Dt) <= :toDate group by c.acno) as d
    on b.acno=d.acno
    where b.acno = :acno
    """, nativeQuery = true)
    List<Object[]> getIndivisualReport( String acno,  LocalDate fromeDate, LocalDate toDate);

}