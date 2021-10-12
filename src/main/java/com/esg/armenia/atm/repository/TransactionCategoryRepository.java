package com.esg.armenia.atm.repository;


import com.esg.armenia.atm.entity.TransactionCategory;
import org.springframework.data.repository.CrudRepository;

public interface TransactionCategoryRepository extends CrudRepository<TransactionCategory, Integer> {
}
