package tdtu.dp.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import tdtu.dp.Objects.Man;
import tdtu.dp.Objects.Map;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	private Thread thread;
	private boolean isRunning;
	private InputAdapter inputAdapter;

	Man man = new Man(300, 400, 100, 100, 0.1f);
	Map map = new Map(0, 0); 
	public GamePanel() {
		// TODO Auto-generated constructor stub
		inputAdapter = new InputAdapter(this);
	}

	public void startGame() {
		if (thread == null) {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public void update() {
		man.update();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
//		man.paint(g);
		map.draw(g);	}

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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		inputAdapter.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputAdapter.keyRelease(e);
	}

}
