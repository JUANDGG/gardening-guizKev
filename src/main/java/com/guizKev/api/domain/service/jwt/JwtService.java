package com.guizKev.api.domain.service.jwt;


import java.security.Key;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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



    public String getUserNameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }


    /* 
    public boolean isTokenValid(String token, UserDetails userDetails) {
        
    }*/
    

    private Claims getAllClaims(String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJwt(token)
            .getBody();
    }

    public <T> T getClaim(String  token , Function<Claims,T> ClaimsResolver){
        final Claims claims = getAllClaims(token);
        return ClaimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }
    

    private boolean isTokenValid(String token){
        return getExpiration(token).before(new Date())
    }
}
