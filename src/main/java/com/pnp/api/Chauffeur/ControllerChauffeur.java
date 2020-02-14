package com.pnp.api.Chauffeur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
@RequestMapping(value = "/api/Chauffeur")
public class ControllerChauffeur {
	@Autowired
	private ChauffeurDAO ChauffeurDAO;
//	@CrossOrigin(origins = {"http://localhost:3000"})
//    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
//    public ResponseEntity<Object> ajouterChauffeur(@RequestBody Chauffeur Chauffeur) {
//	try {
//		ChauffeurDAO.ajouterChauffeur(Chauffeur);
//		return new ResponseEntity<>(" successfully", HttpStatus.OK);
//	} catch (Exception e) {
//		return new ResponseEntity<>("ereur", HttpStatus.NOT_FOUND);
//	}
//	
//}
//	

	@RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ResponseEntity<Object> upload(@RequestPart("Chauffeur") @Valid Chauffeur Chauffeur,
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) throws IOException {
		try {
			System.out.println(Chauffeur);
			System.out.println("Uploaded File: ");
			System.out.println("Name : " + file.getName());
			System.out.println("Type : " + file.getContentType());
			System.out.println("Name : " + file.getOriginalFilename());
			System.out.println("Size : " + file.getSize());
			File convertFile = new File("image\\" + Chauffeur.getCin() + file.getOriginalFilename());
			File convertFile2 = new File("public\\image\\" + Chauffeur.getCin() + file.getOriginalFilename());
			Chauffeur.setImage("image\\" + Chauffeur.getCin() + file.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();

			convertFile2.createNewFile();
			FileOutputStream fout2 = new FileOutputStream(convertFile2);
			fout2.write(file.getBytes());
			fout2.close();
			ChauffeurDAO.ajouterChauffeur(Chauffeur);
			return new ResponseEntity<>(" successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ereur", HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<Chauffeur> AllChauffeur() {
		return ChauffeurDAO.getTous();
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Chauffeur> AllgetChauffeur() {
		return ChauffeurDAO.getTous();
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.POST)
	public void SuprimerChauffeur(@PathVariable String id) {
		ChauffeurDAO.supprimerChauffeur(id);
	}
}