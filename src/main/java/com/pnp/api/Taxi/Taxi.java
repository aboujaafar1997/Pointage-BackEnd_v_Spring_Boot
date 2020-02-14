package com.pnp.api.Taxi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxi")
public class Taxi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "int(255)")
	private int id;
	@Column(name = "matricule", columnDefinition = "varchar(35)")
	private String matricule;
	@Column(name = "modele", columnDefinition = "varchar(35)")
	private String modele;
	public Taxi() {
		// TODO Auto-generated constructor stub
	}
	public Taxi(String matricule, String modele) {
		this.matricule = matricule;
		this.modele = modele;
	}
	
	@Override
	public String toString() {
		return "Taxi [id=" + id + ", matricule=" + matricule + ", modele=" + modele + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
}
