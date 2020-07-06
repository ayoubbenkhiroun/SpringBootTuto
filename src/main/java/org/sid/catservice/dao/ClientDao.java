package org.sid.catservice.dao;

import java.util.List;
import org.sid.catservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{
	@RestResource(path = "/byNom")
	public List<Client> findByNomContains(@Param("mc") String nom);
}
