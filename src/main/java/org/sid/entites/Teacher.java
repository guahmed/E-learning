package org.sid.entites;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Teacher implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastName;
	private int age;
	private String idCard;
	private String password;
	private String confirmPassword;
	private String speciality;
	
	private String adress;
	private String phoneNumber;
	private String experience;
	
	private String email;
	private String role;
	private Blob photo;
	
	@OneToOne
	private Session session;
		

}
