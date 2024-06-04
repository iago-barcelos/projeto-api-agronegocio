package com.betrybe.agrix.ebytr.staff.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * token service.
 */
@Service
public class TokenService {
  private final Algorithm algorithm;

  /**
   * ctor.
   */
  @Autowired
  public TokenService(@Value("${api.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * generate token.
   */
  public String generateToken(String username) {
    return JWT.create()
            .withSubject(username)
            .withExpiresAt(generateExpiration())
            .sign(algorithm);
  }

  /**
   * generate expiration.
   */
  public Instant generateExpiration() {
    return Instant.now()
            .plus(2, ChronoUnit.HOURS);
  }

  /**
   * validate token.
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
            .build()
            .verify(token)
            .getSubject();
  }
}
