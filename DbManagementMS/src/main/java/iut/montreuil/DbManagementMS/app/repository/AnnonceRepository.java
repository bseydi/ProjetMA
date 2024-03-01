package iut.montreuil.DbManagementMS.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iut.montreuil.DbManagementMS.app.model.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	
	public List<Annonce>findAll();
}
