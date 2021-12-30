package com.neo.demo.service;

import java.util.List;

import com.neo.demo.entity.Student;
import com.neo.demo.entity.User;


public interface StudentService {

	public Student addNewStudent(Student student);
	public List<Student> getAllStudnet();
	public Student getByStudentId(int studentId);
	
	public User findbyUsername(String username);
	
	public User findUserById(int id);
}


