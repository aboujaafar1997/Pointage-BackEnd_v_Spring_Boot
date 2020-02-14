package com.pnp.api.Jouranal;


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
@RequestMapping(value = "/api/Journal")
public class ControllerJournal {
	@Autowired
    private JournalDAO JournalDAO;
	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public void ajouterJournal(@RequestBody Journal Journal) throws InterruptedException {
		Thread.sleep(1000);
	JournalDAO.ajouterJournal(Journal);
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public synchronized List<Journal> AllJournal() {
	return JournalDAO.getTous();
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id}", method=RequestMethod.POST)
    public void SuprimerJournal(@PathVariable int id) {
		JournalDAO.supprimerJournal(id);
}
}