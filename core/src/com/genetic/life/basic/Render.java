package com.genetic.life.basic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.genetic.life.client.Client;
import com.genetic.life.resources.Resources;
import com.genetic.life.utils.Vec2;

public class Render {
	
	public static SpriteBatch batch;
	private static FPSLogger fps;
	private static ShapeRenderer shapeRenderer;
	private static OrthographicCamera fixedCam;
	private static Vec2 resolution;
	
	
	public static void Load() {
		batch = new SpriteBatch();
		
		resolution = new Vec2(1920,1080);
		
		fixedCam = new OrthographicCamera();
		fixedCam.setToOrtho(false, getResX(), getResY());
		
		shapeRenderer = new ShapeRenderer();
		
		fps = new FPSLogger();
	}
	
	public static void render() {
		
		batch.begin();
		
		setCamera(Resources.client);
		
		clear();
		
		batch.end();
		renderLife(); // We let `Life` to choose whether to use SpriteBatch or others, like ShapreRenderer
		batch.begin();
		
		fpsLog();
		
		batch.flush();
		batch.end();
		
	}

	public static void clear() {
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	}
	
	private static void renderLife() {
		Life.render();
	}
	
	public static void fpsLog() {
		fps.log();
	}
	
	public static void setCamera(OrthographicCamera cam) {
		batch.setProjectionMatrix(cam.combined);
		shapeRenderer.setProjectionMatrix(cam.combined);
	}
	public static void setCamera(Client client) {
		setCamera(client.getCamera());
	}
	
	public static void drawRect(Color color, float x, float y, int width, int height) {
		shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
	}
	public static void drawRectFilled(Color color, float x, float y, int width, int height) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(color);
		shapeRenderer.rect(x, y, width, height);
		shapeRenderer.end();
	}
	public static void drawCircle(Color color, float x, float y, int radius) { // Centered!!
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(color);
		shapeRenderer.circle(x, y, radius);
		shapeRenderer.end();
	}
	public static void drawCircleFilled(Color color, float x, float y, int radius) { // Centered!!
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(color);
		shapeRenderer.circle(x, y, radius);
		shapeRenderer.end();
	}
	
	public static int getResX() {
		return (int)resolution.getX();
	}
	public static int getResY() {
		return (int)resolution.getY();
	}

	public static OrthographicCamera getFixedCamera() {
		return fixedCam;
	}
}
