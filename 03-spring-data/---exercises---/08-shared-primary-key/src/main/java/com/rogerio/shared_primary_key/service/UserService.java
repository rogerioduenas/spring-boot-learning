package com.rogerio.shared_primary_key.service;

import com.rogerio.shared_primary_key.model.User;
import com.rogerio.shared_primary_key.model.UserProfile;
import com.rogerio.shared_primary_key.repository.UserProfileRepository;
import com.rogerio.shared_primary_key.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserProfileRepository userProfileRepository;

  public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository) {
    this.userRepository = userRepository;
    this.userProfileRepository = userProfileRepository;
  }

  @Transactional
  public void createUserProfile(Long userId, String bio) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));

    UserProfile userProfile = new UserProfile(bio, user);

    userProfileRepository.save(userProfile);
  }
}
