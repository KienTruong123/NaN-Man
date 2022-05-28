package tdtu.dp.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import tdtu.dp.Objects.GWorld;
import test.FPSCounter;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 747127086860201323L;
	private Thread thread;
	private boolean isRunning;
	private InputAdapter inputAdapter;
	private GWorld gameWorld;


	public GamePanel() {
		// TODO Auto-generated constructor stub
		setGameWorld(new GWorld());
		inputAdapter = new InputAdapter(getGameWorld());
	}

	public void startGame() {
		if (thread == null) {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public void update() {
		gameWorld.update();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.lightGray);
		g.fillRect(0, 0, GFrame.SCREEN_WIDTH, GFrame.SCREEN_HEIGHT);
		gameWorld.render(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long FPS = 60;
		long period = 1000000000 / FPS;
		long startTime;
		long sleepTime;
		while (isRunning) {
			startTime = System.nanoTime();
			// start
			update();
			// end
			long deltaTime = System.nanoTime() - startTime;
			sleepTime = period - deltaTime;
			
			try {
				if (sleepTime > 0) {
					Thread.sleep(sleepTime / 1000000);
				} else {
					Thread.sleep(period / 2000000);
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		inputAdapter.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputAdapter.keyRelease(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}



	public GWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

}
