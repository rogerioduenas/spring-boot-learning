package com.rogerio.hello_docker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StupidRepository extends JpaRepository<StupidRegister, Long> {
}
