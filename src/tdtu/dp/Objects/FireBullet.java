package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class FireBullet extends Bullet implements Cloneable{

	private Image fireBulletLeftImage;
	private Image fireBulletRightImage;

	public FireBullet(float d, float e, GWorld gameWorld) {
		super(d, e, 30, 20, 1.0f, 10, gameWorld);
		fireBulletLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/fire_bullet_left.gif")
				.getImage();
		fireBulletRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/fire_bullet_right.gif")
				.getImage();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		// TODO Auto-generated method stub
		return getBoundForCollisionWithMap();
	}

	@Override
	public void draw(Graphics g) {
		Rectangle rect = getBoundForCollisionWithEnemy();
		if (getDirection() == LEFT_DIR) {
			g.drawImage(fireBulletLeftImage, rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY(), rect.width, rect.height, null);
		} else {
			g.drawImage(fireBulletRightImage, rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY(), rect.width, rect.height, null);
		}
//		drawBoundForCollisionWithEnemy(g);

	}
}
