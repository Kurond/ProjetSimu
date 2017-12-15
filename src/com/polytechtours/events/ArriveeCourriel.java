package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

/**
 * Created by mika on 15/12/17.
 */
public class ArriveeCourriel extends Event{

    @Override
    public void execute(Variables variables) {

        Probabilite probabilite = new Probabilite();

        if(getDate() >= 28800 && getDate() <= 32400){
            ArriveeCourriel arriveeCourriel = new ArriveeCourriel();
            int date = (int)probabilite.exponentielle(5*60);
            arriveeCourriel.setDate(date);
            Echeancier.getInstance().ajouterEvenement(arriveeCourriel);
        }else {
            ArriveeCourriel arriveeCourriel = new ArriveeCourriel();
            int date = (int)probabilite.exponentielle(30);
            arriveeCourriel.setDate(date);
            Echeancier.getInstance().ajouterEvenement(arriveeCourriel);
        }
        //mettre a jour les aires
        if(variables.N - variables.Nt - variables.Nc > 0){
            variables.Nc ++;
            // ajouter accés courriel
        }
    }
}
