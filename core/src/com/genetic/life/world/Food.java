package com.genetic.life.world;

import com.badlogic.gdx.graphics.Color;
import com.genetic.life.basic.Life;
import com.genetic.life.basic.Render;
import com.genetic.life.utils.MathUtil;
import com.genetic.life.utils.Vec2;

public class Food {
	
	private static int WIDTH = 80, HEIGHT = 60;
	private static int COLLISION = 20;
	
	private Vec2 position;
	private Vec2 size;
	
	public Food(Vec2 position) {
		this.position = position;
		this.size = new Vec2(getWidth(), getHeight());
	}
	public Food(float x, float y) {
		this(new Vec2(x,y));
	}
	public Food() {
		this(MathUtil.nextFloat(0, Life.getSize()), MathUtil.nextFloat(0, Life.getSize()));
	}
	
	public Vec2 getPosition() {
		return position;
	}
	
	public void draw() {
		float red = position.getX()/Life.getSize()*255/255;
		float green = position.getY()/Life.getSize()*255/255;
		float blue = (red+green)/2;
		
		Render.drawRectFilled(new Color(red, green, blue, 1), position.getX()-size.getX()/2, position.getY()-size.getY()/2, (int)size.getX(), (int)size.getY());
	}
	
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	
	public static int getCollision() {
		return COLLISION;
	}
	public static void setCollision(int collision) {
		COLLISION = collision;
	}
}
