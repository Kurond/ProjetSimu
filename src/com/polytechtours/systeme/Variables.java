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
   public int TempsInactivite;
   public int DateSimu;
   public int DDateSimu;
   public int AireQt;
   public int AireQc;
   public int AireNt;
   public int AireNc;
   public int AireTempsInactivite;

   
   
   @Override
   public String toString() {
	   return "AireQt : " + AireQt + "\n" +
			   "AireQc : " + AireQc + "\n" +
			   "AireNt : " + AireNt + "\n" +
			   "AireNc : " + AireNc + "\n" +
			   "AireTempsInactivite : " + AireTempsInactivite + "\n"; 
   }
}
