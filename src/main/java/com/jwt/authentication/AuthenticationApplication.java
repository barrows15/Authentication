package com.jwt.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jwt.authentication.model.Role;
import com.jwt.authentication.model.User;
import com.jwt.authentication.respository.UserRepository;

@SpringBootApplication
public class AuthenticationApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		System.out.println("project..");
		SpringApplication.run(AuthenticationApplication.class, args);
	}
	
	public void run(String... args) {
		System.out.println("step1");
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		System.out.println("step2:"+adminAccount);
		
		if(null == adminAccount) {
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
