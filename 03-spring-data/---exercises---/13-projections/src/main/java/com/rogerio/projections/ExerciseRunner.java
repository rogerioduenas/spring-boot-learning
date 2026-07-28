package com.rogerio.projections;

import com.rogerio.projections.model.UserProfile;
import com.rogerio.projections.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final UserProfileRepository userProfileRepository;

  public ExerciseRunner(UserProfileRepository userProfileRepository) {
    this.userProfileRepository = userProfileRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    userProfileRepository.save(new UserProfile("Anna", "anna@email.com"));
    userProfileRepository.save(new UserProfile("Mike", "mike@email.com"));
    userProfileRepository.save(new UserProfile("John", "john@email.com"));

    userProfileRepository.findAllSummaries().forEach(System.out::println);
  }
}
