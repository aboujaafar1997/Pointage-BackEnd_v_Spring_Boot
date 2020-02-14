package com.pnp.api.Statistique;

public class Statistique {
String nom;
long  value;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public long getValue() {
	return value;
}
public void setValue(long value) {
	this.value = value;
}
public Statistique(String nom, long value) {
	this.nom = nom;
	this.value = value;
}
@Override
public String toString() {
	return "Statistique [nom=" + nom + ", value=" + value + "]";
}

public Statistique() {
	// TODO Auto-generated constructor stub
}

}
