package fr.orsys.kingsley.kanban_spring.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, message = "Le nom de projet doit comporter au moins 3 caractères")
	private String nom;
	
	private String code;
	
	@ManyToOne
	private Client client;
	
	// Un projet comporte plusieurs taches
	@OneToMany(mappedBy = "projet")
	private List<Tache> taches;
	
	// Un projet a une date de création
	private LocalDateTime dateHeureCreation;
	
	// Un projet a une deadline
	private LocalDateTime dateHeureLivraison;
	
	@NotEmpty(message = "Merci de sélectionner des développeurs associée à ce projet")
	// @Size(min = 1, message = "Un projet doit avoir au moins un développeur")
	@ManyToMany
	private List<Developpeur> developpeurs;
	
	public Projet() {
		// TODO Auto-generated constructor stub
	}

}
