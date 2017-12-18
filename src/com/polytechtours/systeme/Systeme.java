package com.polytechtours.systeme;

import com.polytechtours.events.*;

import static com.polytechtours.events.EventsFactory.make_dated;

/**
 * 
 * @author Charly
 */
public class Systeme {
	
	public Systeme() {
		Echeancier echeancier = Echeancier.getInstance();
		Variables vars = new Variables();
		
		echeancier.ajouterEvenement(make_dated(new Debut(),0));
		
		System.out.println("init");

		Event evenement;
		do {
			evenement = echeancier.retirerEvenement();
			if(evenement != null){
				evenement.execute(vars);
			}
		}while (!(evenement instanceof  Fin));

		System.out.println(vars.toString());
	}
}

