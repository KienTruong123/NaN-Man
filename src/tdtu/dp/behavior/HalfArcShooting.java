package tdtu.dp.behavior;

import tdtu.dp.Objects.Bullet;
import tdtu.dp.Objects.FireBullet;
import tdtu.dp.Objects.GWorld;

import static tdtu.dp.Objects.Man.RUNSPEED;
import static tdtu.dp.Objects.Particle.LEFT_DIR;

public class HalfArcShooting implements AttackBehavior{
    @Override
    public void attack(float x, float y, float speedX, float speedY, int direction, boolean teamType, GWorld gWorld) {
        Bullet fireBullet =FireShootingBehavior.createBullet(x, y, speedX, speedY, direction, teamType, gWorld);
        for(int i=1;i<6; i++) {
            Bullet cloneBullet = fireBullet.clone();
            cloneBullet.setSpeedY(i);
            if(LEFT_DIR==direction){cloneBullet.setSpeedX(-3*(float) Math.sin(0.5*i));}
            else{cloneBullet.setSpeedX(3*(float) Math.sin(0.5*i));}
            gWorld.getParticleManager().addObject(cloneBullet);
        }

    }
}
