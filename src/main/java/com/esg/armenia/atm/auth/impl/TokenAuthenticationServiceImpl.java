package com.esg.armenia.atm.auth.impl;

import com.esg.armenia.atm.auth.TokenAuthenticationService;
import com.esg.armenia.atm.auth.TokenAuthenticationService;
import com.esg.armenia.atm.auth.TokenHandler;
import com.esg.armenia.atm.auth.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Function;

@Service
class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private final TokenHandler tokenHandler;

    @Autowired
    TokenAuthenticationServiceImpl(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String authHeader = request.getHeader("authorization");
        if (authHeader == null) return null;
        if (!authHeader.startsWith("Bearer")) return null;

        final String jwt = authHeader.substring(7);
        if (jwt.isEmpty()) return null;

        return tokenHandler
                .parseUserFromToken(jwt)
                .map(new Function<UserDetails, UserAuthentication>() {
                    @Override
                    public UserAuthentication apply(UserDetails user) {
                        return new UserAuthentication(user);
                    }
                })
                .orElse(null);
    }
}

