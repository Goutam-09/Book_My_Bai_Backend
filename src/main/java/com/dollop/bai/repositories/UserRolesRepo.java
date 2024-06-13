package com.dollop.bai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.bai.model.Roles;
import com.dollop.bai.model.UserRoles;

public interface UserRolesRepo extends JpaRepository<UserRoles, String> {

	public Optional<UserRoles> findByUserRole(Roles role);

	public Boolean existsByUserRole(Roles role);

}
