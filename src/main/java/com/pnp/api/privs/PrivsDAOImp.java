package com.pnp.api.privs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;
@Repository

public class PrivsDAOImp implements PrivsDAO {
	Session session = null;

	public PrivsDAOImp() {
		session = Connection.getSession();

	}

	@Override
	public List<Privs> getTous() {
		List<Privs> list = (List<Privs>) session.createQuery("from Privs").list();
		
		if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterPrivs(Privs privs) {
		int a = 0;
		try {
			Transaction tx = session.beginTransaction();
			a = (Integer) session.save(privs);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de Ajouter il'ya ereur sur:" + a + e.getMessage());
		}
	}

	@Override
	public void supprimerPrivs(int id) {
		try {
			Transaction tx = session.beginTransaction();
			Privs Privs = session.get(Privs.class, id);
			session.delete(Privs);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}

	}

	@Override
	public Privs getPrivs(int id) {
		Privs Privs = (Privs)  session.createQuery("from Privs where id="+id).getSingleResult();
		if (Privs != null) {
			return Privs;
		} else
			return null;
	}

}
