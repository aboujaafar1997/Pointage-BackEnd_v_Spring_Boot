package com.pnp.api.profil_privs;

import java.util.List;


public interface ProfilPrivsDAO {
	public List<ProfilPrivs> getTous() throws InterruptedException;
	void ajouterProfilPrivs(ProfilPrivs ProfilPrivs);
	ProfilPrivs getProfilPrivs(int id);
	void supprimerProfilPrivs(int idprofil, int idprivs);
	public List<ProfilPrivs> getbyprofil(int id);
}
