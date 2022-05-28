package tdtu.dp.Objects;

import java.awt.Rectangle;

public abstract class Human extends Particle {
	private static byte MAXNUMOFJUMP = 2;

	private boolean isJumping;
	private boolean isDicking;
	private byte maxNumOfJump;
	private int power;
	
	private long startTimeNapPower;

	public abstract void run();

	public abstract void jump();

	public abstract void duck();

	public abstract void standUp();

	public abstract void stop();

	public Human(float x, float y, float width, float height, float mass, int blood, int power, GWorld gameWorld) {
		super(x, y, width, height, mass, blood, gameWorld);
		setState(ALIVE);
		setMaxNumOfJump(MAXNUMOFJUMP);
		setPower(power);
		setStartTimeNapPower(System.nanoTime());
	}

	public byte getMaxNumOfJump() {
		return maxNumOfJump;
	}

	public void setMaxNumOfJump(byte maxNumOfJump) {
		this.maxNumOfJump = maxNumOfJump;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean getIsJumping() {
		return isJumping;
	}

	public void setIsJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public boolean getIsDicking() {
		return isDicking;
	}

	public void setIsDicking(boolean isDicking) {
		this.isDicking = isDicking;
	}

	public boolean handleRightCollisions() {
		if (getDirection() == RIGHT_DIR
				&& getGameWorld().getMap().getRightWallCollision(getBoundForCollisionWithMap()) != null) {
			Rectangle rectRightWall = getGameWorld().getMap().getRightWallCollision(getBoundForCollisionWithMap());
			setX(rectRightWall.x - getWidth() / 2);
			return true;
		}
		return false;
	}

	public boolean handleLeftCollisions() {
		if (getDirection() == LEFT_DIR
				&& getGameWorld().getMap().getLeftWallCollision(getBoundForCollisionWithMap()) != null) {
			Rectangle rectLeftWall = getGameWorld().getMap().getLeftWallCollision(getBoundForCollisionWithMap());
			setX(rectLeftWall.x + rectLeftWall.width + getWidth() / 2);
			return true;
		}
		return false;
	}

	public boolean handleLandCollisions() {
		Rectangle rectLand = getGameWorld().getMap().getLandCollision(getBoundForCollisionWithMapFuture());
		if (rectLand != null) {
			setIsJumping(false);
			setMaxNumOfJump((byte) (MAXNUMOFJUMP + (Math.random() * 3)));
			setSpeedY(0);
			setY(rectLand.y - getHeight() / 2);
			return true;
		}
		return false;
	}

	public boolean handleTopCollisions() {
		Rectangle rectTop = getGameWorld().getMap().getTopCollision(getBoundForCollisionWithMapFuture());
		if (rectTop != null) {
			setSpeedY(0);
			setY(rectTop.y + getGameWorld().getMap().getUnitSize() + getHeight() / 2);
			return true;
		}
		return false;
	}

	public Rectangle getBoundForCollisionWithMapFuture() {
		Rectangle boundForCollisionWithMapFuture = super.getBoundForCollisionWithMap();
		boundForCollisionWithMapFuture.y += (getSpeedY() != 0 ? getSpeedY() : 2);
		return boundForCollisionWithMapFuture;
	}

	public void handleAction() {
		setX(getX() + getSpeedX());
		handleRightCollisions();
		handleLeftCollisions();

		// jumping
		if (!(handleLandCollisions() || handleTopCollisions())) {
			setIsJumping(true);
			setSpeedY(getSpeedY() + getMass());
			setY(getY() + getSpeedY());
		}
	}

	@Override
	public void update() {
		super.update();
		if (getState() == ALIVE || getState() == NOBEHURT) {
			handleAction();
		}

		if (getPower() < 100 && System.nanoTime() -getStartTimeNapPower()>  1000*1000000 ) {
			setStartTimeNapPower(System.nanoTime());
			setPower(getPower() + 5);
		}

	}

	public long getStartTimeNapPower() {
		return startTimeNapPower;
	}

	public void setStartTimeNapPower(long startTimeNapPower) {
		this.startTimeNapPower = startTimeNapPower;
	}
}
