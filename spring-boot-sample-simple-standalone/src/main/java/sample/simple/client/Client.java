package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.simple.store.IFastLane;
import sample.simple.store.IJastHaveALook;
import sample.simple.store.ILane;
import sample.simple.store.Produit;

@Component
public class Client implements IRun, IClient{

	@Autowired
	IFastLane fastLane;
	@Autowired
	ILane lane;
	@Autowired
	IJastHaveALook justHaveALook;
	
	public String adresse;
	public String numCompte;
	
	@Override
	public void run() {
		justHaveALook.createArticles();
		System.out.println(justHaveALook.getArticles().isEmpty());
		Produit article1 = new Produit("casquette", 25.5);
		Produit article2 = new Produit("lunette", 55.5);
		int quantiteArticle1 = 3;
		
		System.out.println("début scénario 1");
		
		System.out.println("fin scénario 1");
		/////////////////////////////////////
		System.out.println("début scénario 2");
		
		

		lane.addItemToCart(article1, quantiteArticle1);
		lane.addItemToCart(article2, quantiteArticle1);
		this.validateCommand("20 que quelque part", "FR123456789");
		
		Boolean b1 = justHaveALook.isAvailable(article1, quantiteArticle1);
		Boolean b2 = justHaveALook.isAvailable(article2, quantiteArticle1);
		if(b1&&b2)
		lane.pay(this.getNumCompte(), "STORE", article1.getPrix()+article2.getPrix());
		
		
		System.out.println("fin scénario 2");
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numcpt) {
		this.numCompte = numcpt;
	}
	
	public void validateCommand(String adr, String cpt) {
		this.setAdresse(adr);
		this.setNumCompte(cpt);
		
	}
	
}
