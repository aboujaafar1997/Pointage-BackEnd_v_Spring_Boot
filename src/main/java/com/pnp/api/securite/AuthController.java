package com.pnp.api.securite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.api.utilisateur.Utilisateur;
import com.pnp.api.utilisateur.UtilisateurDAO;


@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;
@Autowired
private UtilisateurDAO utilisateur;
    @Autowired
    private AuthenticationManager authenticationManager;
 @CrossOrigin(origins = {"http://localhost:3000","http://192.168.43.37:3000"})
    @RequestMapping(value="/e", method=RequestMethod.POST)
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {

    	Utilisateur monutilisate=null;
    	try {
    	monutilisate=utilisateur.getUtilisateur(signInRequest.getUsername(), signInRequest.getPassword());
    
    		final Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
        String token = tokenUtil.generateToken(userDetails);
        JwtResponse response = new JwtResponse(token);
        return response;}
catch(Exception e) {
	System.err.println("ereur servenu");
	return null;
}
    	
    }
}
