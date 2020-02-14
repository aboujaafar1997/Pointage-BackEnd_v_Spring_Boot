package com.pnp.api.Jouranal;

import java.util.List;


public interface JournalDAO {
	public List<Journal> getTous();
	void ajouterJournal(Journal Journal);
	void supprimerJournal(int id);
	Journal getJournal(int id);
}
