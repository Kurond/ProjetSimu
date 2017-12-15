package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

public class Debut extends Event{

	public Debut() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Variables variables) {
		// TODO Auto-generated method stub
		Probabilite p =new Probabilite();
		Echeancier echancier = Echeancier.getInstance();
		//Couriel arrivant au debut de la simu
		variables.Qc = p.uniform(20, 80);
		variables.Qt = 0;
		variables.NbCourriel = variables.Qc;
		variables.NbAppel = variables.Qt;
		variables.Nt = 0;
		variables.Nc = 0;
		// a mettre quand Antoine a fini 
		//variables.DateSimu =
		//a mettre aussi apres
		//variables.DDateSimu =;
		//ajouter les events une fois implémenter
		
		// faire set date pour mettre la date d'arrivé de l'event;
		
		//echancier.ajouterEvenement(evenement);
	}

	
	

}
