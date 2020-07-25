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
	
	@Autowired
	private GetLoggedUser getLoggedUser;
	
	
	@Transactional
	public void ModifyProfilStudent(Student studentAfter) {
		
		
		Student student= studentDao.findByEmail(getLoggedUser.getuser());
		
		student.setName(studentAfter.getName());
		student.setLastName(studentAfter.getLastName());
		student.setAge(studentAfter.getAge());
		student.setIdCard(studentAfter.getIdCard());
		student.setAdress(studentAfter.getAdress());
		student.setPhoneNumber(studentAfter.getPhoneNumber());
		student.setExperience(studentAfter.getExperience());
		
		studentDao.save(student);
	}
	
}
