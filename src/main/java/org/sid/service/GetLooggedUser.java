package org.sid.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class GetLooggedUser {

	
	public String getuser(){
		
		Object principal = SecurityContextHolder.getContext().
				getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			 String username = ((UserDetails)principal).getUsername();
			 return username;
		} else {
			String username = principal.toString();
			return username;
		}	
	
	}
}
