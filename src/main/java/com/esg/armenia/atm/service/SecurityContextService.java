package com.esg.armenia.atm.service;

import com.esg.armenia.atm.entity.User;

import java.util.Optional;

public interface SecurityContextService {

    Optional<User> currentUser();

}
