package isamm.projet.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;


import isamm.projet.beans.Filiere;
import isamm.projet.beans.Etudiant;
import isamm.projet.beans.Formateur;
import isamm.projet.beans.Lignematierefiliere;
import isamm.projet.beans.Matiere;
import isamm.projet.beans.Personne;


import isamm.projet.service.FiliereService;
import isamm.projet.service.FormateurService;
import isamm.projet.service.LigneMatiereFiliereService;
import isamm.projet.service.MatiereService;
import isamm.projet.service.EtudiantService;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			/*Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			// PARTIE A
			Personne pe= new Personne( "Dakhli",  "Nahed", " 24463667","  nahed.dakhli@gmail.com", " femenin");
			Personne pe1 = new Personne( "Ben salah", " Med",  "58963321", " med@gmail.com", " musculin");
			
			
			Filiere filiere1 = new Filiere();
			filiere1.setCode("codeFiliere1");
			filiere1.setLibelle("libelleFiliere1");
	        session.save(filiere1);

			Etudiant etd1 = new Etudiant();
			etd1.setFiliere(filiere1);
			etd1.setCne("09874121");
			
			
			Formateur formateur = new Formateur();
			formateur.setMatricule("M1");
			
			session.save(etd1);
	        session.save(formateur);
	        
			Matiere matiere1 = new Matiere(formateur);
			matiere1.setCode("codeM1");
			matiere1.setLibelle("libelleM1");
			Matiere matiere2 = new Matiere(formateur);
			matiere2.setCode("codeM2");
			matiere2.setLibelle("libelleM2");
	        session.save(matiere1);
	        session.save(matiere2);


	        Lignematierefiliere lignemat1 = new Lignematierefiliere(filiere1 ,  matiere1,  5);
	        Lignematierefiliere lignemat2 = new Lignematierefiliere(filiere1 ,  matiere2,  6) ;

	        session.save(lignemat1);
	        session.save(lignemat2);
			
			session.getTransaction().commit();
			System.out.println("Done");*/
		
		//PARTIE B. Couche service :
			
		//a) Créer trois filières :
			
		FiliereService filiereService = new FiliereService();
		Filiere filiere1 = new Filiere();
		filiere1.setCode("IAII");
		filiere1.setLibelle("Ingénierie des automatismes et informatique industrielle");
		
		Filiere filiere2 = new Filiere();
		filiere2.setCode("IRT");
		filiere2.setLibelle("Ingénierie des réseaux et télécommunications");
		
		Filiere filiere3 = new Filiere();
		filiere3.setCode("IIR");
		filiere3.setLibelle("Ingénierie informatique et réseaux ");
		
		filiereService.create(filiere1);
		filiereService.create(filiere2);
		filiereService.create(filiere3);
		
		//b) Créer cinq matières :
		
		MatiereService matiereService = new MatiereService();
		
		Matiere matiere1 = new Matiere();
		matiere1.setCode("Techniques de programmation structurée");
		matiere1.setCode("TPC");
		
		Matiere matiere2 = new Matiere();
		matiere2.setLibelle("Java de Base");
		matiere2.setCode("JB");
		
		Matiere matiere3 = new Matiere();
		matiere3.setLibelle("Administration Unix");
		matiere3.setCode("Au");
		
		Matiere matiere4 = new Matiere();
		matiere4.setLibelle("Framework de persistance");
		matiere4.setCode("Hibernate");
		
		Matiere matiere5 = new Matiere();
		matiere5.setLibelle("Programmation orientée objet");
		matiere5.setCode("POO");
		
		matiereService.create(matiere1);
		matiereService.create(matiere2);
		matiereService.create(matiere3);
		matiereService.create(matiere4);
		matiereService.create(matiere5);
		
		//c) Créer deux formateurs :
		FormateurService formateurService = new FormateurService();
		Formateur formateur1 = new Formateur("Slimani","Yahia","","", "M","F1");
		formateurService.create(formateur1);
		Formateur formateur2 = new Formateur("Safii","Ilhem","","", "F","F2");
		formateurService.create(formateur2);
		
		
		matiere1.setFormateur(formateur1);
		matiere2.setFormateur(formateur1);
		matiere3.setFormateur(formateur2);
		matiere4.setFormateur(formateur1);
		matiere5.setFormateur(formateur2);

		matiereService.create(matiere1);
		matiereService.create(matiere2);
		matiereService.create(matiere3);
		matiereService.create(matiere4);
		matiereService.create(matiere5);
		
		
		//d) Créer Trois étudiants

		EtudiantService etudiantService = new EtudiantService();
		Etudiant Et1 = new Etudiant("SAFI","Amal","","","Femme","22845676");
		Etudiant Et2 = new Etudiant("ALAMI","Samir","","","Homme","23845976");
		Etudiant Et3 = new Etudiant("ALAOUI","Safa","","","Femme","22345476");
		
		Et2.setFiliere(filiere2);
		Et1.setFiliere(filiere2);
		Et2.setFiliere(filiere1);
		
		etudiantService.create(Et3);
		etudiantService.create(Et1);
		etudiantService.create(Et2);
		
		//e) Affecter les matières aux différentes filières.
		
		LigneMatiereFiliereService ligneService = new LigneMatiereFiliereService();

		Lignematierefiliere lmf1 = new Lignematierefiliere(filiere1,matiere1, 30) ;	
		Lignematierefiliere lmf2 = new Lignematierefiliere(filiere2,matiere2, 30) ;		
		Lignematierefiliere lmf3 = new Lignematierefiliere(filiere3,matiere3, 30) ;		
		Lignematierefiliere lmf4 = new Lignematierefiliere(filiere1,matiere4, 30) ;		
		Lignematierefiliere lmf5 = new Lignematierefiliere(filiere3,matiere5, 30) ;		
		
		ligneService.create(lmf1);
		ligneService.create(lmf2);
		ligneService.create(lmf3);
		ligneService.create(lmf4);
		ligneService.create(lmf5);

		//f) Afficher la liste des formateurs qui enseignent une matière donnée.
		
		
				List<Formateur> formateurs = new ArrayList<Formateur>();
				System.out.println(formateurService.getFormateursByMatieres(matiere1));
				filiereService.getEtudiantsByFiliere(filiere3);
					System.out.println(matiere1.toString());
				
		//g) Afficher la liste des étudiants par filière.	
				
				List<Etudiant> etudiants = new ArrayList<Etudiant>();
				System.out.println(filiereService.getEtudiantsByFiliere(filiere1).size());
				filiereService.getEtudiantsByFiliere(filiere3).forEach(etudiants::add);
				for(int c=0;c<etudiants.size();c++){
					System.out.println(etudiants.get(c).toString());
				}
				
	
			

	}

}
