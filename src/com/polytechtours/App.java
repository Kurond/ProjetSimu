package com.polytechtours;


import com.polytechtours.events.*;
import com.polytechtours.systeme.Echeancier;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Echeancier eche = Echeancier.getInstance();
        
        Events1 test1 = new Events1();
        test1.setDate(10);
        
        
        Events1 test2= new Events1();
        test2.setDate(15);
        
        Events1 test3= new Events1();
        test3.setDate(0);
        
        eche.ajouterEvenement(test1);
        eche.ajouterEvenement(test2);
        eche.ajouterEvenement(test3);
        
        for(int i = 0; i < 3; i++) {
        	System.out.println(eche.retirerEvenement().getDate());
        }
    }
}
