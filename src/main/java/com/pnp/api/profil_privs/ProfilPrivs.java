package com.pnp.api.profil_privs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profil_privs")
public class ProfilPrivs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_profil",columnDefinition = "int(255)")
	private int idProfil;
 @Id
	@Column(name = "id_privs",columnDefinition = "int(255)")
	private int idPrivs;
	public ProfilPrivs() {}
	public ProfilPrivs(int idProfil, int idPrivs) {
		this.idProfil = idProfil;
		this.idPrivs = idPrivs;
	}
	public int getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}
	public int getIdPrivs() {
		return idPrivs;
	}
	public void setIdPrivs(int idPrivs) {
		this.idPrivs = idPrivs;
	}
}
