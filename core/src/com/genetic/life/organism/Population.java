package com.genetic.life.organism;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.genetic.life.utils.MathUtil;

public class Population {
	
	private static int MIN_POP = 200;
	private static int MAX_POP = 400;
	
	private List<Drone> pop;
	
	public Population(int length) {
		pop = new ArrayList<Drone>();
		for(int i = 0; i < length; i++) {
			pop.add(new Drone());
		}
	}
	public Population() {
		this(MathUtil.nextInt(MIN_POP, MAX_POP));
	}
	
	public void update() {
		ListIterator<Drone> it = getPopulation().listIterator();
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
