package dev.sgpapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.sgpapi.entite.Departement;
import dev.sgpapi.repository.DepartementRepository;

@Controller
@RequestMapping("/api/departements")
public class DepartementController {

	@Autowired
	DepartementRepository departementRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Departement> listerDepartement() {
		return departementRepository.findAll();
	}
}