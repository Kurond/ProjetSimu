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
    	System.out.println("Courriel : " + getDate());
    	
        Probabilite probabilite = new Probabilite();

        if(getDate() >= 28800 && getDate() <= 32400){
            ArriveeCourriel arriveeCourriel = new ArriveeCourriel();
            int date = (int)convertMinuteToSecond(probabilite.exponentielle(5)) + getDate();
            arriveeCourriel.setDate(date);
            Echeancier.getInstance().ajouterEvenement(arriveeCourriel);
        }else {
            ArriveeCourriel arriveeCourriel = new ArriveeCourriel();
            int date = (int)convertMinuteToSecond(probabilite.exponentielle(30)) + getDate();
            arriveeCourriel.setDate(date);
            Echeancier.getInstance().ajouterEvenement(arriveeCourriel);
        }
        
        //mettre a jour les aires
        if(variables.N - variables.Nt - variables.Nc > 0){
            variables.Nc ++;
            // ajouter accés courriel
        }

        variables.Qc ++;
        variables.DDateSimu = variables.DateSimu;
    }
}
