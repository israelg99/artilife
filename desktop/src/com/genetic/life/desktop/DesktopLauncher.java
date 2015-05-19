package com.genetic.life.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.genetic.life.GdxLife;


public class DesktopLauncher {
	public static void main (String[] arg) {
		System.out.println("Initializing the Window!");
		Window.Initialize("Genetic Life - The Big Bang 0.01a", true);
		System.err.println("The Window has Initialized");
		
		System.out.println("Calling the Game!");
		new LwjglApplication(new GdxLife(), Window.getCFG());
		
	}
}
