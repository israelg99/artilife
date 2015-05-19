package com.genetic.life.basic;

public class LoopManager {
	
	public static void tick() {
		Update.update();
		Render.render();
	}
}
