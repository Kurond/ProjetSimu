package com.polytechtours.systeme;

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
	   return "Simulation terminee : \nNombre de teleconseiller" + N + "; Nombre de poste telephonique :" + Ntmax +
               "\n -----------------------------------------------" +
               "\n -------------------Resultat--------------------" +
               "\n -----------------------------------------------" +
               "\n Nombre de courrier non traite : " + Nc +
               "\n Temps d'attente des clients au telephone : " + AireQt +
               "\n Delai de reponse aux courriels : " + (AireQc + AireNc);

   }
}
