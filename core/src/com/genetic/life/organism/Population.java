package com.genetic.life.organism;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.genetic.life.utils.MathUtil;

public class Population {
	
	private static int MIN_POP = 200;
	private static int MAX_POP = 400;
	
	private List<Drone> pop;
	
	public Population(int length) {
		pop = new ArrayList<Drone>();
		for(int i = 0; i < length; i++) {
			pop.add(new Drone(new DNA()));
		}
	}
	public Population() {
		this(MathUtil.nextInt(MIN_POP, MAX_POP));
	}
	
	public void update() {
		Iterator<Drone> it = getPopulation().iterator();
		while (it.hasNext()) {
		    Drone drone = it.next();
		    if (drone.isAlive()) {
		        drone.update(it);
		    } else {
		    	it.remove();
		    }
		}
	}
	
	public void render() {
		for(int i = 0; i < pop.size(); i++) {
			getPopulation().get(i).draw();
		}
	}
	
	public List<Drone> getPopulation() {
		return pop;
	}
	
	public int getSize() {
		return getPopulation().size();
	}
	
	public Drone get(int i) {
		return getPopulation().get(i);
	}
}
