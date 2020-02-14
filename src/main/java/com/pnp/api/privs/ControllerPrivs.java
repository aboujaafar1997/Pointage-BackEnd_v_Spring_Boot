package com.pnp.api.privs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/Privs")
public class ControllerPrivs {
	@Autowired
    private PrivsDAO privsDAO;
	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public void ajouterPrivs(@RequestBody Privs Privs) {
		privsDAO.ajouterPrivs(Privs);
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public List<Privs> AllPrivs() {
	return privsDAO.getTous();
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id}", method=RequestMethod.POST)
    public void SuprimerPrivs(@PathVariable int id) {
		privsDAO.supprimerPrivs(id);
}
	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/get/{id}", method=RequestMethod.POST)
    public Privs privs(@PathVariable int id) {
		return privsDAO.getPrivs(id);
}
	
}
