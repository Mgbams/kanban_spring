package fr.orsys.kingsley.kanban_spring.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tache {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String intitule;

	private LocalDateTime dateCreation;
	
//	@Min(value = 1, message = "Le nombre d'heure doit etre au moins une")
//	@Max(value = 144, message = "Le nombre d'heure doit etre au max 144")
	
	@Range(min = 1, max = 144, message = "Le nombre d'heure doit etre au moins une et au max 144")
	private int nbHeuresEstimees;

	private int nbHeuresReelles;
	
	@NotNull(message = "Merci de renseigner un développeur à qui la tache serait confié")
	@ManyToOne
	private Developpeur developpeur;
	
	@ManyToOne
	private TypeTache typeTache;
	
	@ManyToOne
	private Colonne colonne;
	
	@ManyToOne
	private Projet projet;
	
	// Surcharge de constructeurs (overload)
	public Tache() {
		dateCreation = LocalDateTime.now();
	}
	
	public Tache(String intitule) {
		this();
		this.intitule = intitule;
	}

}