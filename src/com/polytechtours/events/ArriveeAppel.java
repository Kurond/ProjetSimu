package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

import static com.polytechtours.events.EventsFactory.make_dated;
import static com.polytechtours.utils.Probabilite.exponentielle;


public class ArriveeAppel extends Event {
    @Override
    public void execute(Variables variables) {
    	System.out.println("Arriv�e Appel : " + getDate());

        int date;
        if((getDate() >= convertHourToSecond(8)) && (getDate() < convertHourToSecond(9))) {
        	date = (int) getDate() + convertMinuteToSecond(exponentielle(5));
        } else if ((getDate() >= convertHourToSecond(9)) && (getDate() < convertHourToSecond(11))) {
        	date = (int) getDate() + convertMinuteToSecond(exponentielle(1));
        } else {
        	date = (int) getDate() + convertMinuteToSecond(exponentielle(10));
        }
        Echeancier.getInstance().ajouterEvenement(make_dated(new ArriveeAppel(), date));
        
        variables.NbAppel++;
        MiseaJourAires(variables);

        if((variables.Nt < variables.Ntmax) && (variables.N - variables.Nt - variables.Nc > 0)) {
            variables.Nt++;

            Echeancier.getInstance().ajouterEvenement(make_dated(new AccesAppel(), getDate()));
        }

        variables.Qt++;
        variables.DDateSimu = variables.DateSimu;
    }


}
