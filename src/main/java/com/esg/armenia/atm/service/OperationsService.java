package com.esg.armenia.atm.service;

import com.esg.armenia.atm.entity.AccountTransaction;
import com.esg.armenia.atm.exception.RangeNotSatisfiableException;

import java.util.List;

public interface OperationsService {

    List<AccountTransaction> getAccountTransactions();

    List<Integer> withdraw(Integer amount) throws RangeNotSatisfiableException;
}
