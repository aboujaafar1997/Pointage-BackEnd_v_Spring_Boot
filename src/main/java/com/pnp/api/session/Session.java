package com.pnp.api.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="session")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int(255)")
	private int id;
	@Column(name = "id_utilisateur ",columnDefinition = "varchar(30)")
   private String idUtilisateur;
	@Column(name = "date ",columnDefinition = "varchar(30)")
   private String date ;
	@Column(name = "ip",columnDefinition = "varchar(40)")
   private String ip;
public Session(int id, String idUtilisateur, String date, String ip) {
	this.id = id;
	this.idUtilisateur = idUtilisateur;
	this.date = date;
	this.ip = ip;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getIdUtilisateur() {
	return idUtilisateur;
}
public void setIdUtilisateur(String idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public Session() {
	// TODO Auto-generated constructor stub
}
public Session(int id) {
this.id=id;
}
}
