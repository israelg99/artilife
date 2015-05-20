package com.genetic.life.utils;

import java.util.Random;

public class MathUtil {
	
	public static Random random = new Random();
	
	public static int nextInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	public static float nextFloat(float min, float max) {
		return min + (nextFloat() * ((max - min) + 1));
	}
	public static float nextFloat() {
		return random.nextFloat();
	}
	
	public static float getDistance(Vec2 vec1, Vec2 vec2) {
		return (float) Math.sqrt(Math.pow(vec1.getX() - vec2.getX(), 2) + Math.pow(vec1.getY() - vec2.getY(), 2));
	}
	public static boolean inRange(float pos, float range) {
		return pos < range && pos > 0;
	}
}
