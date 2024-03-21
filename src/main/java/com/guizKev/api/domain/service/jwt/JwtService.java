package com.guizKev.api.domain.service.jwt;


import java.security.Key;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRECT_KEY ="0bd700ef-6db5-4845-aeae-a036644c747e";

    
    public String getToken(UserDetails userDetails) {
        return  getToken(new HashMap<>(),userDetails) ;

    }
    


    public String getToken(Map<String,Object> extraClaims,UserDetails userDetails) {
        return  Jwts.builder()
        .setClaims(extraClaims) 
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
        .signWith(getKey(),SignatureAlgorithm.HS256)
        .compact();
        

    }


    private Key getKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
    
    
}
