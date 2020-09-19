package sample.simple.provider;

import sample.simple.store.Produit;

public interface IProvider {

	public double getPrice(Produit article);
	public void order(Produit article, int quantity);
}
