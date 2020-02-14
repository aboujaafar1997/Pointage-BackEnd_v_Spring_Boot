package com.pnp.api.PermisDeConfiance;

import java.text.ParseException;
import java.util.List;

import com.pnp.api.Chauffeur.Chauffeur;
import com.pnp.api.PermisDeConfiance.PermisDeConfiance;

public interface PermisDeConfianceDAO {
	public List<PermisDeConfiance> getTous();
	void ajouterPermisDeConfiance(PermisDeConfiance PermisDeConfiance);
	void supprimerPermisDeConfiance(int id);
	PermisDeConfiance getPermisDeConfianceid(int id);
	void threadcheck() throws ParseException;
	Chauffeur getdatafrompermis(int id);
}
