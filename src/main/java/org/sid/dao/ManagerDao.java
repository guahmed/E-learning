package org.sid.dao;

import org.sid.entites.Manager;
import org.sid.entites.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource

public interface ManagerDao extends JpaRepository<Manager, Long>{
	
	public Manager findByEmail(String email);

}
