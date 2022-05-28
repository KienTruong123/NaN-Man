package tdtu.dp.Objects;

public class Camera extends GObject {
	private float widthView;
	private float heightView;
	private boolean isLocked = false;

	public static int MAX_HEIGHT=250;
	public static int MAX_WIDTH=400;
	
	public Camera(float x, float y, float widthView, float heightView, GWorld gameWorld) {
		super(x, y, gameWorld);
		this.widthView = widthView;
		this.heightView = heightView;
	}

	public void lock() {
		isLocked = true;
	}

	public void unlock() {
		isLocked = false;
	}

	@Override
	public void update() {
		if (!isLocked) {
			Man player = getGameWorld().getMan();
			if (player.getX() - getX() > MAX_WIDTH)
				setX(player.getX() - MAX_WIDTH);
			if (player.getX() - getX() < 200)
				setX(player.getX() - 200);

			if (player.getY() - getY() > MAX_WIDTH)
				setY(player.getY() - MAX_WIDTH); 
			else if (player.getY() - getY() < MAX_HEIGHT)
				setY(player.getY() - MAX_HEIGHT);
		}

	}

	public double getWidthView() {
		return widthView;
	}

	public void setWidthView(float widthView) {
		this.widthView = widthView;
	}

	public double getHeightView() {
		return heightView;
	}

	public void setHeightView(float heightView) {
		this.heightView = heightView;
	}

}
