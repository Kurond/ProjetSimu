package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

import static com.polytechtours.utils.Probabilite.exponentielle;


public class ArriveeAppel extends Event {
    @Override
    public void execute(Variables variables) {
    	System.out.println("Arriv�e Appel : " + getDate());

        ArriveeAppel arriveeAppel = new ArriveeAppel();

        if((getDate() >= convertHourToSecond(8)) && (getDate() < convertHourToSecond(9))) {
            arriveeAppel.setDate(getDate() + (int)convertMinuteToSecond(exponentielle((float)(5))));
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        } else if((getDate() >= convertHourToSecond(9)) && (getDate() < convertHourToSecond(11))) {
            arriveeAppel.setDate(getDate() + (int)convertMinuteToSecond(exponentielle((float)(1))));
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        } else {
            arriveeAppel.setDate(getDate() + (int)convertMinuteToSecond(exponentielle((float)(10))));
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        }
        
        variables.NbAppel ++;

        MiseaJourAires(variables);

        if((variables.Nt < variables.Ntmax) && (variables.N - variables.Nt - variables.Nc > 0)){
            variables.Nt ++;
            
            AccesAppel accAppel = new AccesAppel();
            accAppel.setDate(getDate());
            
            Echeancier.getInstance().ajouterEvenement(accAppel);
        }

        variables.Qt ++;
        variables.DDateSimu = variables.DateSimu;
    }


}
