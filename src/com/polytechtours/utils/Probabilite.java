package com.polytechtours.utils;

import java.util.Random;

public class Probabilite {
	public double exponentielle(float lambda) {
		Random rand = new Random();
	    return -(1 / lambda) * Math.log( 1 - rand.nextDouble() );
	}
	
	public int uniform(int min, int max) {
		Random rand = new Random();
		
		return (int)rand.nextDouble() * (max - min) + min;
	}
}
