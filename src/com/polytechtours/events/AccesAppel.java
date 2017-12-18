package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

import static com.polytechtours.events.EventsFactory.make_dated;
import static com.polytechtours.utils.Probabilite.uniform;

/**
 * Created by mika on 18/12/17.
 */
public class AccesAppel extends Event {

    /**
     * Contain the event's code
     *
     * @param variables
     */
    @Override
    public void execute(Variables variables) {
    	System.out.println("Acces Appel : " + getDate());
    	
        MiseaJourAires(variables);

        int date = (int)(uniform(convertMinuteToSecond(5),convertMinuteToSecond(15))) + getDate();

        Echeancier.getInstance().ajouterEvenement(make_dated(new FinAppel(), date));
        
        variables.Qt--;

        variables.DDateSimu = variables.DateSimu;
    }
}
