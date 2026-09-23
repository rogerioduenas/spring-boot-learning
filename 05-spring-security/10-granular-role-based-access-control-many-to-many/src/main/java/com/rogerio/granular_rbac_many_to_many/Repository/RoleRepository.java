package com.rogerio.granular_rbac_many_to_many.Repository;

import com.rogerio.granular_rbac_many_to_many.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
