package com.pnp.api.utilisateur;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;

@Repository
public class UtilisateurDAOImp implements UtilisateurDAO {

	Session session = null;



	public UtilisateurDAOImp() {
		session = Connection.getSession();
	}

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		try {
			
			Transaction tx = session.beginTransaction();

			 session.save(utilisateur);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible il'ya ereur:" + e.getMessage());
		}
	}

	@Override
	public void supprimerUitilisateur(String nom) {
		try {
			
			Transaction tx = session.beginTransaction();
			Utilisateur utilisateur = (Utilisateur) session
					.createQuery("from Utilisateur where nom_de_utilisateur='" + nom + "'")
					.getSingleResult();
			session.delete(utilisateur);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible  il'ya ereur:" + e.getMessage());
		}
	}

	@Override
	public Utilisateur getUtilisateur(String nom, String mdp) {
		Utilisateur utilisateur = (Utilisateur) session
				.createQuery("from Utilisateur where nom_de_utilisateur='" + nom + "' and mdp='" + mdp + "'")
				.getSingleResult();

		if (utilisateur != null) {
			return utilisateur;
		} else
			return null;
	}

	@Override
	public List<Utilisateur> getTous() {
		List<Utilisateur> list = (List<Utilisateur>) session.createQuery("from Utilisateur").list();
		if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public Utilisateur getUtilisateurid(String id) {
		Utilisateur utilisateur = (Utilisateur) session.createQuery("from Utilisateur where id='"+ id+"'")
				.getSingleResult();
		if (utilisateur != null) {
			return utilisateur;
		} else
			return null;
	}

	@Override
	public synchronized Utilisateur  utilisateurbynom(String username) {

		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utilisateur utilisateur = (Utilisateur) session
				.createQuery("from Utilisateur where nom_de_utilisateur='" + username + "'").getSingleResult();

		if (utilisateur != null) {
			return utilisateur;
		} else
			return null;
	}

}
