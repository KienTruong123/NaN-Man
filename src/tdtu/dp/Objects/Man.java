package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.text.Position;

import tdtu.dp.UI.GameFrame;

public class Man {
	private float x;
	private float y;
	private float width;
	private float height;
	private float mass;
	private float speedX;
	private float speedY;
	private float direction;
	public static int DIR_LEFT;
	public static int DIR_RIGHT;
	
//	public Man() {
//	// TODO Auto-generated constructor stub
//}

	public Man(float x, float y, float width, float height, float mass) {
		super();
		_init(x, y, width, height, mass);
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public float getDirection() {
		return direction;
	}

	public void setDirection(float direction) {
		this.direction = direction;
	}

	private void _init(float x, float y, float width, float height, float mass) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setMass(mass);
	}

	public void update() {
		setX(getX() + getSpeedX());

		if (getY() < GameFrame.SCREEN_HEIGHT-130) {
			setY(getY() + getSpeedY());
			setSpeedY(getSpeedY() + getMass());
		}

	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

}
