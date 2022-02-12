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
public class Colonne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Une colonne a un nom
	private String nom;
	
	// Une colonne comporte un ensemble de taches
	@OneToMany(mappedBy = "colonne")
	private List<Tache> taches;

	public Colonne() {
		// TODO Auto-generated constructor stub
	}
	
	public Colonne(String nom) {
		this();
		this.nom = nom;
	}

	public Colonne(Long id, String nom) {
		this(nom);
		this.id = id;
	}

}