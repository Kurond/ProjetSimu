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
		AccesCouriel accescouriel = new AccesCouriel();
		
		accescouriel.setDate(getDate() + (int)convertMinuteToSecond(probabilite.uniform(3, 7)));
		Echeancier.getInstance().ajouterEvenement(accescouriel);
		variables.Qc = variables.Qc - 1;
		variables.DDateSimu = variables.DateSimu;		
	}

}
