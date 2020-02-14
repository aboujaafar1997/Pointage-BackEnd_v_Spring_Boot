package com.pnp.api.Taxi;

import java.io.IOException;
import java.util.List;

import com.pnp.api.Taxi.Taxi;

public interface TaxiDAO {
	public List<Taxi> getTous();
	void ajouterTaxi(Taxi Taxi);
	void supprimerTaxi(int id);
	Taxi getTaxiid(String id);
	void excel(String url) throws IOException;
}
