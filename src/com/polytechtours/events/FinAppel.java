package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

public class FinAppel extends Event{

	@Override
	public void execute(Variables variables) {
		System.out.println("Fin Appel : " + getDate());
		
		MiseaJourAires(variables);
		
		// Si la file d'appel est vide
		if (variables.Qt == 0) {
			// Changer le status du téléconseiller
			variables.Nt -= 1;
			
			// Si la file des courriel est non vide
			if (variables.Qc != 0) {
				variables.Nc += 1;
				
				// Inserer l'evenement Acces courriel
				AccesCouriel accCour = new AccesCouriel();
				accCour.setDate(getDate());
				
				Echeancier.getInstance().ajouterEvenement(accCour);
			}
		} 
		// Si la file d'appel n'est pas vide
		else {
			// Inserer l'evenement Acces Appel		
			AccesAppel accAppel = new AccesAppel();
			accAppel.setDate(getDate());
			
			Echeancier.getInstance().ajouterEvenement(accAppel);
		}
		
		variables.DDateSimu = variables.DateSimu;
	}

}
