package com.pnp.api.Statistique;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;





@RestController
@RequestMapping(value = "/api/statistique")
public class ControllerStatistique {


	
	
	@CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(value="/1", method=RequestMethod.POST)
    public ArrayList<Statistique> ajouterProfil() {
	try {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pnp", "root", "");
	     ArrayList<Statistique> c= new ArrayList<Statistique>();
	     System.err.println(date);
			try {
				String SQL = "SELECT s.id_utilisateur,count(id_session) from pointage p , session s WHERE p.id_session=s.id and p.date like '"+date+"%' GROUP BY s.id_utilisateur";
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(SQL);
				while (rs.next()) {
				c.add(new Statistique(rs.getString(1),rs.getInt(2)));
			System.err.println(c);
				}
				return c;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			
		
		}
	catch (Exception e) {
		return null;
}
	
	

}

}
