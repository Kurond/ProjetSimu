package com.polytechtours.systeme;

import com.polytechtours.events.Debut;
import com.polytechtours.events.Event;

/**
 * 
 * @author Charly
 */
public class Systeme {
	
	public Systeme() {
		Echeancier echeancier = Echeancier.getInstance();
		Variables vars = new Variables();
		
		Debut evenementDebut = new Debut();
		evenementDebut.setDate(0);
		
		echeancier.ajouterEvenement(evenementDebut);
		
		Event evenement;
		while((evenement = echeancier.retirerEvenement()) != null) {
			evenement.execute(vars);
		}
		
		System.out.println(vars.toString());
	}
}

