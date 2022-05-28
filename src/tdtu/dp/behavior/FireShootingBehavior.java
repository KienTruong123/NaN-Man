package tdtu.dp.behavior;

import tdtu.dp.Objects.Bullet;
import tdtu.dp.Objects.FireBullet;
import tdtu.dp.Objects.GWorld;

import static tdtu.dp.Objects.Man.RUNSPEED;
import static tdtu.dp.Objects.Particle.LEFT_DIR;

public class FireShootingBehavior implements AttackBehavior{
    @Override
    public void attack(float x, float y, float speedX,float speedY, int direction,boolean teamType , GWorld gWorld) {
        Bullet fireBullet=createBullet(x, y, speedX, speedY, direction, teamType, gWorld);
        gWorld.getParticleManager().addObject(fireBullet);
    }

    static Bullet createBullet(float x, float y, float speedX, float speedY, int direction, boolean teamType, GWorld gWorld) {
        FireBullet fireBullet = new FireBullet(x, y , gWorld);
        fireBullet.setDirection(direction);
        fireBullet.setTeamType(teamType);
        if (direction == LEFT_DIR) {
            fireBullet.setX(fireBullet.getX());
            fireBullet.setSpeedX(-RUNSPEED * 2);
            if (speedX != 0 && speedY == 0) {
                fireBullet.setX(fireBullet.getX() - speedX);
            }
        } else {
            fireBullet.setX(fireBullet.getX() );
            fireBullet.setSpeedX(RUNSPEED * 2);
            if (speedX != 0 && speedY == 0) {
                fireBullet.setX(fireBullet.getX() + speedX);
            }
        }
        return fireBullet;
    }
}
