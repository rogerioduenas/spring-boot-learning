package com.rogerio.manual_authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

  private final AuthenticationManager authManager;

  public Controller(AuthenticationManager authManager) {
    this.authManager = authManager;
  }

  @PostMapping("/login-stateless")
  public ResponseEntity<String> login(@RequestBody LoginDTO request) {
    // Create an unauthenticated token using the request data
    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(request.username(), request.password());

    // Authenticate via AuthenticationManager (which calls DaoAuthenticationProvider by default)
    Authentication auth = authManager.authenticate(authReq);

    // Manually set the authentication in the current request's ThreadLocal
    SecurityContext sc = SecurityContextHolder.getContext();
    sc.setAuthentication(auth);

    // Test: retrieve it to prove it is saved in the current context
    String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();

    return ResponseEntity.ok("User " + loggedUser + " successfully authenticated");
  }


  @PostMapping("/login-stateful")
  public ResponseEntity<String> loginStateful(@RequestBody LoginDTO request, HttpServletRequest httpRequest) {

    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(request.username(), request.password());

    Authentication auth = authManager.authenticate(authReq);

    SecurityContext sc = SecurityContextHolder.createEmptyContext();
    sc.setAuthentication(auth);

    // Set the context in the current thread's SecurityContextHolder
    SecurityContextHolder.setContext(sc);

    // Explicitly persist the SecurityContext into the HTTP Session for future requests
    HttpSession session = httpRequest.getSession(true);
    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);

    // Test: retrieve it to prove it is stored in the current session context
    String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();

    return ResponseEntity.ok("User " + loggedUser + " successfully authenticated");
  }

  @GetMapping("/me")
  public ResponseEntity<String> getProfile() {
    // Protected endpoint to test that, without JWT/Session, the next request arrives as 'Anonymous'
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return ResponseEntity.ok("User in current context: " + auth.getName());
  }
}
