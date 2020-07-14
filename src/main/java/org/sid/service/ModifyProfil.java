package org.sid.service;

import org.sid.dao.StudentDao;
import org.sid.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ModifyProfil {

	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	public void ModifyProfilStudent(@RequestBody Student studentAfter) {
		
		 
		
	}
	
}
