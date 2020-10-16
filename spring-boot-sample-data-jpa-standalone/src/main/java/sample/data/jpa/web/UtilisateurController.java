package sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.data.jpa.domain.Utilisateur;
import sample.data.jpa.service.UtilisateurDao;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	  @Autowired
	  private UtilisateurDao utilisateurDao;
	  
	  @GetMapping(path ="/getAllUtilisateurs", produces = "application/json")
	    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
	        return new ResponseEntity<List<Utilisateur>>(utilisateurDao.findAll(), HttpStatus.OK);
	    }
	  
	  @GetMapping(path ="/getUtilisateurById/{id}", produces = "application/json")
	    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
	        return new ResponseEntity<Utilisateur>(utilisateurDao.findById(id).get(), HttpStatus.OK);
	    }
	  
	  @PostMapping(path ="/addUtilisateur", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur) {
	        utilisateurDao.save(utilisateur);
	        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
	    }
	  
//	  @PutMapping (path ="/updateUtilisateur/{id}", produces = "application/json")
//	    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody String fonction) {
//	      Utilisateur u = utilisateurDao.findById(id).get();  
//		  u.setFonction(fonction);
//	      utilisateurDao.save(u);
//	        return new ResponseEntity<Utilisateur>(u, HttpStatus.OK);
//	    }

	  @PutMapping (path ="/updateUtilisateur/{id}", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur u) {
	      Utilisateur user = utilisateurDao.findById(id).get();  
		  user.setFonction(u.getFonction());
		  user.setNom(u.getNom());
		  user.setPrenom(u.getPrenom());
	      utilisateurDao.save(user);
	        return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	    }
	  
	  
	  @DeleteMapping(path ="/delUtilisateur/{id}", produces = "application/json")
	  public ResponseEntity<Long> delete(@PathVariable Long id) {
	        Utilisateur u = utilisateurDao.findById(id).get();
	        utilisateurDao.delete(u);
	        return new ResponseEntity<Long>(u.getId(), HttpStatus.OK);
	    }
}