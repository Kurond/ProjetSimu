package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

public class ArriveeAppel extends Event {
    @Override
    public void execute(Variables variables) {
    	System.out.println("Arrivée Appel : " + getDate());
    	
    	Probabilite probabilite = new Probabilite();
        ArriveeAppel arriveeAppel = new ArriveeAppel();

        if((getDate() >= convertHourToSecond(8)) && (getDate() < convertHourToSecond(9))) {
        	int date = (int) convertMinuteToSecond(probabilite.exponentielle(5));
            arriveeAppel.setDate(getDate() + date);
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        } else if ((getDate() >= convertHourToSecond(9)) && (getDate() < convertHourToSecond(11))) {
        	int date = (int) convertMinuteToSecond(probabilite.exponentielle(1));
            arriveeAppel.setDate(getDate() + date);
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        } else {
        	int date = (int) convertMinuteToSecond(probabilite.exponentielle(10));
            arriveeAppel.setDate(getDate() + date);
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        }
        
        variables.NbAppel++;
        MiseaJourAires(variables);

        if((variables.Nt < variables.Ntmax) && (variables.N - variables.Nt - variables.Nc > 0)) {
            variables.Nt++;
            
            AccesAppel accAppel = new AccesAppel();
            accAppel.setDate(getDate());
            Echeancier.getInstance().ajouterEvenement(accAppel);
        }

        variables.Qt++;
        variables.DDateSimu = variables.DateSimu;
    }


}
