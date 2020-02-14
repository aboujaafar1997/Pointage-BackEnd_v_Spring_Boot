package com.pnp.api.profil;

import java.util.List;

public interface ProfilDAO {
	public List<Profil> getTous();
	void ajouterProfil(Profil profil);
	void supprimerProfil(int id);
	Profil getProfil(String id);
	Profil getProfil(int id);
}
