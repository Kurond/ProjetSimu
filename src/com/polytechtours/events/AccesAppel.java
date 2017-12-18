package com.polytechtours.events;

import com.polytechtours.systeme.Echeancier;
import com.polytechtours.systeme.Variables;
import com.polytechtours.utils.Probabilite;

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
        MiseaJourAires(variables);
        Probabilite probabilite = new Probabilite();
        FinAppel finAppel = new FinAppel();
        int date = (int)convertMinuteToSecond(probabilite.uniform(5,15)) + getDate();
        finAppel.setDate(date);
        Echeancier.getInstance().ajouterEvenement(finAppel);
        variables.Qt --;
        variables.DDateSimu = variables.DateSimu;
    }
}
