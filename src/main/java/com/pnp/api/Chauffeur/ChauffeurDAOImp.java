package com.pnp.api.Chauffeur;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;
@Repository
public class ChauffeurDAOImp  implements ChauffeurDAO{
	Session session = null;
	public ChauffeurDAOImp() {
		session = Connection.getSession();

	}
	@Override
	public List<Chauffeur> getTous() {
		List<Chauffeur> list = (List<Chauffeur>) session.createQuery("from Chauffeur").list();
				if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterChauffeur(Chauffeur Chauffeur) throws Exception {
		int a = 0;
		try {
			Transaction tx = session.beginTransaction();
		 session.save(Chauffeur);
			tx.commit();
		} catch (Exception e) {
throw new Exception();
		}		
	}

	@Override
	public void supprimerChauffeur(String id) {
		try {
			Transaction tx = session.beginTransaction();
			Chauffeur Chauffeur = session.get(Chauffeur.class, id);
			session.delete(Chauffeur);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}		
	}

	@Override
	public Chauffeur getChauffeurid(String id) {
		Chauffeur Chauffeur = (Chauffeur) session.createQuery("from Chauffeur where id='" +id+"'").getSingleResult();
		if (Chauffeur != null) {
			return Chauffeur;
		} else
			return null;
	}

}
