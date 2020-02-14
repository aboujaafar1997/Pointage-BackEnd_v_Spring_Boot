package com.pnp.api.Pointage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pointage")
public class Pointage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_taxi", columnDefinition = "int(255)")
	private int id_taxi;
	@Id
	@Column(name = "id_permis", columnDefinition = "int(255)")
	private int id_permis;
	@Column(name = "id_session", columnDefinition = "int(255)")
	private int 	id_session;
	@Id
	@Column(name = "date", columnDefinition = "varchar(35)")
	private String date;
	@Override
	public String toString() {
		return "Pointage [id_taxi=" + id_taxi + ", id_permis=" + id_permis + ", id_session=" + id_session + ", date="
				+ date + "]";
	}
	public int getId_taxi() {
		return id_taxi;
	}
	public void setId_taxi(int id_taxi) {
		this.id_taxi = id_taxi;
	}
	public int getId_permis() {
		return id_permis;
	}
	public void setId_permis(int id_permis) {
		this.id_permis = id_permis;
	}
	public int getId_session() {
		return id_session;
	}
	public void setId_session(int id_session) {
		this.id_session = id_session;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Pointage(int id_taxi, int id_permis, int id_session, String date) {
		this.id_taxi = id_taxi;
		this.id_permis = id_permis;
		this.id_session = id_session;
		this.date = date;
	}
	public Pointage() {
		// TODO Auto-generated constructor stub
	}

}
