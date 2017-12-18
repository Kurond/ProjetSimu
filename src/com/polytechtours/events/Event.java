package com.polytechtours.events;

import com.polytechtours.systeme.Variables;

/**
 * Classe mere de tous les evenements
 * 
 * @author Charly
 */
public abstract class Event implements Comparable<Event> {
	/** date : store the date in secondes. */
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

	public int convertHourToSecond(double heure) {
		return (int) (heure * 3600);
	}

	public int convertMinuteToSecond(double minute) {
		return (int)(minute * 60);
	}
	/**
	 * @author Amine 
	 * @param var
	 */
	public void MiseaJourAires(Variables var)
	{
		var.AireTempsInactivite += (var.DateSimu - getDate())*(var.N - var.Nt - var.Nc);
		var.AireQc += var.Qc * (var.DateSimu - getDate());
		var.AireQt += var.Qt * (var.DateSimu - getDate());
		var.AireNc += var.Nc * (var.DateSimu - getDate());
		var.AireNt += var.Nt * (var.DateSimu - getDate());

	}
}