package com.polytechtours.systeme;

import com.polytechtours.events.*;

import static com.polytechtours.events.Event.convertHourToSecond;
import static com.polytechtours.events.EventsFactory.make_dated;

/**
 * 
 * @author Charly
 */
public class Systeme {
	
	public Systeme() {
		Echeancier echeancier = Echeancier.getInstance();
		Variables vars = new Variables();
		
		echeancier.ajouterEvenement(make_dated(new Debut(), convertHourToSecond(8)));
		
		System.out.println("init");

		Event evenement;
		do {
			evenement = echeancier.retirerEvenement();
			if(evenement != null){
				evenement.execute(vars);
			}
		}while (!(evenement instanceof  Fin) && evenement != null);

		System.out.println(vars.toString());
	}
}

