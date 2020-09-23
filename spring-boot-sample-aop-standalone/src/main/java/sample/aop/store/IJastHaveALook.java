package sample.aop.store;

import java.util.HashMap;

public interface IJastHaveALook extends IStore{
public void createArticles(); 
 public double getPrice(Produit article);
 public boolean isAvailable(Produit article, int quantite);
 public HashMap<Produit, Integer> getArticles();
//public HashMap<Produit, Integer> getArticlesPanier();
}
