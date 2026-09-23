package com.rogerio.granular_rbac_many_to_many.Repository;

import com.rogerio.granular_rbac_many_to_many.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
