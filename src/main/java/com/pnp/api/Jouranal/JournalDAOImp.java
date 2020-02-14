package com.pnp.api.Jouranal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;


@Repository
public class JournalDAOImp implements JournalDAO {
	Session session = null;
	public JournalDAOImp() {
		session = Connection.getSession();

	}
	@Override
	public 	 List<Journal> getTous() {
		List<Journal> list = (List<Journal>) session.createQuery("from Journal").list();
				if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public synchronized void ajouterJournal(Journal Journal) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Transaction tx = session.beginTransaction();
		int a = 0;
		try {
		 session.save(Journal);
			tx.commit();
		} catch (Throwable t) {
			tx.rollback();
			throw t;
		}
	}

	@Override
	public void supprimerJournal(int id) {
		try {
			Transaction tx = session.beginTransaction();
			Journal Journal = session.get(Journal.class, id);
			session.delete(Journal);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}		
	}

	@Override
	public Journal getJournal(int id) {
		Journal Journal = (Journal) session.createQuery("from Journal where id=" + id).getSingleResult();
		if (Journal != null) {
			return Journal;
		} else
			return null;
	}

}
