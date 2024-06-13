package com.dollop.bai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.bai.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	public Boolean existsByUserEmail(String userEmail);

	public Boolean existsByUserMobile(String userMobile);

	public Optional<User> findByUserEmailAndUserPasswordAndIsActive(String userEmail, String userPassword, Boolean True);


}
