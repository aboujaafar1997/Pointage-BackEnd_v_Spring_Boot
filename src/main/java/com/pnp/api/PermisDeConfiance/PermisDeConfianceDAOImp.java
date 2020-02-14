package com.pnp.api.PermisDeConfiance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.Chauffeur.Chauffeur;
import com.pnp.api.Chauffeur.ChauffeurDAOImp;
import com.pnp.api.hibernateSinglton.Connection;

@Repository
public class PermisDeConfianceDAOImp implements PermisDeConfianceDAO {
	Session session = null;

	public PermisDeConfianceDAOImp() {
		session = Connection.getSession();

	}

	@Override
	public List<PermisDeConfiance> getTous() {
		List<PermisDeConfiance> list = (List<PermisDeConfiance>) session.createQuery("from PermisDeConfiance").list();
		if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterPermisDeConfiance(PermisDeConfiance PermisDeConfiance) {
		int a = 0;
		try {
			Transaction tx = session.beginTransaction();
			a = (Integer) session.save(PermisDeConfiance);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de ajouter PermisDeConfiance il'ya ereur sur:" + e.getMessage());
		}
	}

	@Override
	public void supprimerPermisDeConfiance(int id) {
		Transaction tx = session.beginTransaction();
		try {
			PermisDeConfiance PermisDeConfiance = session.get(PermisDeConfiance.class, id);
			session.delete(PermisDeConfiance);
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}
		finally {
			tx.commit();
		}
	}

	@Override
	public PermisDeConfiance getPermisDeConfianceid(int id) {
		PermisDeConfiance PermisDeConfiance = (PermisDeConfiance) session
				.createQuery("from PermisDeConfiance where id=" + id).getSingleResult();
		if (PermisDeConfiance != null) {
			return PermisDeConfiance;
		} else
			return null;
	}

	@Override
	public void threadcheck() throws ParseException {
		List<PermisDeConfiance> list = (List<PermisDeConfiance>) session.createQuery("from PermisDeConfiance").list();

		for(PermisDeConfiance p:list) {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        	 String sDate2 = formatter.format(LocalDate.now()); 
			 String sDate12 = p.getDateexp();  

			    SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");  
			    Date date3=formatter2.parse(sDate2); 
			    Date date4=formatter2.parse(sDate12); 
			    if (date3.compareTo(date4)==1) {
			 System.err.println("le Thread de is valide ...... ");
			    	Transaction tx = session.beginTransaction();
			    	String hqlUpdate = "update PermisDeConfiance c set c.isvalide = :newName where c.id = :oldName";
			    	int updatedEntities = session.createQuery( hqlUpdate )
			    	        .setString( "newName", "false" )
			    	        .setInteger( "oldName", p.getId() )
			    	        .executeUpdate();
			    	tx.commit();
			    	session.close();
			    }
			    
			    
			    
			    
		}
		
		
		
	}
	
 public Chauffeur getdatafrompermis(int id) {
	 
	return new ChauffeurDAOImp().getChauffeurid(getPermisDeConfianceid(id).getIdchauffeur());
	 
 }
	
	

}
