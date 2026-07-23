package com.rogerio.shared_primary_key.repository;

import com.rogerio.shared_primary_key.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
