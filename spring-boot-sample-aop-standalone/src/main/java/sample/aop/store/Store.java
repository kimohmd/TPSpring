package sample.aop.store;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.aop.bank.IBank;
import sample.aop.provider.IProvider;

@Component
public class Store implements IStore, IJastHaveALook, IFastLane, ILane{
	@Autowired
	IBank bank;
	@Autowired
	IProvider provider;
	
	HashMap<Produit, Integer> articles;
	
	//HashMap<Produit, Integer> articlesPanier;
	
	@Override
	public void addItemToCart(Produit article, int quantite) {
		//this.articlesPanier.put(article, quantite);
		System.out.println(quantite + "article(s) :" + article.getNom() + "ajouté(s) au panier");
		
		
	}
	@Override
	public void pay(String debiteur, String crediteur, double montant) {
		this.bank.transfetMoney(debiteur, crediteur, montant);
		//this.articlesPanier.clear();
		System.out.println("payement effectué");
		
	}
	@Override
	public void oneShotOrder(Produit article, int quantite, String debiteur, String crediteur) {
		addItemToCart(article, quantite);
		double montant = article.getPrix()*quantite;
		pay(debiteur, crediteur, montant);
		
	}
	@Override
	public double getPrice(Produit article) {
		System.out.println(article.getPrix());
		return article.getPrix();
	}
	@Override
	public boolean isAvailable(Produit article, int quantite) {
		//if(this.articles.get(article)>=quantite) {
			System.out.println("article disponible !");
		//}
//		else {
//			System.out.println("article indisponible !");
//			provider.order(article, quantite);
//			bank.transfetMoney("STORE", "PROVIDER", provider.getPrice(article)*quantite);
//		}
		
		//return this.articles.get(article)>=quantite;
		return true;
		
	}
	
	public void createArticles(){
			this.articles = new HashMap<Produit, Integer>();
			this.articles.put(new Produit("casquette", 25.5), 5);
			this.articles.put(new Produit("lunette", 25.5),1);
			this.articles.put(new Produit("t-shirt", 19.99), 21);
	}
	public HashMap<Produit, Integer> getArticles() {
		return articles;
	}
	
//	public HashMap<Produit, Integer> getArticlesPanier() {
//		return articlesPanier;
//	}
	
	
}
