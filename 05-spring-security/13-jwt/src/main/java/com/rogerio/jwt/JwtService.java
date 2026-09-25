package com.rogerio.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

  private final SecretKey secretKey;
  private final long expirationInMs;

  public JwtService(
      @Value("${api.security.jwt.secret}") String secret,
      @Value("${api.security.jwt.expiration-ms}") long expirationInMs) {
    this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    this.expirationInMs = expirationInMs;
  }

  public String generateToken(String username) {
    Instant now = Instant.now();
    Instant expiryDate = now.plusMillis(expirationInMs);

    return Jwts.builder()
        .subject(username)
        .issuedAt(Date.from(now))
        .expiration(Date.from(expiryDate))
        .signWith(secretKey)
        .compact();
  }

  public String extractUsername(String token) {
    Claims claims = parseClaims(token);
    return claims.getSubject();
  }

  public boolean isTokenValid(String token) {
    try {
      Claims claims = parseClaims(token);
      return !claims.getExpiration().before(new Date());
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

  private Claims parseClaims(String token) {
    return Jwts.parser()
        .verifyWith(secretKey)
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }
}
