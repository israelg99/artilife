package com.genetic.life.basic;

import com.genetic.life.organism.Drone;
import com.genetic.life.organism.Population;
import com.genetic.life.world.Food;
import com.genetic.life.world.Foods;

public class Life {
	
	private static int SIZE = 10000;
	
	private static Population pop;
	private static Foods foods;
	
	public static void Load(int pop_length, int foods_length) {
		setPop(new Population(pop_length));
		setFoods(new Foods(foods_length));
	}
	public static void Load() {
		setPop(new Population());
		setFoods(new Foods());
	}
	
	public static void update() {
		getPop().update();
		getFoods().update();
	}
	public static void render() {
		getPop().render();
		getFoods().render();
	}
	
	public static int getSize() {
		return SIZE;
	}
	public static void setSize(int sIZE) {
		SIZE = sIZE;
	}
	
	public static Population getPop() {
		return pop;
	}
	public static void setPop(Population pop) {
		Life.pop = pop;
	}
	
	public static Foods getFoods() {
		return foods;
	}
	public static void setFoods(Foods foods) {
		Life.foods = foods;
	}
	
	public static Drone getDrone(int i) {
		return getPop().get(i);
	}
	public static Food getFood(int i) {
		return getFoods().getFood(i);
	}
}
