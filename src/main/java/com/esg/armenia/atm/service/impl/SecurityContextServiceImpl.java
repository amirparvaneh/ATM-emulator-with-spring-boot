package com.esg.armenia.atm.service.impl;

import com.esg.armenia.atm.entity.User;
import com.esg.armenia.atm.repository.UserRepository;
import com.esg.armenia.atm.service.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SecurityContextServiceImpl implements SecurityContextService {

    private final UserRepository userRepository;

    @Autowired
    public SecurityContextServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> currentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findOneByUsername(authentication.getName());
    }
}
