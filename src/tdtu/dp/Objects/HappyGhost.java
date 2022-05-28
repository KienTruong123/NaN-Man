package tdtu.dp.Objects;

import tdtu.dp.behavior.AttackBehavior;
import tdtu.dp.behavior.RapidFireBehavior;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class HappyGhost extends Ghost {
	public static final float RUNSPEED = 0.5f;
	private long startTimeToShoot;
	private AttackBehavior attackBehavior;
	private Image ghostLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/ghostLeft.gif")
			.getImage();
	private Image ghostRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/ghostRight.gif")
			.getImage();

	public HappyGhost(float x, float y, GWorld gameWorld) {
		super(x, y, 25, 25, 0.1f, 10, 10, gameWorld);
		startTimeToShoot = 0;
		setTimeForNoBehurt(2000000000);
		setDamage(10);
		setTeamType(ENEMY);
		setState(ALIVE);
		this.attackBehavior=new RapidFireBehavior();
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		Rectangle rect = getBoundForCollisionWithMap();
		return rect;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (getDirection() == LEFT_DIR)
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
	
	@Override
	public void attack() {
		attackBehavior.attack(getX(),getY(),getSpeedX(),getSpeedY(),getDirection(),getTeamType(),getGameWorld());
	}

	@Override
	public void update() {
		super.update();
		if (getX() - getGameWorld().getMan().getX() > 0) {
			setDirection(Particle.LEFT_DIR);
			ghostImage = ghostLeftImage;
		} else {
			setDirection(Particle.RIGHT_DIR);
			ghostImage = ghostRightImage;
		}
		
		run();
		handleAction();
		if (System.nanoTime() - startTimeToShoot > 1000 * 1000000 *3.) {
			attack();
			startTimeToShoot = System.nanoTime();
		}
	}
	
	
	@Override
	public void draw(Graphics g) {
		if (!isObjectOutOfCameraView()) {
			if (getState() == NOBEHURT && (System.nanoTime() / 10000000) % 2 != 1) {			} else {
				g.drawImage(ghostImage, (int) (getX() - getGameWorld().getCamera().getX() - 10),
						(int) (getY() - getGameWorld().getCamera().getY() - 10), null);

			}
		}
	}

}
