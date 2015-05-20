package com.genetic.life.basic;

import com.genetic.life.resources.Resources;

public class Update {
	
	public static final float updateTime = 60/1000f;
	
	public static void update() {
		
		updateLife();
		
		updateClient();
		updateCameras();
	}

	private static void updateLife() {
		Life.update();
	}
	
	private static void updateClient() {
		Resources.client.update();
	}

	private static void updateCameras() {
		Resources.client.getCamera().update();
		Render.getFixedCamera().update();
	}
}
