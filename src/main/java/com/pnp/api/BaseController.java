package com.pnp.api;

import com.pnp.api.utilisateur.Utilisateur;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public abstract class BaseController {

    public Utilisateur getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Utilisateur) authentication.getPrincipal();
    }
}
