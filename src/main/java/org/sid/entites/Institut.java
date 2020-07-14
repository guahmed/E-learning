package org.sid.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@JsonIgnoreProperties({"placeList","agentList","managerInstitut"})

public class Institut implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	
	
	@OneToMany(mappedBy = "institut")
	private List<Place> placeList = new ArrayList<Place>();
	
	@OneToMany(mappedBy = "institut")
	private List<Agent> agentList = new ArrayList<Agent>();
	
	@OneToOne(mappedBy = "institut")
	private Manager managerInstitut;
	
	
	@OneToMany(mappedBy = "institut")
	private List<Session> sessions;
	

}


	
