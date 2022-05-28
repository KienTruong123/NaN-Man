package tdtu.dp.behavior;

import tdtu.dp.Objects.Bullet;
import tdtu.dp.Objects.FireBullet;
import tdtu.dp.Objects.GWorld;

import static tdtu.dp.Objects.Man.RUNSPEED;
import static tdtu.dp.Objects.Particle.LEFT_DIR;

public class RapidFireBehavior implements AttackBehavior{
    @Override
    public void attack(float x, float y, float speedX, float speedY, int direction, boolean teamType, GWorld gWorld) {
        Bullet fireBullet=FireShootingBehavior.createBullet(x, y, speedX, speedY, direction, teamType, gWorld);
        for(int i=0;i<2; i++) {
            Bullet cloneBullet = fireBullet.clone();
            cloneBullet.setX(i*(direction==LEFT_DIR?-30:30)+x);
            gWorld.getParticleManager().addObject(cloneBullet);
        }
    }
}
