package tdtu.dp.UI;

import java.awt.event.KeyEvent;

import tdtu.dp.Objects.GWorld;
import tdtu.dp.Objects.Particle;

public class InputAdapter {

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
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			getGameWorld().getMan().setDirection(Particle.LEFT_DIR);
			getGameWorld().getMan().run();
		} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			getGameWorld().getMan().setDirection(Particle.RIGHT_DIR);
			getGameWorld().getMan().run();
		} else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {

		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {

		} else if (key == KeyEvent.VK_SPACE) {
			getGameWorld().getMan().jump();
		}else if (key == KeyEvent.VK_F) {
			getGameWorld().getMan().attack();
		}
	}

	public void keyRelease(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			if (getGameWorld().getMan().getSpeedX() < 0)
				getGameWorld().getMan().stop();
			;
		} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			if (getGameWorld().getMan().getSpeedX() > 0)
				getGameWorld().getMan().stop();
		} else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {

		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {

		} else if (key == KeyEvent.VK_SPACE) {

		}
	}

}
