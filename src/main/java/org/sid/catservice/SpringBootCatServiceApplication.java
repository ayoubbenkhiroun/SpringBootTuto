package org.sid.catservice;

import org.sid.catservice.dao.ClientRepository;
import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.entities.Client;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class SpringBootCatServiceApplication implements CommandLineRunner{
	
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootCatServiceApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"Ordinateur Lx45",6700,3));
		produitRepository.save(new Produit(null,"Imprimante HP",1700,3));
		produitRepository.save(new Produit(null,"Smartphone Samsung S9",8000,13));
		
		clientRepository.save(new Client(null,"Ayoub Ben Khiroun","(+216) 22 311 580","ayoub.benkhiroun@gmail.com", 5.2, "Rue Brasilia", "8000", "Nabeul"));
		
		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
	}
	
}
