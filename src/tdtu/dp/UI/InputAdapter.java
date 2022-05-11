package tdtu.dp.UI;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import tdtu.dp.Objects.GWorld;
import tdtu.dp.Objects.Particle;

public class InputAdapter {

	private final Set<Integer> pressed = new HashSet<Integer>();
	private GWorld gameWorld;

	public GWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	public InputAdapter(GWorld g) {
		// TODO Auto-generated constructor stub
		gameWorld = g;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		pressed.add(key);
		if (pressed.contains(KeyEvent.VK_W)) {
			if (pressed.contains(KeyEvent.VK_META))
				System.exit(1);
		}
		switch (key) {
		case KeyEvent.VK_LEFT:
			getGameWorld().getMan().setDirection(Particle.LEFT_DIR);
			getGameWorld().getMan().run();
			break;
		case KeyEvent.VK_RIGHT:
			getGameWorld().getMan().setDirection(Particle.RIGHT_DIR);
			getGameWorld().getMan().run();
			break;
		case KeyEvent.VK_UP:
			getGameWorld().getMan().jump();
			break;
		case KeyEvent.VK_DOWN:
			getGameWorld().getMan().duck();
			break;
		case KeyEvent.VK_A:
			getGameWorld().getMan().attack();
			break;

		default:
		}

	}

	public void keyRelease(KeyEvent e) {
		int key = e.getKeyCode();
		pressed.remove(key);
		switch (key) {
		case KeyEvent.VK_LEFT:
			if (getGameWorld().getMan().getSpeedX() < 0)
				getGameWorld().getMan().stop();
			break;
		case KeyEvent.VK_RIGHT:
			if (getGameWorld().getMan().getSpeedX() > 0)
				getGameWorld().getMan().stop();
			break;
		case KeyEvent.VK_UP:

			break;
		case KeyEvent.VK_DOWN:
			getGameWorld().getMan().standUp();
			break;
		case KeyEvent.VK_A:
			getGameWorld().getMan().attack();
			break;
		default:
		}

	}

}
