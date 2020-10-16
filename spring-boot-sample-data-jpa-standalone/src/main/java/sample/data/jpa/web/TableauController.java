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

import sample.data.jpa.domain.Tableau;
import sample.data.jpa.domain.Utilisateur;
import sample.data.jpa.service.TableauDao;

@RestController
@RequestMapping("/tableau")
public class TableauController {
	  @Autowired
	  private TableauDao tableauDao;
	  
	  @GetMapping(path ="/getAllTableaux", produces = "application/json")
	    public ResponseEntity<List<Tableau>> getAllTableaux() {
	        return new ResponseEntity<List<Tableau>>(tableauDao.findAll(), HttpStatus.OK);
	    }
	  
	  @GetMapping(path ="/getTableauById/{id}", produces = "application/json")
	    public ResponseEntity<Tableau> getTableauById(@PathVariable Long id) {
	        return new ResponseEntity<Tableau>(tableauDao.findById(id).get(), HttpStatus.OK);
	    }
	  
	  @PostMapping(path ="/addTableau", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Tableau> addTableau(@RequestBody Tableau  tableau) {
	        tableauDao.save(tableau);
	        return new ResponseEntity<Tableau>(tableau, HttpStatus.OK);
	    }
	  
	  @PutMapping (path ="/updateTableau/{id}", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Tableau> updateTableau(@PathVariable Long id, @RequestBody Tableau t) {
		  Tableau tab = tableauDao.findById(id).get();  
		  tab.setTitre(t.getTitre());
	      tableauDao.save(tab);
	        return new ResponseEntity<Tableau>(tab, HttpStatus.OK);
	    }
	  
	  
	  @DeleteMapping(path ="/delTableau/{id}", produces = "application/json")
	  public ResponseEntity<Long> delete(@PathVariable Long id) {
		  Tableau t = tableauDao.findById(id).get();
	        tableauDao.delete(t);
	        return new ResponseEntity<Long>(t.getId(), HttpStatus.OK);
	    }
}