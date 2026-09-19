package com.rogerio.authentication_provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
    final String name = authentication.getName();
    final String password = authentication.getCredentials().toString();

    if ("admin".equals(name) && "123".equals(password)) {
      return authenticateAgainstThirdPartyAndGetAuthentication(name, password);
    }

    throw new BadCredentialsException("Invalid credentials");
  }

  private static UsernamePasswordAuthenticationToken authenticateAgainstThirdPartyAndGetAuthentication(String name, String password) {
    final List<GrantedAuthority> grantedAuths = new ArrayList<>();
    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

    final UserDetails principal = new User(name, password, grantedAuths);

    return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
