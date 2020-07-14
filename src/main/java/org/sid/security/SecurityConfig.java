package org.sid.security;

import javax.sql.DataSource;

import org.hibernate.boot.model.relational.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin("*")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//auth.inMemoryAuthentication().withUser("ahmed").password("{noop}123456").roles("Student");
	   //
		auth.inMemoryAuthentication().withUser("karim").password(bCryptPasswordEncoder.encode("1234567")).roles("ADMIN");
		
		//auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		
	System.out.print("pass"+bCryptPasswordEncoder.encode("123456")+"pass");
	
	}

	
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
		
		//*****************************    
		//  http.authorizeRequests().antMatchers("/login").permitAll().and().httpBasic();
		  //http.authorizeRequests().anyRequest().authenticated();
		//*****************************  
		  
		  //http.csrf().disable();
		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	//	 http.authorizeRequests().antMatchers("/login/**").permitAll();
	//	 http.authorizeRequests().antMatchers("/student/**").hasAuthority("student");
	//	  http.authorizeRequests().anyRequest().authenticated();
	  
	//	  http.addFilter(new JWTAuthentificationFilter(authenticationManager()));
	//	  http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
		  
	  }
	 
	  ///student/getStudentinfo/1 
	  /*
	   * Authorization:
	   *  Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaG1lZCIsImV4cCI6MTU5MDgxMTA3Miwicm9sZXMiOlt7ImF1dGhvcml0eSI6InN0dWRlbnQifV19.eQJJqABkZrARgswIA9rO6FzuQ4Ce3IG4WNsBwTOX9Jg
	   * */
	
	
}
