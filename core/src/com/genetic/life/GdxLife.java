package com.genetic.life;

import com.badlogic.gdx.Game;
import com.genetic.life.resources.Resources;
import com.genetic.life.screen.LifeScreen;

public class GdxLife extends Game {

	@Override
	public void create() {
		Resources.Load();
		setScreen(new LifeScreen());
	}
}
