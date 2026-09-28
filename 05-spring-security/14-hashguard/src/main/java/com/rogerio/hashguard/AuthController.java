package com.rogerio.hashguard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody AuthRequest request) {
    String passwordHash = passwordEncoder.encode(request.password());

    User user = new User(request.username(), passwordHash);
    userRepository.save(user);

    return ResponseEntity.ok("User registered successfully! Hash in bank: " + passwordHash);
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody AuthRequest request) {
    Optional<User> userOptional = userRepository.findByUsername(request.username());

    if (userOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username not found");
    }

    User user = userOptional.get();

    boolean passwordMatches = passwordEncoder.matches(request.password(), user.getPassword());

    if (passwordMatches) {
      return ResponseEntity.ok("Login successful");
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password not match");
    }
  }
}