package sample.aop.provider;

import sample.aop.store.Produit;

public interface IProvider {

	public double getPrice(Produit article);
	public void order(Produit article, int quantity);
}
