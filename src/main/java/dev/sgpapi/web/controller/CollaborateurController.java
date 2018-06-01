package dev.sgpapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Banque;
import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.repository.BanqueRepository;
import dev.sgpapi.repository.CollaborateurRepository;
import dev.sgpapi.repository.DepartementRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	CollaborateurRepository collaborateurRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	BanqueRepository banqueRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> listerCollaborateur() {
		return collaborateurRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "departement" })
	public List<Collaborateur> listeCollaborateursByDepartement(@RequestParam("departement") Integer id) {
		return collaborateurRepository.findByDepartementId(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{matricule}")
	public Collaborateur collaborateurByMatricule(@PathVariable("matricule") String matricule) {
		return collaborateurRepository.findByMatricule(matricule);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{matricule}/banque")
	public Banque coordonneeBancaire(@PathVariable("matricule") String matricule) {
		int id = collaborateurRepository.findByMatricule(matricule).getId();
		return banqueRepository.getOne(id);

	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}")
	public void collaborateurAJour(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		collaborateur.setId(collaborateurRepository.findByMatricule(matricule).getId());
		collaborateurRepository.save(collaborateur);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}/banque")
	public void banqueAJour(@PathVariable String matricule, @RequestBody Banque banque) {
		int id = collaborateurRepository.findByMatricule(matricule).getId();
		banque.setId(banqueRepository.getOne(id).getId());
		banqueRepository.save(banque);
	}
}
