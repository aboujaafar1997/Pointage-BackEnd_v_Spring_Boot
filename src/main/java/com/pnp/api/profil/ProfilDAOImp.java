package com.pnp.api.profil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;
import com.pnp.api.privs.Privs;
import com.pnp.api.privs.PrivsDAO;
import com.pnp.api.privs.PrivsDAOImp;
import com.pnp.api.profil_privs.ProfilPrivsDAOImp;

@Repository
public class ProfilDAOImp implements ProfilDAO {
	Session session = null;
	@Autowired 
	PrivsDAO PrivsDAO;

	public ProfilDAOImp() {
		session = Connection.getSession();

	}

	@Override
	public synchronized List<Profil> getTous() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Profil> list = (List<Profil>) session.createQuery("from Profil").list();
		if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterProfil(Profil profil) {
		System.err.println(" profil :" + profil.getNom());
		try {
			Transaction tx = session.beginTransaction();
		    session.save(profil);
			tx.commit();
			Thread.sleep(200);
			for (Privs p : profil.getPrivslist()) {
				Privs myprivs =PrivsDAO.getPrivs(p.getId());
				System.err.println(" privs :" + myprivs.getNom());
				profil.ajouterList(myprivs);
			}
			Thread.sleep(200);
			Transaction tx2 = session.beginTransaction();
			session.save(profil);
			tx2.commit();

		} catch (Exception e) {

			System.err.println("warning peut etre  il'ya ereur sur:" + e.getMessage());
		}
	}

	@Override
	public void supprimerProfil(int id) {
		try {
			Transaction tx = session.beginTransaction();
			Profil profil = session.get(Profil.class, id);
			session.delete(profil);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}
	}

	@Override
	public synchronized Profil getProfil(String nom) {
		try {
			
			Thread.sleep(300);
		
		Profil profil = (Profil) session.createQuery("from Profil where nom='" + nom + "'").getSingleResult();
		if (profil != null) {
			return profil;
		} else
			return null;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
	}

	@Override
	public synchronized Profil getProfil(int id) {
		try {
			Thread .sleep(300);
			Profil profil = (Profil) session.createQuery("from Profil where id=" + id).getSingleResult();
			if (profil != null) {
				return profil;
			} else
				return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}

}
