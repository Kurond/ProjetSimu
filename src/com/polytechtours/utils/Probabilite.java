package com.polytechtours.utils;

import java.util.Random;

import com.polytechtours.systeme.Variables;

public class Probabilite 
{
	public static double exponentielle(float lambda) {
		Random rand = new Random();
		double test = rand.nextDouble();
		//System.out.println(test);
	    return -(1 / lambda) * Math.log( 1 - test );
		//return lambda * Math.exp(-lambda * test);
	}
	
	public static int uniform(int min, int max) {
		Random rand = new Random();
		
		return (int)(rand.nextDouble() * (max - min) + min);
	}
	

}
