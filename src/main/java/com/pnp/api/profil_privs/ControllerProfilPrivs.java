package com.pnp.api.profil_privs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.api.privs.*;
import com.pnp.api.privs.PrivsDAOImp;
import com.pnp.api.profil.*;
import com.pnp.api.profil.ProfilDAOImp;

@RestController
@RequestMapping(value = "/api/ProfilPrivs")
public class ControllerProfilPrivs {
	@Autowired
	private ProfilPrivsDAO ProfilPrivsDAO;
	@Autowired
	private ProfilDAO ProfilDAO;
	@Autowired
	private PrivsDAO PrivsDAO;

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/ajouter/{idprofil}/{idprivs}", method = RequestMethod.POST)
	public void ajouterProfilPrivs(@PathVariable int idprofil ,@PathVariable int idprivs) {
		try {Privs privs= PrivsDAO.getPrivs(idprivs);
		Profil profil= ProfilDAO.getProfil(idprofil);
		profil.ajouterList(privs);
		ProfilDAO.ajouterProfil(profil);}catch(Exception e){System.out.println("Ereur : "+e);}
		
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<ProfilPrivs> AllProfilPrivs() throws InterruptedException {
		
		return ProfilPrivsDAO.getTous();
	}
	
	
	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/profilprivs/privs/{id}", method = RequestMethod.POST)
	public List<ProfilPrivs> getbyprofil(@PathVariable int id) {
		return ProfilPrivsDAO.getbyprofil(id);
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/supprimer/{id}/{id2}", method = RequestMethod.POST)
	public void SuprimerProfilPrivs(@PathVariable int id, @PathVariable int id2) {
		ProfilPrivsDAO.supprimerProfilPrivs(id, id2);
		System.err.println(id+"/"+id2);
	}
	

	
}
