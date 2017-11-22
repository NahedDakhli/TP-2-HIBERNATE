package isamm.projet.beans;
// Generated 22 nov. 2017 00:55:58 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Personne generated by hbm2java
 */
@Entity
@Table(name = "personne", catalog = "tp2hibernate")
public class Personne implements java.io.Serializable {

	private Integer id;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String sexe;
	private Formateur formateur;
	private Etudiant etudiant;

	public Personne(String nom, String prenom, String telephone, String email, String sexe) {
	}

	public Personne() {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.sexe = sexe;
		this.formateur = formateur;
		this.etudiant = etudiant;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nom", length = 254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 254)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "telephone", length = 254)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email", length = 254)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "sexe", length = 254)
	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personne")
	public Formateur getFormateur() {
		return this.formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personne")
	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}