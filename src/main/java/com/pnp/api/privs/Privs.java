package com.pnp.api.privs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.pnp.api.profil.Profil;

@Entity
@Table(name="privilege")
public class Privs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int(255)")
	private int id;
	@Column(name = " nom_privs",columnDefinition = "varchar(255)")
	private String nom;
	@Column(name = "description",columnDefinition = "text")
	private String description;
	@Column(name = "categorie",columnDefinition = "varchar(35)")
	private String categorie;
	@Column(name = "composant",columnDefinition = "varchar(35)")
	private String composant;
	public String getComposant() {
		return composant;
	}
	public void setComposant(String composant) {
		this.composant = composant;
	}
	@ManyToMany
	@JoinTable(
			name="profil_privs",
			joinColumns=@JoinColumn(name="id_privs"),
			inverseJoinColumns=@JoinColumn(name="id_profil")
			)	
	private List<Profil> profillist;

	public void setProfillist(List<Profil> profillist) {
		this.profillist = profillist;
	}
	public Privs(String a) {
		this.id=Integer.parseInt(a);

		
	}
	public Privs() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Privs(int id, String nom, String description, String categorie ,String composant) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.composant=composant;
	}
	@Override
	public String toString() {
		return "Privs [id=" + id + ", nom=" + nom + ", description=" + description + ", categorie=" + categorie + "]";
	}
}
