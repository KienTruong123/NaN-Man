package tdtu.dp.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Man extends Human {
	public static final float RUNSPEED = 2.8f;

	private Image manLeftImage;
	private Image manRightImage;

	public Man(float x, float y, GWorld gameWorld) {
		super(x, y, 25, 55, 0.1f, 100, gameWorld);
		setTeamType(LEAGUE);
		setTimeForNoBehurt(2000000000);
		manLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/man_go_left.gif").getImage();
		manRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/man_go_right.gif").getImage();
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		// TODO Auto-generated method stub
		Rectangle rect = getBoundForCollisionWithMap();

//		if (getIsDicking()) {
//			rect.x = (int) getX() - 22;
//			rect.y = (int) getY() - 20;
//			rect.width = 44;
//			rect.height = 65;
//		} else {
//			rect.x = (int) getX() - 22;
//			rect.y = (int) getY() - 40;
//			rect.width = 44;
//			rect.height = 80;
//		}

		return rect;
	}

	@Override
	public void draw(Graphics g) {
		Rectangle rect = getBoundForCollisionWithMap();
		if (getDirection() == RIGHT_DIR) {
			g.drawImage(manRightImage, rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY(), rect.width, rect.height , null);
		} else {
			g.drawImage(manLeftImage, rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY(), rect.width, rect.height, null);
		}
//		drawBoundForCollisionWithMap(g);
	}

	@Override
	public void run() {
		if (getDirection() == LEFT_DIR)
			setSpeedX(-RUNSPEED);
		else
			setSpeedX(RUNSPEED);
	}


	@Override
	public void jump() {

		if (!getIsJumping()) {
			setIsJumping(true);
			setSpeedY(-5.0f);
		} else if (getMaxNumOfJump()>0) {
			setMaxNumOfJump(getMaxNumOfJump()-1);
			Rectangle rectRightWall = getBoundForCollisionWithMap();
			rectRightWall.x += 1;
			Rectangle rectLeftWall = getBoundForCollisionWithMap();
			rectLeftWall.x -= 1;

			if (getGameWorld().getMap().getRightWallCollision(rectRightWall) != null && getSpeedX() > 0) {
				setSpeedY(-5.0f);
			} else if (getGameWorld().getMap().getLeftWallCollision(rectLeftWall) != null && getSpeedX() < 0) {
				setSpeedY(-5.0f);
			}

		}
	}

	@Override
	public void duck() {
		if (!getIsJumping())
			setIsDicking(true);
	}

	@Override
	public void standUp() {
		setIsDicking(false);
	}

	@Override
	public void stop() {
		setSpeedX(0);
	}

	@Override
	public void attack() {
		FireBullet fireBullet = new FireBullet(getX(), getY()-getHeight()/3, getGameWorld());
		fireBullet.setDirection(getDirection());
		if (getDirection() == LEFT_DIR) {
			fireBullet.setSpeedX(-10);
			fireBullet.setX(fireBullet.getX() - getWidth()*2);
			if (getSpeedX() != 0 && getSpeedY() == 0) {
				fireBullet.setX(fireBullet.getX() - getSpeedX());
			}
		} else {
			fireBullet.setSpeedX(10);
			fireBullet.setX(fireBullet.getX() + getWidth()*2);
			if (getSpeedX() != 0 && getSpeedY() == 0) {
				fireBullet.setX(fireBullet.getX() + getSpeedX());
			}
		}
		
		fireBullet.setTeamType(getTeamType());
		getGameWorld().getParticleManager().addObject(fireBullet);
	}

	@Override
	public void hurtingCallback() {
	}

}
