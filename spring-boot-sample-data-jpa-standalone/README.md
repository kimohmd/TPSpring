# TP Spring Boot PARTIE 3 Spring Data

## Prérequis
Pour la BDD on utilisera les conteneurs docker créés lors du tp Jax-Rs

Si vous les avez arrêter alors relancez-les avec:
```bash
docker start jaxrs myadminjaxrs
```
Si vous les avez supprimé, recréez-les avec les commandes
```bash
docker run --name jaxrs  -p 3306:3306 -e MYSQL_ROOT_PASSWORD=554446666 -d mysql:latest
docker run --name myadminjaxrs -d --link jaxrs:db -p 8082:80 phpmyadmin
```
puis rendez-vous dans Php myadmin depuis http://localhost:8082

utilisateur root, password 554446666

## Exécution
Placez-vous à la racine du projet spring-boot-sample-data-jpa-standalone
lancez les commandes maven:
```
mv clean compile
mvn exec:java -Dexec.mainClass="sample.data.jpa.SampleDataJpaApplication"

```
ou 

Lancer la classe SampleDataJpaApplication.java
clic droit-> run as -> java application

A l'exécution la base de données testspringdata est créée et peuplée avec 2 utilisateurs

Tester quelques services avec Postman

POST tableau/addTableau

![add Tableau](https://github.com/kimohmd/images/blob/master/add%20Tableau.png?raw=true)

GET tableau/getTableauById/{idTableau}

![get tableau](https://github.com/kimohmd/images/blob/master/tableauById.png?raw=true)

POST utilisateur/addUtlisateur

![add user](https://github.com/kimohmd/images/blob/master/addUser.png?raw=true)

GET utilisateur/getAllUtilisateurs

![get all users](https://github.com/kimohmd/images/blob/master/allUsers.png?raw=true)

POST fiche/addFiche/{idTableau}/{idUtilisateur}

![add fiche](https://github.com/kimohmd/images/blob/master/addFiche.png?raw=true)

UPDATE fiche/updateFiche/{idFiche}

![update fiche](https://github.com/kimohmd/images/blob/master/updateFiche.png?raw=true)

DELETE fiche/delFiche/{idFiche}

![del fiche](https://github.com/kimohmd/images/blob/master/delFiche.png?raw=true)

L'aspet LogAspect permet de logger tous les appels aux services disponibles.

## Limitations
Les services ne sont pas optimisés, il reste la gestion des exceptions n'est pas implémentée (lorsqu'on veut chercher un utilisateur inexistant par exemple).


## Auteur
Abdel Karim HAMMAD
