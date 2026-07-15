package com.rogerio.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  @Query("SELECT p FROM Person p")
  List<Person> findAllJpql();

  @Query(value = "SELECT * FROM person", nativeQuery = true)
  List<Person> findAllNative();

  @Query("SELECT p FROM Person p WHERE p.name = :name")
  List<Person> findByNameJpqlNamed(@Param("name") String name);

  @Query(value = "SELECT * FROM person u WHERE u.name = :name", nativeQuery = true)
  List<Person> findByNameNativeNamed(@Param("name") String name);
}
