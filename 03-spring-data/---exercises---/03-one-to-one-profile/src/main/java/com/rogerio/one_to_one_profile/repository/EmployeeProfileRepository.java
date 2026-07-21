package com.rogerio.one_to_one_profile.repository;

import com.rogerio.one_to_one_profile.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
}
