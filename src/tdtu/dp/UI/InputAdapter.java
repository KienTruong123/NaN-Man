package tdtu.dp.UI;

import java.awt.event.KeyEvent;

import tdtu.dp.Objects.Man;

public class InputAdapter {

	GamePanel gamePanel;

	public InputAdapter(GamePanel g) {
		// TODO Auto-generated constructor stub
		gamePanel = g;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			gamePanel.man.setDirection(Man.DIR_LEFT);
			gamePanel.man.setSpeedX(-5);
		} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			gamePanel.man.setDirection(Man.DIR_RIGHT);
			gamePanel.man.setSpeedX(5);
		} else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {

		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {

		} else if (key == KeyEvent.VK_SPACE) {
			gamePanel.man.setSpeedY(-5);
			gamePanel.man.setY(gamePanel.man.getY()-10);
		}
	}
	
	public void keyRelease(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			gamePanel.man.setSpeedX(0);
		} else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			gamePanel.man.setSpeedX(0);
		} else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {

		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {

		} else if (key == KeyEvent.VK_SPACE) {

		}
	}

}
