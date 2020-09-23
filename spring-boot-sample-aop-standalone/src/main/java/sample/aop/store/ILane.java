package sample.aop.store;

public interface ILane extends IStore{

	public void addItemToCart(Produit article, int quantite);
	public void pay(String debiteur, String crediteur, double montant, Boolean auth);
}
