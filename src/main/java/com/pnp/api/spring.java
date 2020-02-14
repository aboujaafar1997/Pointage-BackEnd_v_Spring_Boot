package com.pnp.api;


import java.io.IOException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pnp.api.PermisDeConfiance.PermisDeConfianceDAOImp;
import com.pnp.api.Taxi.TaxiDAOImp;
import com.pnp.api.utilisateur.Utilisateur;
import com.pnp.api.utilisateur.UtilisateurDAOImp;


@SpringBootApplication
public class spring {

	public static void main(String[] args) throws ParseException, InterruptedException, IOException {
		SpringApplication.run(spring.class, args);
//		Thread isvalide = new Thread(() -> {
//		    try {
//		    	while(true) {
//			    	new PermisDeConfianceDAOImp().threadcheck();
//		    		Thread.sleep(100*60*60*24);
//		    	}
//		    } catch (ParseException e) {
//			System.out.println("fatal exception in thread isvalide");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block	
//				e.printStackTrace();
//			}
//		});
		
	}

	 @Bean
     public WebMvcConfigurer corsConfigurer() {
         return new WebMvcConfigurerAdapter() {
             @Override
             public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**").allowedOrigins("*");
             }
         };
     }
}	
