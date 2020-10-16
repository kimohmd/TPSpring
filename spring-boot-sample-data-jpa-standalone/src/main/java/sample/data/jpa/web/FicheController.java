package sample.data.jpa.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import sample.data.jpa.domain.Etat;
import sample.data.jpa.domain.Fiche;
import sample.data.jpa.domain.Tableau;
import sample.data.jpa.domain.Utilisateur;
import sample.data.jpa.service.FicheDao;
import sample.data.jpa.service.TableauDao;
import sample.data.jpa.service.UtilisateurDao;

@RestController
@RequestMapping("/fiche")
public class FicheController {
	  @Autowired
	  private FicheDao ficheDao;
	  @Autowired
	  private UtilisateurDao utilisateurDao;
	  @Autowired
	  private TableauDao tableauDao;
	  
	  
	  @GetMapping(path ="/getAllFiches", produces = "application/json")
	    public ResponseEntity<List<Fiche>> getAllFiches() {
	        return new ResponseEntity<List<Fiche>>(ficheDao.findAll(), HttpStatus.OK);
	    }
	  
	  @GetMapping(path ="/getFicheById/{id}", produces = "application/json")
	    public ResponseEntity<Fiche> getFicheById(@PathVariable Long id) {
	        return new ResponseEntity<Fiche>(ficheDao.findById(id).get(), HttpStatus.OK);
	    }
	  
	  @PostMapping(path ="/addFiche/{idTableau}/{idUtilisateur}", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Long> addFiche(@PathVariable Long idTableau, @PathVariable Long idUtilisateur,
	    		@RequestBody Map<String, Object> payload){
		  Utilisateur u =utilisateurDao.findById(idUtilisateur).get();
		   Tableau t =tableauDao.findById(idTableau).get();
		   Fiche fiche = new Fiche((String)payload.get("libelle"), new Date(), u, 
				   (int)payload.get("temps"), (String)payload.get("lieu"), (String)payload.get("url"), (String)payload.get("note"), 
				   Etat.EN_ATTANTE, t) ;
		   ficheDao.save(fiche);
	        return new ResponseEntity<Long>(fiche.getId(), HttpStatus.OK);
	    }
	  
	  @PutMapping (path ="/updateFiche/{id}", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Fiche> updateFicheStatus(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
	      Fiche fiche = ficheDao.findById(id).get();  
		  fiche.setEtat(Etat.valueOf((String)payload.get("etat")));
		  fiche.setLibelle((String)payload.get("libelle"));
		  fiche.setTemps((int)payload.get("temps"));
		  fiche.setLieu((String)payload.get("lieu"));
		  fiche.setUrl((String)payload.get("url"));
		  fiche.setNote((String)payload.get("note"));
		  
	      ficheDao.save(fiche);
	        return new ResponseEntity<Fiche>(fiche, HttpStatus.OK);
	    }
	  
	  @DeleteMapping(path ="/delFiche/{id}", produces = "application/json")
	  public ResponseEntity<Long> delete(@PathVariable Long id) {
	        Fiche f = ficheDao.findById(id).get();
	        ficheDao.delete(f);
	        return new ResponseEntity<Long>(f.getId(), HttpStatus.OK);
	    }
}