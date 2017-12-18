package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

public class FinCourriel extends Event{

	@Override
	public void execute(Variables variables) {
		// TODO Auto-generated method stub
		MiseaJourAires(variables);
		
		AccesAppel accesapp = new AccesAppel();
		AccesCouriel accescouriel = new AccesCouriel();
		
		if(variables.Qt >= variables.Nt)
		{
			if(variables.Nt < variables.Ntmax)
			{
				variables.Nc = variables.Nc - 1;
				variables.Nt = variables.Nt - 1;
				accesapp.setDate(getDate());
				Echeancier.getInstance().ajouterEvenement(accesapp);
			}
		}
		else
		{
			if(variables.Qc == 0)
			{
				variables.Nc -= 1;
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
