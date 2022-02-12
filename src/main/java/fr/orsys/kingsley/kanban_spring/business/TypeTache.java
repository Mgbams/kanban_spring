package fr.orsys.kingsley.kanban_spring.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TypeTache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String couleur;
	
	@OneToMany(mappedBy = "typeTache")
	private List<Tache> taches;
	
	private String description;
	
	public TypeTache() {
		// TODO Auto-generated constructor stub
	}

	public TypeTache(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}

}