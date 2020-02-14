package com.pnp.api.Taxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;

@Repository
public class TaxiDAOImp implements TaxiDAO {
	Session session = null;

	public TaxiDAOImp() {
		session = Connection.getSession();

	}

	@Override
	public List<Taxi> getTous() {
		List<Taxi> list = (List<Taxi>) session.createQuery("from Taxi").list();
		if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterTaxi(Taxi Taxi) {
		Transaction tx = session.beginTransaction();

		try {
			session.save(Taxi);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de ajouter Taxi il'ya ereur sur:" + e.getMessage());
		}
	}

	@Override
	public void supprimerTaxi(int id) {
		try {
			Transaction tx = session.beginTransaction();
			Taxi Taxi = session.get(Taxi.class, id);
			session.delete(Taxi);
			tx.commit();
		} catch (Exception e) {

			System.err.println("impossible de supprimer il'ya ereur:" + e.getMessage());
		}
	}

	@Override
	public Taxi getTaxiid(String id) {
		Taxi Taxi = (Taxi) session.createQuery("from Taxi where id='" + id).getSingleResult();
		if (Taxi != null) {
			return Taxi;
		} else
			return null;
	}

	public void excel(String url) throws IOException {

		FileInputStream file = new FileInputStream(new File(url));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // points to the starting of excel i.e excel first row
			row = (Row) sheet.getRow(i); // sheet number

			String id;
			if (row.getCell(0) == null) {
				id = "0";
			} else
				id = row.getCell(0).toString();

			String matricule;
			if (row.getCell(1) == null) {
				matricule = "null";
			} // suppose excel cell is empty then its set to 0 the variable
			else
				matricule = row.getCell(1).toString(); // else copies cell data to name variable

			String modele;
			if (row.getCell(2) == null) {
				modele = "null";
			} else
				modele = row.getCell(2).toString();
			Taxi taxi = new Taxi();

			taxi.setMatricule(matricule);
			taxi.setModele(modele);
			System.out.println(taxi);
			ajouterTaxi(taxi);
		}
		file.close();
	}

}
