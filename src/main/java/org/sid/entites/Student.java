package org.sid.entites;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastName;
	private int age;
	private String idCard;
	private String password;
	private String confirmPassword;
	
	private String adress;
	private String phoneNumber;
	private String experience;
	
	private String email;
	private String role;
	private Blob photo;
	
	@ManyToMany
	private List<Session> sessions;
	


	
	
	
}
