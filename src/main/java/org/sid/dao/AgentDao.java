package org.sid.dao;

import org.sid.entites.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface AgentDao extends JpaRepository<Agent, Long>{

}
