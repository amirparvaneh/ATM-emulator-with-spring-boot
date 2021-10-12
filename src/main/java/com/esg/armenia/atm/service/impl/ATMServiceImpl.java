package com.esg.armenia.atm.service.impl;

import com.esg.armenia.atm.service.ATMService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ATMServiceImpl implements ATMService {

    private final static ArrayList<Integer> denominations = new ArrayList<>(Arrays.asList(100, 50, 20));

    @Override
    public List<Integer> getDenominations() {
        return denominations;
    }
}
