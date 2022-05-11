package tdtu.dp.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ghost extends Human {
	public static final float RUNSPEED = 0.5f;
	
	private Image ghostImage;
	private long startTimeToShoot;

	public Ghost(float x, float y, GWorld gameWorld) {
		super(x, y, 25, 25, 0.1f, 100, gameWorld);
		startTimeToShoot = 0;
		setTimeForNoBehurt(300000000);
		setDamage(10);
		super.setTeamType(ENEMY);

		ghostImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/ghost.gif").getImage();
	}

	@Override
	public void attack() {

		Bullet bullet = new FireBullet(getX(), getY()-getHeight()/2, getGameWorld());

		if (getDirection() == RIGHT_DIR) {
			bullet.setDirection(LEFT_DIR);
			bullet.setSpeedX(-5);

		} else {
			bullet.setSpeedX(5);
			bullet.setDirection(RIGHT_DIR);
		}
		bullet.setTeamType(getTeamType());
		getGameWorld().getParticleManager().addObject(bullet);

	}

	public void update() {
		if (getX() - getGameWorld().getMan().getX() > 0) {
			setDirection(Particle.RIGHT_DIR);
		} else {
			setDirection(Particle.LEFT_DIR);
		}
		run();
		handleAction();

		if (System.nanoTime() - startTimeToShoot > 1000 * 1000000 * 2.5) {
			attack();
			startTimeToShoot = System.nanoTime();
		}
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		Rectangle rect = getBoundForCollisionWithMap();
		rect.x += 20;
		rect.width -= 40;
		return rect;
	}

	@Override
	public void draw(Graphics g) {
		if (!isObjectOutOfCameraView()) {
			if (getState() == NOBEHURT && (System.nanoTime() / 10000000) % 2 != 1) {
				// plash...
			} else {
				g.drawImage(ghostImage, (int) (getX() - getGameWorld().getCamera().getX() - 10),
						(int) (getY() - getGameWorld().getCamera().getY() - 10), null);

			}
		}
		drawBoundForCollisionWithMap(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (getDirection() == RIGHT_DIR)
			setSpeedX(-RUNSPEED);
		else
			setSpeedX(RUNSPEED);

	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub

	}

	@Override
	public void duck() {
		// TODO Auto-generated method stub

	}

	@Override
	public void standUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
}
