package sample.aop.store;

public interface IFastLane extends IStore{

	public void oneShotOrder(Produit article, int quantite, String debiteur, String crediteur, Boolean auth);
}
