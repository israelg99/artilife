package com.genetic.life.organism;

import java.util.Iterator;
import java.util.ListIterator;

import com.badlogic.gdx.graphics.Color;
import com.genetic.life.basic.Life;
import com.genetic.life.basic.Render;
import com.genetic.life.basic.Update;
import com.genetic.life.utils.MathUtil;
import com.genetic.life.utils.Vec2;
import com.genetic.life.world.Food;

public class Drone {
	
	private static int ENERGY = 10;
	private static float mutationRate = 0.5f;
	
	private Vec2 position;
	private Vec2 velocity;
	
	private float max_health;
	private float health;
	private int radius;
	private int speed;
	
	private boolean isAlive;
	
	private DNA dna;
	
	public Drone(DNA source, Vec2 pos) {
		this.setDNA(source);
		
		int DNA = this.dna.getDNA()[0];
		this.setRadius(DNA);
		this.setMaxHP(DNA * 5);
		this.setHealth(this.getMaxHP());
		this.setSpeed(4000/DNA);
		
		this.setPosition(pos);
		this.setVelocity(new Vec2(0,0));
		
		this.setAlive(true);
	}
	public Drone(DNA dna) {
		this(dna, new Vec2(MathUtil.nextInt(0, Life.getSize()), MathUtil.nextInt(0, Life.getSize())));
	}
	
	public Drone() {
		this(new DNA());
	}
	
	public void update(ListIterator<Drone> it) {
		applyScouting();
		updatePosition();
		applyEating();
		applyReproduction(it);
		updateHealth(it);
	}
	
	private void applyReproduction(ListIterator<Drone> it) {
		if(getHealth() > getEnergy() && MathUtil.nextInt(1, 1200) == 1) {
			Drone drone = new Drone(DNA.mutate(getDNA(), mutationRate), new Vec2(getPosition().getX(), getPosition().getY()-getRadius()));
			drone.setHealth(getHealth());
			it.add(drone);
		}
	}

	private void applyEating() {
		Iterator<Food> it = Life.getFoods().getFoods().iterator();
		while (it.hasNext()) {
		    Food food = it.next();
		    
		    if(MathUtil.inRange(MathUtil.getDistance(getPosition(), food.getPosition()), Food.getCollision() + getRadius())) {
		    	it.remove();
		    	maxHealth();
		    }
		}
	}
	
	private void applyScouting() {
		if(Math.round(health) % 10 == 0 ) {
			getVelocity().setX(randomizeVelocity());
			getVelocity().setY(randomizeVelocity());
		}
	}
	
	private void updatePosition() {
		getPosition().add(velocity);
	}
	
	private void updateHealth(ListIterator<Drone> it) {
		health -= Update.updateTime * getEnergy();
		if(getHealth() <= 0) {
			setAlive(false);
			it.remove();
		}
	}
	
	private float randomizeVelocity() {
//		float temp = MathUtil.nextFloat(speed/1.5f, speed);
		float temp = speed;
		if(MathUtil.nextInt(1, 2) == 1) {
			temp *= -1;
		}
		
		temp *= Update.updateTime;
		
		return temp;
	}
	
	public void draw() {
		Render.drawCircleFilled(new Color((getHealth())/255f, 0, 0, 0.5f), getPosition().getX(), getPosition().getY(), getRadius());
	}
	
	private void maxHealth() {
		setHealth(getMaxHP());
	}

	public float getHealth() {
		return health;
	}
	public void setHealth(float health) {
		this.health =  health < getMaxHP() ? health : getMaxHP();
	}

	public int getRadius() {
		return radius;
	}
	public void setRadius(int size) {
		this.radius = size;
	}

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Vec2 getPosition() {
		return position;
	}
	public void setPosition(Vec2 position) {
		this.position = position;
	}

	public Vec2 getVelocity() {
		return velocity;
	}
	public void setVelocity(Vec2 velocity) {
		this.velocity = velocity;
	}

	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public float getMaxHP() {
		return max_health;
	}
	public void setMaxHP(float max_health) {
		this.max_health = max_health;
	}

	public static int getEnergy() {
		return ENERGY;
	}
	public static void setEnergy(int energy) {
		ENERGY = energy;
	}
	
	public DNA getDNA() {
		return dna;
	}
	public void setDNA(DNA dna) {
		this.dna = dna;
	}
}
