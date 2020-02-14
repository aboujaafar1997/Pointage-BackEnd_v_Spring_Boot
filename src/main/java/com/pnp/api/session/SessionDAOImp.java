package com.pnp.api.session;

import java.util.List;


import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;
@Repository
public class SessionDAOImp implements SessionDAO {
	org.hibernate.Session session = null;
	public SessionDAOImp() {
		session = Connection.getSession();

	}
	@Override
	public List<Session> getTous() {
		List<Session> list = (List<Session>) session.createQuery("from Session").list();
				if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public int ajouterSession(Session Session) throws InterruptedException {
		Thread.sleep(1000);
		int a = 0;
		try {
			Transaction tx = session.beginTransaction();
		 a = (Integer) session.save(Session);
			tx.commit();
			System.err.println("ID :"+a);
			return a;
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur sur:"+a+ e.getMessage());
		}	
		return 0;
	}

	@Override
	public void supprimerSession(int id) {
		try {
			Transaction tx = session.beginTransaction();
			Session Session = session.get(Session.class, id);
			session.delete(Session);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}		
	}

	@Override
	public Session getSession(int id) {
		Session Session = (Session) session.createQuery("from Session where id=" + id).getSingleResult();
		if (Session != null) {
			return Session;
		} else
			return null;
	}

}
