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

		FinCourriel finCouriel = new FinCourriel();
        int date = Probabilite.uniform(convertMinuteToSecond(3),convertMinuteToSecond(7)) + getDate();
		finCouriel.setDate(date);
		Echeancier.getInstance().ajouterEvenement(finCouriel);
		variables.Qc = variables.Qc - 1;
		variables.DDateSimu = variables.DateSimu;		
	}

}
