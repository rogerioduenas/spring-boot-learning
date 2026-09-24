package com.rogerio.api_key;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

  private static final String HEADER_NAME = "X-API-KEY";
  private static final String SERVER_KEY = "my-secret-key";

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    String incomingApiKey = request.getHeader(HEADER_NAME);

    if (SERVER_KEY.equals(incomingApiKey)) {
      ApiKeyAuthentication authentication = new ApiKeyAuthentication(
          incomingApiKey,
          AuthorityUtils.NO_AUTHORITIES
      );

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }
}
