package com.genetic.life.resources;

import com.genetic.life.basic.Life;
import com.genetic.life.basic.Render;
import com.genetic.life.client.Client;

public class Resources {
	
	public static Client client;
	
	public static void Load() {
		Render.Load();
		Life.Load();
		
		client = new Client();
	}
}
