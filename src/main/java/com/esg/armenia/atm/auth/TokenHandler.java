package com.esg.armenia.atm.auth;

import com.esg.armenia.atm.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface TokenHandler {

    Optional<UserDetails> parseUserFromToken(String token);

    String createTokenForUser(User user);

}
