package com.genetic.life.utils;

import java.io.Serializable;

public class Vec2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private float x, y;
	
	public Vec2(float xa, float ya) {
		this.x = xa;
		this.y = ya;
	}
	public Vec2() {
		this(0, 0);
	}
	public Vec2(Vec2 vec) {
		this(vec.x, vec.y);
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public void set(float num) {
		setX(num);
		setY(num);
	}
	public void set(float xa, float ya) {
		setX(xa);
		setY(ya);
	}
	public void setX(float xa) {
		x = xa;
	}
	public void setY(float ya) {
		y = ya;
	}
	
	public void add(float num) {
		addX(num);
		addY(num);
	}
	public void sub(float num) {
		subX(num);
		subY(num);
	}
	public void add(float xa, float ya) {
		addX(xa);
		addY(ya);
	}
	public void sub(float xa, float ya) {
		subX(xa);
		subY(ya);
	}
	public void add(Vec2 vec) {
		add(vec.getX(), vec.getY());
	}
	public void sub(Vec2 vec) {
		sub(vec.getX(), vec.getY());
	}
	public void addX(float num) {
		x+=num;
	}
	public void subX(float num) {
		x-=num;
	}
	public void addY(float num) {
		y+=num;
	}
	public void subY(float num) {
		y-=num;
	}
	
	public float getBoth() {
		return x+y;
	}
	public float getMultiplied() {
		return x*y;
	}
}

