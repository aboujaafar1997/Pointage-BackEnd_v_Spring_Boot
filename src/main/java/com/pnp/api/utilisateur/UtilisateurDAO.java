package com.pnp.api.utilisateur;

import java.util.List;


public interface UtilisateurDAO {

	public List<Utilisateur> getTous();
	void ajouterUtilisateur(Utilisateur utilisateur);
	void supprimerUitilisateur(String id);
	Utilisateur getUtilisateur(String nom, String mdp);
	Utilisateur getUtilisateurid(String id);
	Utilisateur utilisateurbynom (String username);

}
