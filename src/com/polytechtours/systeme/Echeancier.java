package com.polytechtours.systeme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.polytechtours.events.Event;

public class Echeancier {
    private static Echeancier instance = null;
    
    private ArrayList<Event> events;
    
    private Echeancier() {
    	this.events = new ArrayList<Event>();
    }

    public void ajouterEvenement(Event evenement) {
    	//System.out.println("Date : " + evenement.getDate());
    	
    	this.events.add(evenement);
    	Collections.sort(events);
    }
    
    public Event retirerEvenement(){
    	Event retour = null;
    	
    	try {
    		retour = this.events.get(0);
    		this.events.remove(retour);
    	} catch(IndexOutOfBoundsException e) {
    		retour = null;
    	}
    	
    	return retour;
    }

    /**
     * @return l'instance de l'echeancier
     */
    public static Echeancier getInstance() {
        if (instance == null)
            instance = new Echeancier();

        return instance;
    }
}
