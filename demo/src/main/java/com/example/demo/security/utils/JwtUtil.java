package com.example.demo.security.utils;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtUtil {
    String extractUsername(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(UserDetails userDetails);
    String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extractExpiration(String token);
    Claims extractAllClaims(String token);
    Key getSignInKey();

}
