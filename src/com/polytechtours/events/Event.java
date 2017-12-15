package com.polytechtours.events;

import com.polytechtours.systeme.Variables;

/**
 * Classe mere de tous les evenements
 * 
 * @author Charly
 */
public abstract class Event implements Comparable<Event> {
	/** date : store the date in minute. */
	private int date;

	/**
	 *	Contain the event's code
	 */

	public abstract void execute(Variables variables);
	
	public int compareTo(Event evenement) {
		if (date < evenement.date)
			return -1;
		else if (date > evenement.date)
			return 1;
		
		return 0;
    }
	
	// Getter & setters
	
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int convertHourToSecond(int heure) {
		return heure * 3600;
	}
}