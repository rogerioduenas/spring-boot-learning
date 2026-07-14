package com.rogerio.derived_query_methods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  List<Person> findByName(String name);

  List<Person> findByNameIgnoreCase(String name);

  List<Person> findByNameContaining(String part);

  List<Person> findByNameContainingAndIdGreaterThan(String part, Integer id);

  List<Person> findByNameContainingAndIdGreaterThanOrderByIdDesc(String part, Integer id);
}
