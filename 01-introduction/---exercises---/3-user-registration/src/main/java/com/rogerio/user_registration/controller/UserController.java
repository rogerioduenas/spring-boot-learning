package com.rogerio.user_registration.controller;

import com.rogerio.user_registration.dto.UserCreateDTO;
import com.rogerio.user_registration.dto.UserResponseDTO;
import com.rogerio.user_registration.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
    UserResponseDTO userResponseDTO = userService.createUser(userCreateDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
  }
}
