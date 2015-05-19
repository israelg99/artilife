package com.genetic.life.world;

import java.util.ArrayList;
import java.util.List;

public class Foods {
	
	private static int MIN_FOODS = 400;
	private static int MAX_FOODS = 800;
	
	private List<Food> foods;
	
	public Foods(int length) {
		foods = new ArrayList<Food>();
		for(int i = 0; i < length; i++) {
			foods.add(new Food());
		}
	}
	public Foods() {
		this(MAX_FOODS); // It will always fill to max after the food size is under or equal to the average number of min and max foods together.
	}
	
	public void remove(int i) {
		getFoods().remove(i);
	}
	
	public void update() {
		if(getSize() <= (MIN_FOODS+MAX_FOODS)/2) {
			for(int i = 0; i < MAX_FOODS-getSize(); i++) {
				foods.add(new Food());
			}
		}
	}
	
	public void render() {
		for(int i = 0; i < foods.size(); i++) {
			getFoods().get(i).draw();
		}
	}
	
	public List<Food> getFoods() {
		return foods;
	}
	
	public int getSize() {
		return getFoods().size();
	}
	
	public Food getFood(int i) {
		return getFoods().get(i);
	}
}
