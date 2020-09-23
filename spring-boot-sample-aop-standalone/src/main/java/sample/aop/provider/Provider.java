package sample.aop.provider;

import org.springframework.stereotype.Component;

import sample.aop.store.Produit;

@Component
public class Provider implements IProvider{

	@Override
	public double getPrice(Produit article) {
		
		return article.getPrix();
		
	}

	@Override
	public void order(Produit article, int quantite) {
		
		System.out.println("la commande de "+ quantite + article +"(s) est bien effectuée");
		
	}

}
