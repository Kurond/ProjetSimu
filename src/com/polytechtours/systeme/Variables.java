package com.polytechtours.systeme;

import com.polytechtours.events.Event;

public class Variables
{
   public int N;
   public int Nt;
   public int Nc;
   public int Ntmax;
   public int Qt;
   public int Qc;
   public int NbAppel;
   public int NbCourriel;
   public int DateSimu;
   public int DDateSimu;
   public int AireQt;
   public int AireQc;
   public int AireNt;
   public int AireNc;
   public int AireTempsInactivite;

   
   
   @Override
   public String toString() {
	   return "Simulation terminee : \nNombre de conseiller" + N + "; Nombre de poste telephonique :" + Ntmax +
               "\n -----------------------------------------------" +
               "\n -------------------Resultat--------------------" +
               "\n -----------------------------------------------" +
               "\nNombre de courrier non traite : " + Nc +
               "\nTemps d'attente des clients au telephone : " + AireQt +
               "\nDelai de reponse aux courriels : " + (AireQc + AireNc) +
               "\nTaux d'occupation des conseillers : " + ((AireNt + AireNc) / ((Event.convertHourToSecond(12) -
                - Event.convertHourToSecond(8)) * N)) + "%" +
               "\nTaux d'occupation des postes telephoniques : " + (AireNt / ((Event.convertHourToSecond(12) -
               - Event.convertHourToSecond(8)) * Ntmax)) + "%";

   }
}
