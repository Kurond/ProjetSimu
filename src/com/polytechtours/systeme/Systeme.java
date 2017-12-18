package com.polytechtours.systeme;

import com.polytechtours.events.*;

/**
 * 
 * @author Charly
 */
public class Systeme {
	
	public Systeme() {
		Echeancier echeancier = Echeancier.getInstance();
		Variables vars = new Variables();
		
		Debut evenementDebut = new Debut();
		evenementDebut.setDate(0);
		
		echeancier.ajouterEvenement(evenementDebut);
		
		System.out.println("init");
		Event evenement;
		while(((evenement = echeancier.retirerEvenement()) != null) && !(evenement instanceof Fin)){
			evenement.execute(vars);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("execute event at date " + evenement.getDate());
			
			/*if (evenement instanceof Debut) {
				System.out.println("Debut");
			} else if (evenement instanceof ArriveeAppel) {
				System.out.println("Appel");
			} else if (evenement instanceof ArriveeCourriel) {
				System.out.println("Courriel");
			}*/
		}
		
		System.out.println(vars.toString());
	}
}

