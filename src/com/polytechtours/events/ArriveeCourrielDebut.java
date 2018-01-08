package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;

import static com.polytechtours.events.EventsFactory.make_dated;

public class ArriveeCourrielDebut extends Event {
    @Override
    public void execute(Variables variables) {
        System.out.println("Arrivee Courriel Debut : " + getDate());

        variables.NbCourriel++;

        if(variables.N - variables.Nt - variables.Nc > 0) {
            variables.Nc ++;

            Echeancier.getInstance().ajouterEvenement(make_dated(new AccesCouriel(), getDate()));
        }

        variables.Qc++;
    }
}
