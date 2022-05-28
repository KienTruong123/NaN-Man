package tdtu.dp.Objects;

import tdtu.dp.behavior.AttackBehavior;
import tdtu.dp.behavior.FireShootingBehavior;
import tdtu.dp.behavior.HalfArcShooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Man extends Human {
	public static final float RUNSPEED = 2.8f;

	private Image manLeftImage;
	private Image manRightImage;
	private Image jupmLeftImage;
	private Image jumpRightImage;

	private AttackBehavior attackBehavior;

	public Man(float x, float y, GWorld gameWorld) {
		super(x, y, 20, 25, 0.1f, 100,100, gameWorld);
		attackBehavior = new FireShootingBehavior();
		setTeamType(LEAGUE);
		setState(ALIVE);
		setTimeForNoBehurt(2000000000);
		setDamage(2);
		manLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/goLeft.gif").getImage();
		manRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/goRight.gif").getImage();
		jupmLeftImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/jumpLeft.png").getImage();
		jumpRightImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/object/jumpRight.png").getImage();
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
		} else if (getMaxNumOfJump() > 0) {
			setMaxNumOfJump((byte) (getMaxNumOfJump() - 1));
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
		if (getPower() > 10) {
			setPower(getPower()-3);
			attackBehavior.attack(getX(),getY(),getSpeedX(),getSpeedY(),getDirection(),getTeamType(),getGameWorld());
		}
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void draw(Graphics g) {
		drawMan(g);
		drawBlood(g);
		drawPower(g);
	}

	public void drawMan(Graphics g) {
		Rectangle rect = getBoundForCollisionWithMap();
		if (getDirection() == RIGHT_DIR) {
			if (getIsJumping()) {
				g.drawImage(jumpRightImage, rect.x - (int) getGameWorld().getCamera().getX(),
						rect.y - (int) getGameWorld().getCamera().getY(), (int) (rect.width * 1.2),
						(int) (rect.height * 1.5), null);
			} else {
				g.drawImage(manRightImage, rect.x - (int) getGameWorld().getCamera().getX(),
						rect.y - (int) getGameWorld().getCamera().getY(), rect.width, rect.height, null);
			}
		} else {
			if (getIsJumping()) {
				g.drawImage(jupmLeftImage, rect.x - (int) getGameWorld().getCamera().getX(),
						rect.y - (int) getGameWorld().getCamera().getY(), (int) (rect.width * 1.2),
						(int) (rect.height * 1.5), null);
			} else {
				g.drawImage(manLeftImage, rect.x - (int) getGameWorld().getCamera().getX(),
						rect.y - (int) getGameWorld().getCamera().getY(), rect.width, rect.height, null);
			}
		}
//		drawBoundForCollisionWithMap(g);
	}

	public void drawBlood(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(19, 59, 102, 22);
		g.setColor(Color.red);
		g.fillRect(20, 60, getBlood(), 20);
	}

	private void drawPower(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(19, 29, 102, 22);
		g.setColor(Color.BLUE);
		g.fillRect(20, 30, getPower(), 20);
	}
}
