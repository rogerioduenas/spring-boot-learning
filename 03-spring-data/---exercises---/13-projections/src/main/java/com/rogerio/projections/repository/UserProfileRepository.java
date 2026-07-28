package com.rogerio.projections.repository;

import com.rogerio.projections.model.UserProfile;
import com.rogerio.projections.model.UserProfileSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

  @Query("SELECT new com.rogerio.projections.model.UserProfileSummary(u.userName, u.email) FROM UserProfile u")
  List<UserProfileSummary> findAllSummaries();
}
