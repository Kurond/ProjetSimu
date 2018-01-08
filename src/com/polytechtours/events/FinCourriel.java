package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

import static com.polytechtours.events.EventsFactory.make_dated;

/**
 * 
 * @author Amine
 *
 */
public class FinCourriel extends Event{

	@Override
	public void execute(Variables variables) {
		System.out.println("Fin Courriel : " + getDate());

		MiseaJourAires(variables);
		
		AccesAppel accesapp = new AccesAppel();
		AccesCouriel accescouriel = new AccesCouriel();
		
		if(variables.Qt >= variables.Nt)
		{
			if(variables.Nt < variables.Ntmax)
			{
				variables.Nc--;
				variables.Nt++;
				
				Echeancier.getInstance().ajouterEvenement(make_dated(accesapp, getDate()));
			}
		}
		else
		{
			if(variables.Qc == 0)
			{
				variables.Nc--;
			}
			else
			{
				accescouriel.setDate(getDate());
				Echeancier.getInstance().ajouterEvenement(make_dated(accescouriel, getDate()));
			}
		}
		
		variables.DDateSimu = getDate();
	}

}
