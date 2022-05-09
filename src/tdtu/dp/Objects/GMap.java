package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import tdtu.dp.effect.DataLoader;

public class GMap extends GObject {
	public int[][] map;
	private int brickSize;
	private Image brickImage;

	public GMap(float x, float y, GWorld gameWorld) {
		super(x, y, gameWorld);
		this.brickSize = 30;
		map = DataLoader.getInstance().getMap();
		brickImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/map/brick.jpeg").getImage();
	}

	public int getBrickSize() {
		return brickSize;
	}

	public int getBrickRows() {
		if (map != null)
			return map.length;
		return 0;
	}

	public int getBrickCols() {
		if (map != null)
			return map[0].length;
		return 0;
	}

	public boolean isBrick(int x, int y) {
		return map[y][x] == 1;
	}

	public void draw(Graphics g) {
		Camera camera = getGameWorld().getCamera();
		g.setColor(Color.GRAY);
		for (int y = 0; y < getBrickRows(); y++)
			for (int x = 0; x < getBrickCols(); x++)
				if (isBrick(x, y))
					g.drawImage(brickImage,(int) getX() + x * getBrickSize() - (int) camera.getX(),
							(int) getY() + y * getBrickSize() - (int) camera.getY(), getBrickSize(), getBrickSize(),null);
//		g.fillRect((int) getX() + x * getBrickSize() - (int) camera.getX(),
//		(int) getY() + y * getBrickSize() - (int) camera.getY(), getBrickSize(), getBrickSize());

	}

	public Rectangle getLandCollision(Rectangle rect) {
		int minIndexX = rect.x / getBrickSize() - 2;
		int maxIndexX = (rect.x + rect.width) / getBrickSize() + 2;

		int indexY = (rect.y + rect.height) / getBrickSize();

		if (minIndexX < 0)
			minIndexX = 0;
		if (maxIndexX > getBrickCols())
			maxIndexX = getBrickCols();

		for (int y = indexY; y < map.length; y++) {
			for (int x = minIndexX; x < maxIndexX; x++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getBrickSize(), (int) getY() + y * getBrickSize(),
							getBrickSize(), getBrickSize());
					if (rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	public Rectangle getRightWallCollision(Rectangle rect) {
		int minIndexX = (rect.x + rect.width) / getBrickSize();
		int maxIndexX = minIndexX + 3;
		if (maxIndexX > getBrickCols())
			maxIndexX = getBrickCols();

		int minIndexY = rect.y / getBrickSize() - 2;
		int maxIndexY = (rect.y + rect.height) / getBrickSize() + 2;
		if (minIndexY < 0)
			minIndexY = 0;
		if (maxIndexY > map.length)
			maxIndexY = map.length;

		for (int x = minIndexX; x < maxIndexX; x++) {
			for (int y = minIndexY; y < maxIndexY; y++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getBrickSize(), (int) getY() + y * getBrickSize(),
							getBrickSize(), getBrickSize());
					if (r.y < rect.y + rect.height - 1 && rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	public Rectangle getLeftWallCollision(Rectangle rect) {
		int minIndexX = (rect.x + rect.width) / getBrickSize();
		int maxIndexX = minIndexX - 3;
		if (maxIndexX < 0)
			maxIndexX = 0;

		int minIndexY = rect.y / getBrickSize() - 2;
		int maxIndexY = (rect.y + rect.height) / getBrickSize() + 2;
		if (minIndexY < 0)
			minIndexY = 0;
		if (maxIndexY > map.length)
			maxIndexY = map.length;

		for (int x = minIndexX; x >= maxIndexX; x--) {
			for (int y = minIndexY; y < maxIndexY; y++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getBrickSize(), (int) getY() + y * getBrickSize(),
							getBrickSize(), getBrickSize());
					if (r.y < rect.y + rect.height - 1 && rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	public Rectangle getTopCollision(Rectangle rect) {
		int posX1 = rect.x / getBrickSize();
		posX1 -= 2;
		int posX2 = (rect.x + rect.width) / getBrickSize();
		posX2 += 2;
		int posY = rect.y / getBrickSize();

		if (posX1 < 0)
			posX1 = 0;
		if (posX2 >= map[0].length)
			posX2 = map[0].length - 1;

		for (int y = posY; y >= 0; y--) {
			for (int x = posX1; x <= posX2; x++) {
				if (map[y][x] == 1) {
					Rectangle r = new Rectangle((int) getX() + x * getBrickSize(), (int) getY() + y * getBrickSize(),
							getBrickSize(), getBrickSize());
					if (rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	@Override
	void update() {
		// TODO Auto-generated method stub

	}

}
