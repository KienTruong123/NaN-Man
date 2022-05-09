package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.text.Position;

import tdtu.dp.UI.GFrame;

public class Man extends Human {
	public static final int RUNSPEED = 3;
	private Image manLeftImage;
	private Image manRightImage;

	public Man(float x, float y, GWorld gameWorld) {
		super(x, y, 70, 90, 0.1f, 100, gameWorld);
		setTeamType(LEAGUE);
		setTimeForNoBehurt(2000000000);
		manLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/man_go_left.gif").getImage();
		manRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/man_go_right.gif").getImage();
	}

	@Override
	public void update() {
		super.update();
		if (getIsLanding()) {
			setIsLanding(false);
		}
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		// TODO Auto-generated method stub
		Rectangle rect = getBoundForCollisionWithMap();

		if (getIsDicking()) {
			rect.x = (int) getX() - 22;
			rect.y = (int) getY() - 20;
			rect.width = 44;
			rect.height = 65;
		} else {
			rect.x = (int) getX() - 22;
			rect.y = (int) getY() - 40;
			rect.width = 44;
			rect.height = 80;
		}

		return rect;
	}

	@Override
	public void draw(Graphics g) {
		Rectangle rect = getBoundForCollisionWithMap();
		g.setColor(Color.RED);
		if (getDirection() == RIGHT_DIR) {
			g.drawImage(manRightImage,rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY() -5, rect.width, rect.height+10, null);
		}else {
			g.drawImage(manLeftImage, rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY() -5, rect.width, rect.height+10, null);
		}
	}

	@Override
	public void run() {
		if (getDirection() == LEFT_DIR)
			setSpeedX(-3);
		else
			setSpeedX(3);
	}

	@Override
	public void jump() {

		if (!getIsJumping()) {
			setIsJumping(true);
			setSpeedY(-5.0f);
		} else {
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
	public void dick() {
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
		FireBullet fireBullet = new FireBullet(getX(), getY(), getGameWorld());
		fireBullet.setDirection(getDirection());
		if (getDirection() == LEFT_DIR) {
			fireBullet.setSpeedX(-10);
			fireBullet.setX(fireBullet.getX() - 40);
			if (getSpeedX() != 0 && getSpeedY() == 0) {
				fireBullet.setX(fireBullet.getX() - 10);
				fireBullet.setY(fireBullet.getY() - 5);
			}
		} else {
			fireBullet.setSpeedX(10);
			fireBullet.setX(fireBullet.getX() + 40);
			if (getSpeedX() != 0 && getSpeedY() == 0) {
				fireBullet.setX(fireBullet.getX() + 10);
				fireBullet.setY(fireBullet.getY() - 5);
			}
		}

		fireBullet.setTeamType(getTeamType());
		getGameWorld().getParticleManager().addObject(fireBullet);
	}

	@Override
	public void hurtingCallback() {
	}

}
