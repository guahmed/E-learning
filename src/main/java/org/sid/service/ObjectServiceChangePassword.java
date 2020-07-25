package org.sid.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ObjectServiceChangePassword {
	
	private String oldPassword;
	private String newPassword;
	private String confirmPassWord;
	
}