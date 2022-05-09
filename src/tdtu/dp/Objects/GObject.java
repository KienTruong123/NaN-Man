package tdtu.dp.Objects;

public abstract class GObject {
	private double x;
	private double y;

	private GWorld gameWorld;

	public GObject(double x, double y, GWorld gameWorld) {
		super();
		this.x = x;
		this.y = y;
		this.gameWorld = gameWorld;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public GWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	
	abstract void update();

}
