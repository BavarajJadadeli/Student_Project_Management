package com.neo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.neo.demo.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
