package com.rogerio.user_registration.repository;

import com.rogerio.user_registration.model.User;
import com.rogerio.user_registration.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

  private final List<User> users = new ArrayList<>(List.of(
      new User(1L, "admin_user", UserRole.ADMIN),
      new User(2L, "dev_user", UserRole.DEVELOPER),
      new User(3L, "guest_user", UserRole.GUEST)
  ));

  public User addUser(User user) {
    users.add(user);
    return user;
  }
}
