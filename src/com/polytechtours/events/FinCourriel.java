package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
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
				
				accesapp.setDate(getDate());
				Echeancier.getInstance().ajouterEvenement(accesapp);
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
				Echeancier.getInstance().ajouterEvenement(accescouriel);
			}
		}
		
		variables.DDateSimu = variables.DateSimu;	
	}

}
