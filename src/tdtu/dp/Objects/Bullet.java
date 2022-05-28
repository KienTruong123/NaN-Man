package tdtu.dp.Objects;

import java.awt.Graphics;

public abstract class Bullet extends Particle implements Cloneable {

	public Bullet(float x, float y, float width, float height, float mass, int damage, GWorld gameWorld) {
		super(x, y, width, height, mass, 1, gameWorld);
		setDamage(damage);
	}

	 
	public abstract void draw(Graphics g);

	public void update() {
		super.update();
		setX(getX() + getSpeedX());
		setY(getY() + getSpeedY());
		Particle object = getGameWorld().getParticleManager().getCollisionWidthEnemyObject(this);
		if (object != null && object.getState() == ALIVE) {
			setBlood(0);
		}
	}
	
	 @Override
	 public Bullet clone() {
	        try {
	            return (Bullet) super.clone();
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}