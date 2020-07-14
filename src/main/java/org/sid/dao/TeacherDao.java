package org.sid.dao;

import org.sid.entites.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface TeacherDao extends JpaRepository<Teacher, Long>{

}
