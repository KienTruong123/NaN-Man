package tdtu.dp.state;

public interface State {

	public static final byte ALIVE = 0;
	public static final byte BEHURT = 1;
	public static final byte NOBEHURT = 2;
	public static final byte DEATH = 3;

	public void setState(int state);
	public int getState();
}
