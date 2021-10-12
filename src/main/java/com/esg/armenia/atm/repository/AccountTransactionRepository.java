package com.esg.armenia.atm.repository;

import  com.esg.armenia.atm.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    List<AccountTransaction> findAllByUser_Id(Integer id);
}
