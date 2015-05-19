package com.genetic.life.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.genetic.life.basic.Render;

public class Client implements InputProcessor {

	private static final int DEFAULT_SPEED = 20;
	
	private OrthographicCamera camera;
	
	private boolean isUp, isDown, isLeft, isRight;
	private int speed;
	
	public Client() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Render.getResX(), Render.getResY());
		camera.position.set(0,0,0);
		
		speed = DEFAULT_SPEED;
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
	
	public void update() {
		Vector3 pos = camera.position;
		if(isUp) {
			pos.y += speed;
		}
		if(isDown) {
			pos.y -= speed;
		}
		if(isLeft) {
			pos.x -= speed;
		}
		if(isRight) {
			pos.x += speed;
		}
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			case InputKeys.UP: 
				isUp = true;
			break;
			
			case InputKeys.DOWN: 
				isDown = true;
			break;
			
			case InputKeys.LEFT: 
				isLeft = true;
			break;
			
			case InputKeys.RIGHT: 
				isRight = true;
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
			case InputKeys.UP: 
				isUp = false;
			break;
			
			case InputKeys.DOWN: 
				isDown = false;
			break;
			
			case InputKeys.LEFT: 
				isLeft = false;
			break;
			
			case InputKeys.RIGHT: 
				isRight = false;
			break;
			
			case InputKeys.EXIT:
				Gdx.app.exit();
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
