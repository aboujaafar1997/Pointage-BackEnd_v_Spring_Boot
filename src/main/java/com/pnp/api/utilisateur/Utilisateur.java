package com.pnp.api.utilisateur;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.pnp.api.profil.ProfilDAO;
import com.pnp.api.profil.ProfilDAOImp;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "nom_de_utilisateur", columnDefinition = "varchar(30)")
	private String nomUtilsateur;
	@Column(name = "mdp", columnDefinition = "varchar(25)")
	private String mdp;
	@Column(name = "id_profil", columnDefinition = " int(255)")
	private int idProfil;


	public Utilisateur() {
		
	}

	public Utilisateur(String nomUtilsateur, String mdp, int idProfil) {

		this.nomUtilsateur = nomUtilsateur;
		this.mdp = mdp;
		this.idProfil = idProfil;
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

	

	@Override
	public synchronized Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> profil = null;
		int mohawala=0;
		ProfilDAO p =new ProfilDAOImp();
		try {
			Thread.sleep(300);
			
			 profil = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + p.getProfil(getIdProfil()).getNom());
			return profil;
		} catch (Exception e) {
			
			System.err.println("err verifacation de profil(role)::x0001!");
			while(mohawala <5 && profil==null) {
			 profil = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + p.getProfil(getIdProfil()).getNom());
			return profil;
			}
			
		}
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
