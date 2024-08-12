package com.jwt.authentication.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.authentication.service.JWTService;
import com.jwt.authentication.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	public static String CURRENT_USER="";
	
	@Autowired
	private JWTService jwtService;
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String userEmail;
		System.out.println("token:"+authHeader);
		System.out.println("doFilterInternal:"+StringUtils.isEmpty(authHeader));
		if (StringUtils.isEmpty(authHeader)
				|| !org.apache.commons.lang3.StringUtils.startsWith(authHeader, "Bearer ")) {
			System.out.println("org.apache.commons.lang3.StringUtils.startsWith(authHeader, \"Bearer \")"+org.apache.commons.lang3.StringUtils.startsWith(authHeader, "Bearer "));
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring(7);
		userEmail = jwtService.extractUserName(jwt);
		CURRENT_USER = userEmail;
		System.out.println(userEmail);
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);

			System.out.println((jwtService.isTokenValid(jwt, userDetails)) );
			
			if (jwtService.isTokenValid(jwt, userDetails)) {
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				securityContext.setAuthentication(token);
				SecurityContextHolder.setContext(securityContext);
			}
		}

		filterChain.doFilter(request, response);

	}

	public JWTService getJwtService() {
		return jwtService;
	}

	public UserService getUserService() {
		return userService;
	}

}
