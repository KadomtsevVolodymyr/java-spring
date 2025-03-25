//
//package com.yievsieievAndrii.configuration;
//
//import java.util.Date;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
///**
// * JwtTokenProvider
// */
//@Component
//public class JwtTokenProvider {
//
//  @Value("${jwt.secret}")
//  private String jwtSecret;
//
//  @Value("${jwt.expiration}")
//  private Long jwtExpiration;
//
//  public String generateToken(Authentication authentication) {
//    String username = authentication.getName();
//    Date now = new Date();
//    Date expiryDate = new Date(now.getTime() + jwtExpiration);
//
//    return Jwts.builder()
//        .setSubject(username)
//        .setIssuedAt(now)
//        .setExpiration(expiryDate)
//        .signWith(SignatureAlgorithm.HS512, jwtSecret)
//        .compact();
//  }
//
//}
