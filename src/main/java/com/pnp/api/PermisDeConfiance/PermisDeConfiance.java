package com.pnp.api.PermisDeConfiance;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permis_conf")
public class PermisDeConfiance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "int(255)")
	private int id;
	@Column(name = "date_del", columnDefinition = "varchar(30)")
	private String datedel;
	@Column(name = "date_exp", columnDefinition = "varchar(30)")
	private String dateexp;
	@Column(name = "n_tage", columnDefinition = "int(255)")
	private int ntage;
	public PermisDeConfiance() {
		// TODO Auto-generated constructor stub
	}
	public PermisDeConfiance( int ntage, String idchauffeur) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		String date= formatter.format(LocalDate.now());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
		   c.setTime(sdf.parse(date));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		c.add(Calendar.YEAR,5);  
		String newDate = sdf.format(c.getTime());  
		System.out.println("Date after Addition: "+newDate);		
		this.datedel = date;
		this.dateexp = newDate;
		this.ntage = ntage;
		this.isvalide = "true";
		this.idchauffeur = idchauffeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatedel() {
		return datedel;
	}

	public void setDatedel(String datedel) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		String date= formatter.format(LocalDate.now());	
		this.datedel = date;
		
	}

	public String getDateexp() {
		return dateexp;
	}

	public void setDateexp(String dateexp) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		String date= formatter.format(LocalDate.now());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
		   c.setTime(sdf.parse(date));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		c.add(Calendar.YEAR,5);  
		String newDate = sdf.format(c.getTime());  
		this.dateexp = newDate;
		
	}

	public int getNtage() {
		return ntage;
	}
	public void setNtage(int ntage) {
		this.ntage = ntage;
	}
	public String getIsvalide() {
		return isvalide;
	}
	public void setIsvalide(String isvalide) {
		this.isvalide = isvalide;
	}
	public String getIdchauffeur() {
		return idchauffeur;
	}
	public void setIdchauffeur(String idchauffeur) {
		this.idchauffeur = idchauffeur;
	}
	@Column(name = "is_valide", columnDefinition = "varchar(5)")
	private String isvalide;
	@Column(name = "id_chauffeur", columnDefinition = "varchar(25)")
	private String idchauffeur;
}
