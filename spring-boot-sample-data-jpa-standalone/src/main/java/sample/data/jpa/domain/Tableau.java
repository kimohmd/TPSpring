package sample.data.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Tableau {

	public Long id;
	public String titre;
	public List<Fiche> fiches = new ArrayList<Fiche>();
	

	public Tableau() {
		
	}
	
	public Tableau(String t) {
		this.titre = t;
		
	}
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	@JsonManagedReference
	@OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
	public List<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
	
	@Override
    public String toString() {
        return "Tableau Kanban [id=" + id + ", titre=" + titre + ", nombre de fiches ="
                + fiches.size() + "]";
    }


}
