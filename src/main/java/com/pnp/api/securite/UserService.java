package com.pnp.api.securite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pnp.api.utilisateur.UtilisateurDAO;

import java.util.List;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;
   
    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//
//            	.commaSeparatedStringToAuthorityList("ROLE_" + "ADMIN");
    	
    	com.pnp.api.utilisateur.Utilisateur monutlisateur= utilisateurDAO.utilisateurbynom(username);
    	return new User(username,passwordEncoder().encode(monutlisateur.getMdp()), monutlisateur.getAuthorities());
          
    }



}
