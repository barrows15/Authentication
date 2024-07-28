package com.jwt.authentication.dto;

import lombok.Data;

@Data
public class RefreshTokenRequest {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public RefreshTokenRequest() {
	}

	public RefreshTokenRequest(String token) {
		super();
		this.token = token;
	}
	
	
}
