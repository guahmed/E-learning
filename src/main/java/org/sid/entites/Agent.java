package org.sid.entites;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity

public class Agent implements Serializable{
	
	
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
	
	@ManyToOne
	private Institut institut;
	

}
