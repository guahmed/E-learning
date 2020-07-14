package org.sid.dao;

import org.sid.entites.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource

public interface SessionDao extends JpaRepository<Session, Long> {

	public Session findByName(String name);
}
