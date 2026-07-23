package com.rogerio.shared_primary_key;

import com.rogerio.shared_primary_key.model.User;
import com.rogerio.shared_primary_key.repository.UserRepository;
import com.rogerio.shared_primary_key.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final UserService userService;
  private final UserRepository userRepository;

  public ExerciseRunner(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User user = userRepository.save(new User("Anna"));

    userService.createUserProfile(user.getId(), "Aleatory");
  }
}
