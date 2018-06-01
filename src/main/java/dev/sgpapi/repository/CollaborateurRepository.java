package dev.sgpapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	// eviter getOne(id), passer directement id en paramètre.
	public List<Collaborateur> findByDepartementId(Integer departementId);

	public Collaborateur findByMatricule(String matricule);

}
