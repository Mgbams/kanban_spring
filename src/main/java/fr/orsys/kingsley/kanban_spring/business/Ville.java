package fr.orsys.kingsley.kanban_spring.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ville {

	// On ne peut pas utiliser le codeInsee comme clé car certaines communes
	// partagent le même code Insee
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String codeInsee;
	private String nom;
	private String codePostal;
	private double longitude;
	private double latitude;
	private String complement;
	
	public Ville(String codeInsee, String nom, String codePostal) {
		this.codeInsee = codeInsee;
		this.nom = nom;
		this.codePostal = codePostal;
	}

	public Ville(String nomCommune, String codePostal) {
		nom = nomCommune;
		this.codePostal = codePostal;
	}

}
