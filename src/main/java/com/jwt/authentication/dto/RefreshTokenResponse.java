package com.jwt.authentication.dto;

import lombok.Data;

@Data
public class RefreshTokenResponse {
	
	private String Token;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}
}
