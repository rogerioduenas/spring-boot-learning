package com.rogerio.granted_authority_vs_role;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/admin/**").hasRole("ADMIN")

            .requestMatchers("/api/reports/read").hasAuthority("READ_PRIVILEGE")

            .requestMatchers("/api/manager/**").hasRole("MANAGER")

            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .build();
  }

  @Bean
  public UserDetailsService userDetailsService() {

    UserDetails commonUser = User.builder()
        .username("user")
        .password("{noop}123456")
        .authorities("READ_PRIVILEGE")
        .build();

    UserDetails adminUser = User.builder()
        .username("admin")
        .password("{noop}123456")
        .roles("ADMIN")
        .build();

    UserDetails managerUser = User.builder()
        .username("manager")
        .password("{noop}123456")
        .authorities("ROLE_MANAGER", "READ_PRIVILEGE", "WRITE_PRIVILEGE")
        .build();

    return new InMemoryUserDetailsManager(commonUser, adminUser, managerUser);
  }
}
