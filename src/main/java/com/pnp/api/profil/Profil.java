package com.pnp.api.profil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.pnp.api.privs.Privs;

@Entity
@Table(name="profil")
public class Profil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int(255)")
	private int id;
	@Column(name = "nom",columnDefinition = "varchar(30)")
	private String nom;
//cascade = {CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.PERSIST}
	@ManyToMany
	@JoinTable(
			name="profil_privs",
			joinColumns=@JoinColumn(name="id_profil"),
			inverseJoinColumns=@JoinColumn(name="id_privs")
			)	
	private List<Privs> privslist;

	public Profil() {
		// TODO Auto-generated constructor stub
	}
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
 public void ajouterList(Privs privs ) {
	 if(this.privslist==null) privslist=new ArrayList<Privs>();
	 this.privslist.add(privs);
 }
public List<Privs> getPrivslist() {
	return privslist;
}
public void setPrivslist(List<Privs> privslist) {
	this.privslist = privslist;
}
	
}
