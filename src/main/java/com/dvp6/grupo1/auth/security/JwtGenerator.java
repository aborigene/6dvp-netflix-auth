package com.dvp6.grupo1.auth.security;

import java.sql.SQLException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtGenerator {

    public static String getJWT() throws SQLException, JWTCreationException {

        Date date = new Date();
        String role = null;
        String expiresAt = null;
        String token = null;
        String username = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
            role = authentication.getAuthorities().toString();
        }
       
        role = role.substring(1, role.length()-1);
        expiresAt = Long.toString(date.getTime() + 600000);

        Algorithm algorithm = Algorithm.HMAC256("secret");
        token = JWT.create().withIssuer(username).withClaim("role", role).withClaim("exp", expiresAt).sign(algorithm);

        return token;
    }

}
