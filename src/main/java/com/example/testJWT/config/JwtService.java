package com.example.testJWT.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String extractUserEmail(String token){
    return null;
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey) //lorsqu'on essaye de traiter un claim, on a besoin d'une signing key
                .build()
                .parseClaimsJws(token) //analyse la revendication
                .getBody();
    };

    private Claims extractSingleCLaims(String token){

    };

}
