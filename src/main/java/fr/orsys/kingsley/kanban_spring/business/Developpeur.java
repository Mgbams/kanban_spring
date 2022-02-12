package fr.orsys.kingsley.kanban_spring.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Developpeur {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String prenom;
	
	
	private String nom;
	
	@Past(message = "Vous devez préciser une date dans une passé")
	// @Future(message = "Vous devez préciser une date dans une future")
	private LocalDate dateNaissance;
	
	@OneToMany(mappedBy = "developpeur", fetch = FetchType.EAGER) // Des qu'on récupère un développeur hibernate récupère ses taches
	private List<Tache> taches;
	
	@Email(message = "Merci de renseigner une adresse email au bon format")
	@NotBlank(message = "Merci de renseigner une adresse email")
	@Pattern(regexp = "^[A-Za-z0-9-]{1,63}@orsys.fr$", message = "Votre adresse doit faire partie du nom de domaine orsys.fr")
	private String email;
	
	@Transient
	private int nbTachesEnCours;
	
	@ManyToMany(mappedBy = "developpeurs")
	private List<Projet> projets;
	
	// Constructeurs
	public Developpeur() {
	}

	public Developpeur(String prenom, String nom) {
		this();
		this.prenom = prenom;
		this.nom = nom;
	}

}