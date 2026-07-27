package com.rogerio.n_plus_one.repository;

import com.rogerio.n_plus_one.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Query("SELECT c FROM Company c JOIN FETCH c.employees")
  public List<Company> findAllWithEmployees();
}
