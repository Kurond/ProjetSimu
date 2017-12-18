package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

import static com.polytechtours.events.EventsFactory.make_dated;
import static com.polytechtours.utils.Probabilite.uniform;

public class AccesCouriel extends Event{

	@Override
	public void execute(Variables variables) {
		// TODO Auto-generated method stub
		System.out.println("Acces Courriel : " + getDate());
		
		MiseaJourAires(variables);

		int date = getDate() + uniform(convertMinuteToSecond(3), convertMinuteToSecond(7));

		Echeancier.getInstance().ajouterEvenement(make_dated(new FinCourriel(), date));
		
		variables.Qc--;
		variables.DDateSimu = variables.DateSimu;		
	}

}
