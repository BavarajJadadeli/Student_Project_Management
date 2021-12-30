package com.neo.demo.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.User;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= repository.findByusername(username);
		if(user==null) {
			throw new UsernameNotFoundException("invalid user name");
		}
		return new CustomUserDetails(user);
	}

}
