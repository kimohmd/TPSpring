package sample.simple.store;

public class Produit {

	public String nom;
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double prix;
	
	public Produit(String n, double p) {
	
		this.nom = n;
		this.prix = p;
		
	}
}
