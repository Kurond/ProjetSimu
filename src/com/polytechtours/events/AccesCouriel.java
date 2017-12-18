package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

public class AccesCouriel extends Event{

	@Override
	public void execute(Variables variables) {
		// TODO Auto-generated method stub
		System.out.println("Acces Courriel : " + getDate());
		
		MiseaJourAires(variables);
		
    	Probabilite probabilite = new Probabilite();
    	
		FinCourriel finCouriel = new FinCourriel();
		finCouriel.setDate(getDate() + (int)probabilite.uniform(convertMinuteToSecond(3), convertMinuteToSecond(7)));
		Echeancier.getInstance().ajouterEvenement(finCouriel);
		
		variables.Qc--;
		variables.DDateSimu = variables.DateSimu;		
	}

}
