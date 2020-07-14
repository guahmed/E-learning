package org.sid.entites;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"teacher","listCourse","students"})
public class Session implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;	
	
	private	int price;
	private Date startingDate;
	private Date closingDate;
	private int hourNumber;
	private int maxStudentNumber;
	private String plan;
	private Blob image;
	
	@OneToOne(mappedBy = "session")
	private Teacher teacher;
	
	@OneToMany(mappedBy = "session")
	private List<Course> listCourse =new ArrayList<Course>();
	
	@ManyToMany(mappedBy = "sessions")
	private List<Student> students;
	
	@ManyToOne
	private Institut institut;
	
	
}
