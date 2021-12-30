
package com.neo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.Student;
import com.neo.demo.entity.User;
import com.neo.demo.jwtUtils.AuthenticationRequest;
import com.neo.demo.jwtUtils.JwtUtil;
import com.neo.demo.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired(required = true)
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid user/user not found");
		}
		return jwtUtil.generateToken(authenticationRequest.getUsername());
	}

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return service.addNewStudent(student);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAll")
	public List<Student> getAllStudent() {
		return service.getAllStudnet();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("getStudent/{id}")
	public Student getStudentById(@PathVariable("id") int studentId) {

		return service.getByStudentId(studentId);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin")
	public String addUserByAdmin(@RequestBody User user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		repository.save(user);
		return "user added successfully...";
	}
}
