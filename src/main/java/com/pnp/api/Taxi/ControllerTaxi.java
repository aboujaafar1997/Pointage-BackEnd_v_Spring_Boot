package com.pnp.api.Taxi;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;





@RestController
@RequestMapping(value = "/api/Taxi")
public class ControllerTaxi {
	@Autowired
    private TaxiDAO TaxiDAO;
	
	@RequestMapping(value="/upload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ResponseEntity<Object> upload(
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) throws IOException {
		try {
		System.out.println("Uploaded File: ");
		System.out.println("Name : " + file.getName());
		System.out.println("Type : " + file.getContentType());
		System.out.println("Name : " + file.getOriginalFilename());
		System.out.println("Size : " + file.getSize());
		File convertFile = new File("exceluplaod\\" +new Date().getYear()+"_"+new Date().getMonth()+"_"+new Date().getDay()+"_"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		TaxiDAO.excel("exceluplaod\\" +new Date().getYear()+"_"+new Date().getMonth()+"_"+new Date().getDay()+"_"+file.getOriginalFilename());
			return new ResponseEntity<>(" successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ereur", HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public void ajouterTaxi(@RequestBody Taxi Taxi) {
	TaxiDAO.ajouterTaxi(Taxi);
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public List<Taxi> AllTaxi() {
	return TaxiDAO.getTous();
}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/supprimer/{id}", method=RequestMethod.POST)
    public void SuprimerTaxi(@PathVariable int id) {
		TaxiDAO.supprimerTaxi(id);
}
}