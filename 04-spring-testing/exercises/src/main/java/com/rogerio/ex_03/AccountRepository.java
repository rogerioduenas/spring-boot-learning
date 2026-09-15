package com.rogerio.ex_03;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

  @Modifying
  @Query("UPDATE AccountEntity a SET a.balance = :balance WHERE a.id = :id")
  void updateBalance(@Param("id") Long id, @Param("balance") Double balance);
}
