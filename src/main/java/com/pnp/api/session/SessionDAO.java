package com.pnp.api.session;

import java.util.List;

public interface SessionDAO {
	public List<Session> getTous();
	int ajouterSession(Session Session) throws InterruptedException;
	void supprimerSession(int id);
	Session getSession(int id);
}
