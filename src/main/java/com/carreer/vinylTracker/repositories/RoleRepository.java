package com.carreer.vinylTracker.repositories;

import com.carreer.vinylTracker.models.auth.ERole;
import com.carreer.vinylTracker.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    @Query(value = "select count(*) from role",
            nativeQuery = true)
    int isRoleEmpty();


}
