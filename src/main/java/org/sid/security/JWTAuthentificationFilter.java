package org.sid.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sid.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	
	
	
	public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
		// TODO Auto-generated constructor stub
		super();
		this.authenticationManager=authenticationManager;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		Student student = null;
		
		try {
			student = new ObjectMapper().readValue(request.getInputStream(), Student.class);
		}catch(Exception e ) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return (
				authenticationManager.
					authenticate
						(new UsernamePasswordAuthenticationToken
								(student.getName(), student.getPassword())));
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		User springUser= (User) authResult.getPrincipal();
		
		String jwt=Jwts.builder().setSubject(springUser.getUsername()).
				setExpiration(new Date(System.currentTimeMillis()+SecurityConstant.EXPIRATION_TIME)).
				signWith(SignatureAlgorithm.HS256, SecurityConstant.SECRET).
				claim("roles", springUser.getAuthorities()).compact();
		response.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX+jwt);
		 
	}

}
