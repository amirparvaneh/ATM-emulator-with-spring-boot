package com.esg.armenia.atm.controller;

import com.esg.armenia.atm.entity.AccountTransaction;
import com.esg.armenia.atm.exception.RangeNotSatisfiableException;
import com.esg.armenia.atm.model.Withdrawal;
import com.esg.armenia.atm.service.ATMService;
import com.esg.armenia.atm.service.OperationsService;
import com.esg.armenia.atm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private static final Logger LOG = LoggerFactory.getLogger(OperationsController.class);

    private OperationsService operationsService;
    private ATMService atmService;
    private UserService userService;

    @Autowired
    public OperationsController(OperationsService operationsService, ATMService atmService, UserService userService) {
        this.operationsService = operationsService;
        this.atmService = atmService;
        this.userService = userService;
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public List<AccountTransaction> getAccountTransactions() {
        return operationsService.getAccountTransactions();

    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public Integer getAccountBalance() {
        return userService.getAccountBalance();
    }

    @RequestMapping(value = "/denominations", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public List<Integer> getDenominations() {
        return atmService.getDenominations();
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, consumes = {"application/json"})
    @PreAuthorize("hasAuthority('USER')")
    public List<Integer> withdraw(@RequestBody Withdrawal withdrawal) throws RangeNotSatisfiableException {
        LOG.info("Amount: {}", withdrawal);
        return operationsService.withdraw(Integer.valueOf(withdrawal.getAmount()));
    }

}
