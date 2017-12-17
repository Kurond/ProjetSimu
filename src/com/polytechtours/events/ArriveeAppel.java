package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

public class ArriveeAppel extends Event {
    @Override
    public void execute(Variables variables) {
        Probabilite probabilite = new Probabilite();
        ArriveeAppel arriveeAppel = new ArriveeAppel();

        if((getDate() >= convertHourToSecond(8)) && (getDate() < convertHourToSecond(9))) {
            arriveeAppel.setDate(getDate() + (int)probabilite.exponentielle(convertMinuteToSecond(5)));
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        } else if((getDate() >= convertHourToSecond(9)) && (getDate() < convertHourToSecond(11))) {
            arriveeAppel.setDate(getDate() + (int)probabilite.exponentielle(convertMinuteToSecond(1)));
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        } else {
            arriveeAppel.setDate(getDate() + (int)probabilite.exponentielle(convertMinuteToSecond(10)));
            Echeancier.getInstance().ajouterEvenement(arriveeAppel);
        }
        variables.NbAppel = variables.NbAppel + 1;
    }


}
