package com.pnp.api.Chauffeur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chauffeure")
public class Chauffeur {
	@Override
	public String toString() {
		return "Chauffeur [cin=" + cin + ", permisconduit=" + permisconduit + ", permisconfiance=" 
				+ ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + ", adresse=" + adresse
				+ ", image=" + image + "]";
	}
	@Id
	@Column(name = "cin", columnDefinition = "varchar(30)")
	private String cin;
	@Column(name = "n_permis_conduit", columnDefinition = "int(30)")
	private int permisconduit;
	@Column(name = "nom", columnDefinition = "varchar(35)")
	private String nom;
	@Column(name = "prenom", columnDefinition = "varchar(35)")
	private String prenom;
	@Column(name = "date_naissance", columnDefinition = "varchar(30)")
	private String datenaissance;
	@Column(name = "adresse", columnDefinition = "varchar(100)")
	private String adresse;
	@Column(name = "image", columnDefinition = "varchar(200)")
	private String image;
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Chauffeur() {
		// TODO Auto-generated constructor stub
	}
	public Chauffeur(String cin, int permisconduit,  String nom, String prenom,
			String date_naissance, String adresse) {
		this.cin = cin;
		this.permisconduit = permisconduit;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance= date_naissance;
		this.adresse = adresse;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public int getPermisconduit() {
		return permisconduit;
	}
	public void setPermisconduit(int permisconduit) {
		this.permisconduit = permisconduit;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDate_naissance() {
		return datenaissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.datenaissance = date_naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
