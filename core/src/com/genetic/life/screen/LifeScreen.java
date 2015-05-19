package com.genetic.life.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.genetic.life.basic.LoopManager;
import com.genetic.life.resources.Resources;

public class LifeScreen implements Screen {

	public LifeScreen() {
		Gdx.input.setInputProcessor(Resources.client);
	}

	@Override
	public void render(float delta) {
		LoopManager.tick();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
