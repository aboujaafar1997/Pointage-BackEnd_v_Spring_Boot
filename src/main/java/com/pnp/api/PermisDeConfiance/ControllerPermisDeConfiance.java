package com.pnp.api.PermisDeConfiance;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.pnp.api.Chauffeur.Chauffeur;
import com.pnp.api.Pointage.Pointage;

@RestController
@RequestMapping(value = "/api/PermisDeConfiance")
public class ControllerPermisDeConfiance {
	@Autowired
	private PermisDeConfianceDAO PermisDeConfianceDAO;

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/affiche/{id}", method = RequestMethod.POST)
	public Chauffeur affiche(@PathVariable int id) {
		return PermisDeConfianceDAO.getdatafrompermis(id);
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public void ajouterPermisDeConfiance(@RequestBody PermisDeConfiance PermisDeConfiance) {
		PermisDeConfianceDAO.ajouterPermisDeConfiance(PermisDeConfiance);
	}
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<PermisDeConfiance> AllgetPermisDeConfiance() {
	return PermisDeConfianceDAO.getTous();
}
	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<PermisDeConfiance> AllPermisDeConfiance() {
		return PermisDeConfianceDAO.getTous();
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.POST)
	public void SuprimerPermisDeConfiance(@PathVariable int id) {
		PermisDeConfianceDAO.supprimerPermisDeConfiance(id);
	}

	@CrossOrigin(origins = { "http://localhost:3000" })
	@RequestMapping(value = "/pdf/{id}/{permis}", method = RequestMethod.POST, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> uploadFile(@PathVariable String id,@PathVariable int permis)
			throws IOException, DocumentException {
		new Imprission(id,permis);
		try {
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ClassPathResource pdfFile = new ClassPathResource("pdf/" + id + ".pdf");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename= pnp");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(pdfFile.contentLength());
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
		return response;
	}

}