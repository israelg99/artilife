package com.genetic.life.organism;

import com.genetic.life.utils.MathUtil;

public class DNA {
	
	private static int MIN_DNA = 5, MAX_DNA = 120;
	
	private int[] dna;
	
	public DNA(DNA newDNA) {
		dna = new int[newDNA.getDNA().length];
		for(int i = 0; i < getLength(); i++) {
			setGene(i, newDNA.getGene(i));
		}
	}
	
	public DNA(int size) {
		dna = new int[1];
		setGene(0, size);
	}
	
	public DNA() {
		this(MathUtil.nextInt(MIN_DNA, MAX_DNA));
	}
	
	public int[] getDNA() {
		return dna;
	}
	public int getLength() {
		return getDNA().length;
	}
	
	public void setGene(int i, int gene) {
		getDNA()[i] = gene;
	}
	public int getGene(int i) {
		return getDNA()[i];
	}
	
	public void uniform_crossover(DNA dna2, float uniformRate) {
		dna = uniform_crossover(this, dna2, uniformRate).getDNA();
	}
	public void point_crossover(DNA dna2) {
		dna = point_crossover(this, dna2).getDNA();
	}
	public void mutate(float mutationRate) {
		dna = mutate(this, mutationRate).getDNA();
	}
	
	public static DNA uniform_crossover(DNA dna1, DNA dna2, float uniformRate) {
		DNA newDNA = new DNA(dna1);
        
        // Loop through genes
        for (int i = 0; i < newDNA.getLength(); i++) {
            // Crossover
            if (MathUtil.nextFloat() <= uniformRate) {
                newDNA.setGene(i, dna2.getGene(i));
            }
        }
        
        return newDNA;
    }
	
	public static DNA point_crossover(DNA dna1, DNA dna2) {
    	DNA newDNA = new DNA(dna1);
    	
    	// Crossover
    	
    	// Offest for the point crossover
    	int offest = MathUtil.nextInt(0, newDNA.getLength()-1);
    	
    	// Crossover after the offest
    	for (int i = offest; i < newDNA.getLength(); i++) {
    		// Crossover
    		newDNA.setGene(i, dna2.getGene(i));
    	}
    	
    	return newDNA;
    }

    // Mutate an individual
	public static DNA mutate(DNA source, float mutationRate) {
        
		DNA dna = new DNA(source);
		
		// Loop through genes
        for (int i = 0; i < dna.getLength(); i++) {
            if (MathUtil.nextFloat() <= mutationRate) {
                // Create random gene
            	int gene = dna.getGene(i);
                dna.setGene(i, MathUtil.nextInt(gene/2, gene + gene/2));
            }
        }
        
        return dna;
    }
}
