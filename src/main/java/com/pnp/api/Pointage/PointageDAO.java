package com.pnp.api.Pointage;

import java.util.List;


public interface PointageDAO {
	public List<Pointage> getTous();
	void ajouterPointage(Pointage Pointage) throws InterruptedException;
	void supprimerPointage(int id1,int id2,String date);
	Pointage getPointageid(int id);
}
