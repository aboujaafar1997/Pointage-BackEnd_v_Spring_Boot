package com.pnp.api.Jouranal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="journal")
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int(255)")
	private int id;
	@Column(name = "event",columnDefinition = "varchar(50)")
	private String event ;
	@Column(name = "date",columnDefinition = "varchar(30)")
	private String date ;
	@Column(name = "session_id",columnDefinition = "int(255)")
	private int session ;
public Journal() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEvent() {
	return event;
}
public void setEvent(String event) {
	this.event = event;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getSession() {
	return session;
}
public void setSession(int session) {
	this.session = session;
}
public Journal( String event, String date, int session) {
	this.event = event;
	this.date = date;
	this.session = session;
}

}