package com.jwt.authentication.dto;

import lombok.Data;


public class SignUpRequest {

	
	private String name;
	private String email;
	private String password;
	
	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SignUpRequest(String username, String email, String password) {
		super();
		this.name = username;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setUsername(String username) {
		this.name = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
