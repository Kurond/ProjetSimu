package com.polytechtours.events;

import com.polytechtours.systeme.Variables;

public class Fin extends Event {

    @Override
    public void execute(Variables variables) {
    	System.out.println("Fin : " + getDate());
        MiseaJourAires(variables);
//        System.out.println(variables);
    }
}
