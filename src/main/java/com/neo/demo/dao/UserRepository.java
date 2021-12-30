package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neo.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByusername(String username);
}
