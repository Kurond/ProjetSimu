package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

import static com.polytechtours.utils.Probabilite.uniform;

/**
 * 
 * @author Amine
 *
 */
public class Debut extends Event{

	public Debut() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Variables variables) {
		System.out.println("Debut : " + getDate());
		
		// TODO Auto-generated method stub
		Echeancier echancier = Echeancier.getInstance();
		//Couriel arrivant au debut de la simu
		variables.Qc = uniform(20, 80);
		variables.Qt = 0;
		variables.NbCourriel = variables.Qc;
		variables.NbAppel = variables.Qt;
		variables.Nt = 0;
		variables.Nc = 0;
		
		variables.N = 15;
		variables.Ntmax = 10;
		
		variables.DateSimu = (int)convertHourToSecond(8);
		variables.DDateSimu =(int)convertHourToSecond(8);
		
		
		
		//ajouter les events 
		ArriveeAppel arrapp = new ArriveeAppel();
		arrapp.setDate(variables.DateSimu);
		echancier.ajouterEvenement(arrapp);
		
		ArriveeCourriel arrcouriel = new ArriveeCourriel();
		arrcouriel.setDate(variables.DateSimu);
		echancier.ajouterEvenement(arrcouriel);
		
		
		//ajouter l'event fin
		Fin fin = new Fin();
		fin.setDate((int)convertHourToSecond(12));
		echancier.ajouterEvenement(fin);
	}

	
	

}
