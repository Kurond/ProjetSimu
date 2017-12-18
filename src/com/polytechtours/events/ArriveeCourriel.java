package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

import static com.polytechtours.events.EventsFactory.make_dated;
import static com.polytechtours.utils.Probabilite.exponentielle;

/**
 * Created by mika on 15/12/17.
 */
public class ArriveeCourriel extends Event{

    @Override
    public void execute(Variables variables) {
    	System.out.println("Arriv�e Courriel : " + getDate());

    	int date;
        if(getDate() >= convertHourToSecond(8) && getDate() < convertHourToSecond(9)){
            date = (int)convertMinuteToSecond(exponentielle(0.5f))* + getDate();
            //System.out.println("Expo : " + convertMinuteToSecond(exponentielle(0.5f)) + " " +  getDate());
        } else {
            date = (int)convertMinuteToSecond(exponentielle(5)) + getDate();
        }
        Echeancier.getInstance().ajouterEvenement(make_dated(new ArriveeCourriel(), date));
        
        variables.NbCourriel++;
        MiseaJourAires(variables);
        
        if(variables.N - variables.Nt - variables.Nc > 0) {
            variables.Nc ++;
            
            Echeancier.getInstance().ajouterEvenement(make_dated(new AccesCouriel(), getDate()));
        }

        variables.Qc++;
        variables.DDateSimu = variables.DateSimu;
    }
}
