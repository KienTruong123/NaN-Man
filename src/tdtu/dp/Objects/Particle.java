package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Particle extends GObject {

	public static final boolean LEAGUE = true;
	public static final boolean ENEMY = false;

	public static final int LEFT_DIR = 0;
	public static final int RIGHT_DIR = 1;

	public static final int ALIVE = 0;
	public static final int BEHURT = 1;
	public static final int NOBEHURT = 2;
	public static final int DEATH = 3;
	
	private int state = ALIVE;

	private float width;
	private float height;
	private float mass;
	private float speedX;
	private float speedY;
	private int blood;

	private int damage;
	private int direction;

	private boolean isTeammate;

	private long startTimeNoBeHurt;
	private long timeForNoBeHurt;

	public Particle(double d, double e, float width, float height, float mass, int blood, GWorld gameWorld) {
		super(d, e, gameWorld);
		setWidth(width);
		setHeight(height);
		setMass(mass);
		setBlood(blood);
		direction = RIGHT_DIR;
	}

	public long getStartTimeNoBeHurt() {
		return startTimeNoBeHurt;
	}

	public void setStartTimeNoBeHurt(long startTimeNoBeHurt) {
		this.startTimeNoBeHurt = startTimeNoBeHurt;
	}

	public void setTimeForNoBehurt(long time) {
		timeForNoBeHurt = time;
	}

	public long getTimeForNoBeHurt() {
		return timeForNoBeHurt;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setTeamType(Boolean team) {
		isTeammate = team;
	}

	public boolean getTeamType() {
		return isTeammate;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

	public float getMass() {
		return mass;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setBlood(int blood) {
		if (blood >= 0)
			this.blood = blood;
		else
			this.blood = 0;
	}

	public int getBlood() {
		return blood;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getWidth() {
		return width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}

	public abstract void attack();

	public boolean isObjectOutOfCameraView() {
		if (getX() - getGameWorld().getCamera().getX() > getGameWorld().getCamera().getWidthView()
				|| getX() - getGameWorld().getCamera().getX() < -50
				|| getY() - getGameWorld().getCamera().getY() > getGameWorld().getCamera().getHeightView()
				|| getY() - getGameWorld().getCamera().getY() < -50)
			return true;
		return false;
	}

	public Rectangle getBoundForCollisionWithMap() {
		Rectangle bound = new Rectangle((int) (getX() - (getWidth() / 2)), (int) (getY() - (getHeight() / 2)),
				(int) getWidth(), (int) getHeight());
		return bound;
	}

	public void beHurt(int damage) {
		setBlood(getBlood() - damage);
		setState(BEHURT);
		hurtingCallback();
	}

	@Override
	public void update() {
		switch (state) {
		case ALIVE:
		case NOBEHURT:
			if (System.nanoTime() - getStartTimeNoBeHurt() > getTimeForNoBeHurt())
				state = ALIVE;
			break;
		}

	}

	public void drawBoundForCollisionWithMap(Graphics g) {
		Rectangle rect = getBoundForCollisionWithMap();
		g.setColor(Color.BLUE);
		g.drawRect(rect.x - (int) getGameWorld().getCamera().getX(), rect.y - (int) getGameWorld().getCamera().getY(),
				rect.width, rect.height);
	}

	public void drawBoundForCollisionWithEnemy(Graphics g) {
		Rectangle rect = getBoundForCollisionWithEnemy();
		g.setColor(Color.RED);
		g.drawRect(rect.x - (int) getGameWorld().getCamera().getX(), rect.y - (int) getGameWorld().getCamera().getY(),
				rect.width, rect.height);
	}

	public abstract Rectangle getBoundForCollisionWithEnemy();

	public abstract void draw(Graphics g);

	public void hurtingCallback() {
	};

}
