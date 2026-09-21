package com.rogerio.exception_handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final DelegatedAuthenticationEntryPoint authEntryPoint;

  public SecurityConfig(DelegatedAuthenticationEntryPoint authEntryPoint) {
    this.authEntryPoint = authEntryPoint;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(basic -> basic
            .authenticationEntryPoint(authEntryPoint)
        )
        .exceptionHandling(exception -> exception
            .authenticationEntryPoint(authEntryPoint)
        )
        .build();
  }
}