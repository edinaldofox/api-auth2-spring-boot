package com.yoshi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoshi.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
