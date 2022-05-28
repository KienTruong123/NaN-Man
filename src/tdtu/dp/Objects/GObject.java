package tdtu.dp.Objects;

public abstract class GObject {
	private float x;
	private float y;

	private GWorld gameWorld;

	public GObject(float x, float y, GWorld gameWorld) {
		super();
		this.x = x;
		this.y = y;
		this.gameWorld = gameWorld;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
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
