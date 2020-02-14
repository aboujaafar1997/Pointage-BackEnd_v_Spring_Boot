package com.pnp.api.utilisateur;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/api/Utilisateur")
public class ControllerUtilisateur {
	@Autowired
    private UtilisateurDAO UtilisateurDAO;
	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public void ajouterUtilisateur(@RequestBody Utilisateur Utilisateur) {
	UtilisateurDAO.ajouterUtilisateur(Utilisateur);
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public List<Utilisateur> AllUtilisateur() {
	return UtilisateurDAO.getTous();
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id}", method=RequestMethod.POST)
    public void SuprimerUtilisateur(@PathVariable String id) {
		System.out.println(id+"will be delete");
		UtilisateurDAO.supprimerUitilisateur(id);
}
}