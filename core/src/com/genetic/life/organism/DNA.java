package com.genetic.life.organism;

import com.genetic.life.utils.MathUtil;

public class DNA {
	private int[] dna;
	
	public DNA(int size) {
		dna = new int[1];
		dna[0] = size;
	}
	
	public DNA() {
		this(MathUtil.nextInt(5, 120));
	}
	
	public int[] getDNA() {
		return dna;
	}
}
