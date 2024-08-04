package com.jwt.authentication.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.authentication.model.User;
import com.jwt.authentication.respository.UserRepository;
import com.jwt.authentication.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) {
				System.out.println("username:" + username);
				//System.out.println("new user: " +userRepository.findByEmail(username));
				
				UserDetails newUser = userRepository.findByEmail(username).
						orElseThrow(() -> new UsernameNotFoundException("User Not found"));
				
				System.out.println(newUser);
				System.out.println(newUser.getUsername());
				System.out.println(newUser.getPassword());
				
				return userRepository.findByEmail(username).
						orElseThrow(() -> new UsernameNotFoundException("User Not found"));
			}
		};
	}
	
}
