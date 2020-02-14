package com.pnp.api.profil_privs;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;
import com.pnp.api.profil.Profil;
@Repository
public class ProfilPrivsDAOImp implements ProfilPrivsDAO {
	Session session = null;
	public ProfilPrivsDAOImp() {
		session = Connection.getSession();

	}
	@Override
	public List<ProfilPrivs> getTous() throws InterruptedException {
		Thread.sleep(1000);
		List<ProfilPrivs> list = (List<ProfilPrivs>) session.createQuery("from ProfilPrivs").list();
				if (list != null) {
			return list;
		} else
			return null;
	}
	
	@Override
	public List<ProfilPrivs> getbyprofil(int id) {
		List<ProfilPrivs> list = (List<ProfilPrivs>) session.createQuery("from ProfilPrivs where id_profil="+id).list();
				if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterProfilPrivs(ProfilPrivs ProfilPrivs) {
		int a = 0;
		try {
			Transaction tx = session.beginTransaction();
		 a = (Integer) session.save(ProfilPrivs);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible il'ya ereur sur:"+ e.getMessage());
		}		
	}

	@Override
	public void supprimerProfilPrivs(int idprofil , int idprivs ) {
		try {
			Transaction tx = session.beginTransaction();
			ProfilPrivs ProfilPrivs0 = (ProfilPrivs) session.createQuery("from ProfilPrivs WHERE id_profil="+idprofil+" and id_privs="+idprivs).getSingleResult();
			session.delete(ProfilPrivs0);
			tx.commit();
			Thread.sleep(200);
		
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}		
	}

	@Override
	public ProfilPrivs getProfilPrivs(int id) {
		ProfilPrivs ProfilPrivs = (ProfilPrivs) session.createQuery("from ProfilPrivs where id=" + id).getSingleResult();
		if (ProfilPrivs != null) {
			return ProfilPrivs;
		} else
			return null;
	}

}