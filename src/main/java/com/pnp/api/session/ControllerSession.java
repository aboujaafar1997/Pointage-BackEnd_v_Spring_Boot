package com.pnp.api.session;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/api/Session")
public class ControllerSession {
	@Autowired
    private SessionDAO SessionDAO;
	

	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter/tab", method=RequestMethod.POST)
    public void ajouterSession(@RequestBody Session [] Session) throws InterruptedException {
	
		for (Session session2 : Session) {
			Thread.sleep(200);
			int id =SessionDAO.ajouterSession(session2);
		}
	
}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public int ajouterSession(@RequestBody Session Session) throws InterruptedException {
	int id =SessionDAO.ajouterSession(Session);
	return id;
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public List<Session> AllSession() {
	return SessionDAO.getTous();	
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id}", method=RequestMethod.POST)
    public void SuprimerSession(@PathVariable int id) {
		SessionDAO.supprimerSession(id);
}
}