package com.rogerio.custom_query_with_pagination.repository;

import com.rogerio.custom_query_with_pagination.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

  @Query(
      value = "SELECT u FROM User u JOIN FETCH u.department WHERE u.department.name = :deptName AND u.active = true",
      countQuery = "SELECT count(u) FROM User u WHERE u.department.name = :deptName AND u.active = true"
  )
  Page<User> findActiveUsersByDepartment(String deptName, Pageable pageable);
}
