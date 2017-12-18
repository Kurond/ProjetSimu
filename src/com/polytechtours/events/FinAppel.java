package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

public class FinAppel extends Event{

	@Override
	public void execute(Variables variables) {
		MiseaJourAires(variables);
		
		// Si la file d'appel est vide
		if (variables.Qt == 0) {
			// Changer le status du téléconseiller
			variables.Nt = variables.Nt - 1;
			
			// Si la file des courriel est non vide
			if (variables.Qc != 0) {
				variables.Nc = variables.Nc + 1;
				
				// Inserer l'evenement Acces courriel
			}
		} else {
			// Inserer l'evenement Acces Appel			
		}
		
		variables.DDateSimu = variables.DateSimu;
	}

}
