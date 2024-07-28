package com.jwt.authentication.service;

import com.jwt.authentication.dto.JwtAuthenticationResponse;
import com.jwt.authentication.dto.RefreshTokenRequest;
import com.jwt.authentication.dto.RefreshTokenResponse;
import com.jwt.authentication.dto.SignInRequest;
import com.jwt.authentication.dto.SignUpRequest;
import com.jwt.authentication.model.User;


public interface AuthenticationService {
	
	User signUp(SignUpRequest signUpRequest);
	JwtAuthenticationResponse signin(SignInRequest signInRequest);
	JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) ;	
	//JwtAuthenticationResponse refreshToken(RefreshTokenResponse refreshTokenResponse);

}
