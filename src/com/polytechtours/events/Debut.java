package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

import static com.polytechtours.events.EventsFactory.make_dated;
import static com.polytechtours.utils.Probabilite.exponentielle;
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
		int nbmailDebut = uniform(20, 80);
		Echeancier echancier = Echeancier.getInstance();
		//Couriel arrivant au debut de la simu
		variables.Qc = 0;
		variables.Qt = 0;
		variables.NbCourriel = variables.Qc;
		variables.NbAppel = variables.Qt;
		variables.Nt = 0;
		variables.Nc = 0;
		
		variables.N = 1000;
		variables.Ntmax = 100;
		
		variables.DDateSimu = convertHourToSecond(8);

		for(int i = 0 ; i < nbmailDebut; i++){
			echancier.ajouterEvenement(make_dated(new ArriveeCourrielDebut(), convertHourToSecond(8)));
		}
		//ajouter les events
		echancier.ajouterEvenement(make_dated(new ArriveeAppel(), getDate() + convertMinuteToSecond(exponentielle(5f))));

		echancier.ajouterEvenement(make_dated(new ArriveeCourriel(), convertMinuteToSecond(exponentielle(0.5f)) + getDate()));

		
		//ajouter l'event fin
		Fin fin = new Fin();
		fin.setDate(convertHourToSecond(12));
		echancier.ajouterEvenement(fin);
	}

	
	

}
