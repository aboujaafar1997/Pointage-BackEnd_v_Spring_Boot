package com.pnp.api.profil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/api/profil")
public class ControllerProfil {
	@Autowired
    private ProfilDAO profilDAO;
	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public String ajouterProfil(@RequestBody Profil profil) {
	try {
		profilDAO.ajouterProfil(profil);
		return "ok";
		}
	catch (Exception e) {
		return null;
}
	
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public List<Profil> AllProfil() {
	return profilDAO.getTous();
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list/{name}", method=RequestMethod.POST)
    public Profil getProfil(@PathVariable String name) {
	return profilDAO.getProfil(name);
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id}", method=RequestMethod.POST)
    public void SuprimerProfil(@PathVariable int id) {
		profilDAO.supprimerProfil(id);
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/get/{id}", method=RequestMethod.POST)
    public Profil getProfil(@PathVariable int id) {
		return profilDAO.getProfil(id);
}
}