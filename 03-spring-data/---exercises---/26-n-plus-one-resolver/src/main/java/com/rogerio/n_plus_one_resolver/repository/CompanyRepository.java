package com.rogerio.n_plus_one_resolver.repository;

import com.rogerio.n_plus_one_resolver.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Query("SELECT c FROM Company c LEFT JOIN FETCH c.employees WHERE c.id = :id")
  Optional<Company> findByIdWithEmployees(@Param("id") Long id);
}
