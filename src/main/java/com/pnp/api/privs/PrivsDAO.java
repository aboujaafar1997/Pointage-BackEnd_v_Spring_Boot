package com.pnp.api.privs;

import java.util.List;


public interface PrivsDAO {	
	public List<Privs> getTous();
	void ajouterPrivs(Privs privs);
	void supprimerPrivs(int id);
	Privs getPrivs(int id);
}
