# TP Spring Boot PARTIE 2 AOP

## Exécution
Placez-vous à la racine du projet spring-boot-sample-aop-standalone
lancez les commandes maven:
```
mv clean compile
mvn exec:java -Dexec.mainClass="sample.aop.SampleAopApplication"

```
ou 

Lancer la classe SampleAopApplication.java
clic droit-> run as -> java application

ceci déroule le scénario 2:

- client : choisit un ou plusieurs articles, termine la commande (adresse, n° compte)
- magasin : vérifie le stock, fait le transfert bancaire, met à jour le stock, réapprovisionne si nécessaire

tout en prenant compte des aspet LogAspect et SecurityAspect en deux variantes :
- La première en supposant que le client est authentifié lors du paiement
- La deuxième suppose que le client n'est pas authentifié

pour simplifié on suppose que l'authentification est représentée par une variable booléenne auth

## Auteur
Abdel Karim HAMMAD
