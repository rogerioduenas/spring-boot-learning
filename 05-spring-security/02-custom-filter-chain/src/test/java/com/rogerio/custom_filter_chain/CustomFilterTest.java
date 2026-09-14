package com.rogerio.custom_filter_chain;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit Tests for CustomFilter")
class CustomFilterTest {

  @InjectMocks
  private CustomFilter customFilter;

  @Mock
  private HttpServletRequest request;

  @Mock
  private HttpServletResponse response;

  @Mock
  private FilterChain filterChain;

  @Test
  @DisplayName("Should execute internal logic and proceed down the filter chain")
  void givenValidRequest_whenDoFilterInternal_thenCallsFilterChain() throws Exception {
    // Given
    given(request.getRequestURI()).willReturn("/login");

    // When
    customFilter.doFilterInternal(request, response, filterChain);

    // Then
    then(filterChain).should(BDDMockito.times(1)).doFilter(request, response);
  }
}
