package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
