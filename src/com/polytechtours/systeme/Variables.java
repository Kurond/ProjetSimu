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
   public int DDateSimu;
   public int AireQt;
   public int AireQc;
   public int AireNt;
   public int AireNc;
   public int AireTempsInactivite;


   public double convertsecondToMinute(double seconde) {
      return seconde / 60;
   }

   public String toString() {
         float AireN = AireNt + AireNc;
         float AireTotalN = (Event.convertHourToSecond(12)
              - Event.convertHourToSecond(8)) * N;
         float res = (AireN / AireTotalN) * 100;
         float AireTotalNtmax = ((Event.convertHourToSecond(12) - Event.convertHourToSecond(8)) * Ntmax);
         float res2 = (AireNt / AireTotalNtmax) * 100 ;


	   return "Simulation terminee : \nNombre de conseillers : " + N + "; Nombre de postes telephoniques :" + Ntmax +
               "\n -----------------------------------------------" +
               "\n -------------------Resultat--------------------" +
               "\n -----------------------------------------------" +
               "\nNombre de courrier : " + NbCourriel +
               "\nNombre d'appel : " + NbAppel +
               "\nNombre de courrier non traite : " + Qc +
               "\nTemps d'attente des clients au telephone : " + convertsecondToMinute(AireQt) +"min"+
               "\nDelai de reponse aux courriels : " + convertsecondToMinute(AireQc + AireNc) + "min"+
               "\nTaux d'occupation des conseillers : " + res + "%" +
               "\nTaux d'occupation des postes telephoniques : " + res2 + "%";

   }
}
