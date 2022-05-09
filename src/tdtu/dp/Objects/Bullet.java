package tdtu.dp.Objects;

import java.awt.Graphics;

public abstract class Bullet extends Particle {

    public Bullet(double d, double e, float width, float height, float mass, int damage, GWorld gameWorld) {
            super(d, e, width, height, mass, 1, gameWorld);
            setDamage(damage);
    }
    
    public abstract void draw(Graphics g);

    public void update(){
        super.update();
        setX(getX() + getSpeedX());
//        setY(getY() + getSpeedY());
    }
    
}