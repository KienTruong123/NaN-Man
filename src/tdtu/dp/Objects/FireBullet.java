package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class FireBullet extends Bullet {

	private Image fireBulletLeftImage;
	private Image fireBulletRightImage;

	public FireBullet(double d, double e, GWorld gameWorld) {
		super(d, e, 50, 30, 1.0f, 10, gameWorld);
		fireBulletLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/fire_bullet_left.gif")
				.getImage();
		fireBulletRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/fire_bullet_right.gif")
				.getImage();
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		// TODO Auto-generated method stub
		return getBoundForCollisionWithMap();
	}

	@Override
	public void draw(Graphics g) {
		Rectangle rect = getBoundForCollisionWithEnemy();
		g.setColor(Color.RED);
		if (getDirection() == LEFT_DIR) {
			g.drawImage(fireBulletLeftImage, rect.x - (int) getGameWorld().getCamera().getX(),
					rect.y - (int) getGameWorld().getCamera().getY(), rect.width * 2, rect.height * 2, null);
		} else {
			g.drawImage(fireBulletRightImage, rect.x - (int) getGameWorld().getCamera().getX()-50,
					rect.y - (int) getGameWorld().getCamera().getY(), rect.width * 2, rect.height * 2, null);
		}
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

}
