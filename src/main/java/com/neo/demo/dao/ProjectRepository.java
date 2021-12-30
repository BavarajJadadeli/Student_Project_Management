package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
