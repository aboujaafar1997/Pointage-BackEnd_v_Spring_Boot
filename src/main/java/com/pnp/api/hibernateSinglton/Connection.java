package com.pnp.api.hibernateSinglton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pnp.api.Chauffeur.Chauffeur;
import com.pnp.api.Jouranal.Journal;
import com.pnp.api.PermisDeConfiance.PermisDeConfiance;
import com.pnp.api.Pointage.Pointage;
import com.pnp.api.Taxi.Taxi;
import com.pnp.api.privs.Privs;
import com.pnp.api.profil.Profil;
import com.pnp.api.profil_privs.ProfilPrivs;
import com.pnp.api.utilisateur.Utilisateur;

public class Connection {
private  static  Session session=null ;

	private  Connection() {
}
	
	public static synchronized  Session getSession() {
		if (session==null) {
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.addAnnotatedClass(Profil.class)
				.addAnnotatedClass(Privs.class)
				.addAnnotatedClass(ProfilPrivs.class)
				.addAnnotatedClass(Journal.class)
				.addAnnotatedClass(Pointage.class)
				.addAnnotatedClass(Chauffeur.class)
				.addAnnotatedClass(Taxi.class)
				.addAnnotatedClass(PermisDeConfiance.class)
				.addAnnotatedClass(com.pnp.api.session.Session.class)
				.buildSessionFactory();
    	 session = factory.openSession();
    	 return session;
		}
		else  return session;

		
	}
}
