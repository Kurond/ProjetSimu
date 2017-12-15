package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

public class ArriveeAppel extends Event {
    @Override
    public void execute(Variables variables) {
        if((getDate() >= convertHourToSecond(8)) && (getDate() < convertHourToSecond(9))) {
            // ajouter evenement arrivé appel
            //Echeancier.getInstance().ajouterEvenement();
        } else if((getDate() >= convertHourToSecond(9)) && (getDate() < convertHourToSecond(11))) {
            // ajouter evenement arrivé appel
            //Echeancier.getInstance().ajouterEvenement();
        } else {
            // ajouter evenement arrivé appel
            //Echeancier.getInstance().ajouterEvenement();
        }

        variables.NbAppel = variables.NbAppel + 1;
    }
}
