package tdtu.dp.UI;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import tdtu.dp.data.DataLoader;

public class GFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 700;

	GamePanel gamePanel = null;

	public GFrame() throws HeadlessException {
		Toolkit toolkit = this.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		this.setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH,
				SCREEN_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
            DataLoader.getInstance().loadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		gamePanel = new GamePanel();
		add(gamePanel);
		this.addKeyListener(gamePanel);
		
	}
	
	public void startGame() {
		gamePanel.startGame();
	}

}
