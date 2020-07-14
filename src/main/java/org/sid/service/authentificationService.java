package org.sid.service;

import java.util.ArrayList;
import java.util.Collection;

import org.sid.dao.StudentDao;
import org.sid.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class authentificationService implements UserDetailsService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public UserDetails loadUserByUsername(String username) 
	
			throws UsernameNotFoundException {
		
	
		Student student = studentDao.findByName(username);
		if (student==null) throw new UsernameNotFoundException(username);
		
		
		SimpleGrantedAuthority simpleGrantedAuthority = 
				new SimpleGrantedAuthority(student.getRole()); 
		Collection<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(simpleGrantedAuthority);
		
		User user=new User(student.getName(),student.getPassword(),authorities);
		
		return user ;		
		
	}

}
