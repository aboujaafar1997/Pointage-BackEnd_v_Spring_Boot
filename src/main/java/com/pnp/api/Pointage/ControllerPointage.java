package com.pnp.api.Pointage;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.api.PermisDeConfiance.PermisDeConfianceDAO;




@RestController
@RequestMapping(value = "/api/Pointage")
public class ControllerPointage {
	@Autowired
    private PointageDAO PointageDAO;
	@Autowired
    private PermisDeConfianceDAO permis;
	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter/tab", method=RequestMethod.POST)
    public  void  ajouterPointage(@RequestBody Pointage [] Pointage0) throws InterruptedException {
	int i=0;
		for (Pointage pointage2 : Pointage0) {
			System.out.println(++i);
			Thread.sleep(1000);
		String valide = permis.getPermisDeConfianceid(pointage2.getId_permis()).getIsvalide(); 
		System.err.println("-****************"+valide+Pointage0.length+"**************************-");
System.err.println(pointage2.getId_taxi());
		if(valide.equals("true")) {
	PointageDAO.ajouterPointage(pointage2);
//	return new ResponseEntity<>(" successfully", HttpStatus.OK);
		
		}
//		else {
////			return new ResponseEntity<>("ereur", HttpStatus.NOT_FOUND);
//		} 
		}
//		return new ResponseEntity<>("ereur", HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public  ResponseEntity<Object>  ajouterPointage(@RequestBody Pointage Pointage) throws InterruptedException {
		String valide = permis.getPermisDeConfianceid(Pointage.getId_permis()).getIsvalide(); 
		System.err.println("-****************"+valide+"**************************-");
		if(valide.equals("true")) {
	PointageDAO.ajouterPointage(Pointage);
	return new ResponseEntity<>(" successfully", HttpStatus.OK);
		
		}
		else {
			return new ResponseEntity<>("ereur", HttpStatus.NOT_FOUND);
		} 
		
		
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public List<Pointage> AllPointage() {
	return PointageDAO.getTous();
}

	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id1}/{id2}/{date}", method=RequestMethod.POST)
    public void SuprimerPointage(@PathVariable int id1 ,@PathVariable int id2 ,@PathVariable String date) {
		PointageDAO.supprimerPointage(id1,id2,date);
}
}