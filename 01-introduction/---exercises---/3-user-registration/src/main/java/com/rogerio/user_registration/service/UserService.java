package com.rogerio.user_registration.service;

import com.rogerio.user_registration.dto.UserCreateDTO;
import com.rogerio.user_registration.dto.UserResponseDTO;
import com.rogerio.user_registration.model.User;
import com.rogerio.user_registration.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResponseDTO createUser(UserCreateDTO dto) {
    Long randomId = (long) (Math.random() * 10000);
    User newUser = new User(randomId, dto.name(), dto.role());

    User savedUser = userRepository.addUser(newUser);

    return new UserResponseDTO(savedUser.id(), savedUser.name(), savedUser.role());
  }
}
