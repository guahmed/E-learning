package org.sid.dao;

import org.sid.entites.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource

public interface PlaceDao extends JpaRepository<Place, Long>{

}
