package org.sid.service;


import java.io.Serializable;

import org.sid.dao.StudentDao;
import org.sid.entites.Student;
import org.sid.exception.ChangePasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChangePassword implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2125637891504343225L;

	@Autowired
	private StudentDao studentDao;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private GetLoggedUser getLoggedUser;
	
	@Transactional
	public void CheckAndSavePassword
	
	(String OldPassword,String NewPassword,
			String ConfirmPassWord )   {
		
		//uncomplete must be changed to the logged Users
		
		Student student=studentDao.findByEmail(getLoggedUser.getuser());

		if (bCryptPasswordEncoder.matches(OldPassword, student.getPassword())) {
			System.out.println("I am here");
			if (ConfirmPassWord.equals(NewPassword)) {
				
				student.setPassword(bCryptPasswordEncoder.encode(NewPassword));
				student.setConfirmPassword(ConfirmPassWord);
				studentDao.save(student);
				
			}else throw new ChangePasswordException("la confirmation du mot de pass est erroné");

		}else throw new  ChangePasswordException("L'ancien mot de pass est erroné");
		
	}

}
