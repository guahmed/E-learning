package org.sid.dao;

import org.sid.entites.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource

public interface StudentDao extends JpaRepository<Student ,Long >
{
	public Student findByName(String name);
	public Student findByEmail(String email);
}
