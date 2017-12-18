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
    	System.out.println("Arrivée Courriel : " + getDate());
    	
        Probabilite probabilite = new Probabilite();

        if(getDate() >= convertHourToSecond(8) && getDate() < convertHourToSecond(9)){
            ArriveeCourriel arriveeCourriel = new ArriveeCourriel();
            int date = (int)convertMinuteToSecond(probabilite.exponentielle(0.5f))* + getDate();
            //System.out.println("Expo : " + );
            arriveeCourriel.setDate(date);
            Echeancier.getInstance().ajouterEvenement(arriveeCourriel);
        } else {
            ArriveeCourriel arriveeCourriel = new ArriveeCourriel();
            int date = (int)convertMinuteToSecond(probabilite.exponentielle(5)) + getDate();
            arriveeCourriel.setDate(date);
            Echeancier.getInstance().ajouterEvenement(arriveeCourriel);
        }
        
        variables.NbCourriel++;
        MiseaJourAires(variables);
        
        if(variables.N - variables.Nt - variables.Nc > 0) {
            variables.Nc ++;

            AccesCouriel accCour = new AccesCouriel();
            accCour.setDate(getDate());
            
            Echeancier.getInstance().ajouterEvenement(accCour);
        }

        variables.Qc++;
        variables.DDateSimu = variables.DateSimu;
    }
}
