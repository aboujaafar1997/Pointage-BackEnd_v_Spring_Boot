package com.pnp.api.securite;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name="utilisateur")
public class Utilisateur implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int(255)")
	private int id;
	@Column(name = "nom_de_utilisateur",columnDefinition = "varchar(30)")
	private String nomUtilsateur;
	@Column(name = "mdp",columnDefinition = "varchar(25)")
	private String mdp;
	@Column(name = "id_profil",columnDefinition = " int(255)")
	private int idProfil;
	@Column(name = "id_pnp",columnDefinition = " int(11)")
	private int idPnp;

	public Utilisateur() {}
	public Utilisateur(String nomUtilsateur, String mdp, int idProfil, int idPnp) {
		
		this.nomUtilsateur = nomUtilsateur;
		this.mdp = mdp;
		this.idProfil = idProfil;
		this.idPnp = idPnp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomUtilsateur() {
		return nomUtilsateur;
	}

	public void setNomUtilsateur(String nomUtilsateur) {
		this.nomUtilsateur = nomUtilsateur;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public int getIdPnp() {
		return idPnp;
	}

	public void setIdPnp(int idPnp) {
		this.idPnp = idPnp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> profil = AuthorityUtils

            	.commaSeparatedStringToAuthorityList("ROLE_" + getIdProfil());
return profil;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getMdp();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getNomUtilsateur();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
