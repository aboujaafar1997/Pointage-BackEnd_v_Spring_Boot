package com.pnp.api.Chauffeur;

import java.util.List;


public interface ChauffeurDAO {
	public List<Chauffeur> getTous();
	void ajouterChauffeur(Chauffeur Chauffeur) throws Exception;
	void supprimerChauffeur(String id);
	Chauffeur getChauffeurid(String id);
}
