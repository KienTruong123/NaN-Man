package tdtu.dp.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import tdtu.dp.data.DataLoader;

public class GMap extends GObject {
	public byte[][] map;
	private short unitSize;
	private Image brickImage;

	public GMap(float x, float y, GWorld gameWorld) {
		super(x, y, gameWorld);
		this.unitSize = 30;
		map = DataLoader.getInstance().getMap();
		brickImage = new ImageIcon(System.getProperty("user.dir") + "/src/data/map/brick.jpeg").getImage();
	}

	public int getUnitSize() {
		return unitSize;
	}

	public int getRows() {
		if (map != null)
			return map.length;
		return 0;
	}

	public int getCols() {
		if (map != null)
			return map[0].length;
		return 0;
	}

	public boolean isBrick(int x, int y) {
		return map[y][x] == 1;
	}

	public Rectangle getLandCollision(Rectangle rect) {
		int minIndexX = rect.x / getUnitSize() - 2;
		int maxIndexX = (rect.x + rect.width) / getUnitSize() + 2;
		int indexY = (rect.y + rect.height) / getUnitSize();

		if (minIndexX < 0)
			minIndexX = 0;
		if (maxIndexX > getCols())
			maxIndexX = getCols();

		for (int y = indexY; y < getRows(); y++) {
			for (int x = minIndexX; x < maxIndexX; x++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getUnitSize(), (int) getY() + y * getUnitSize(),
							getUnitSize(), getUnitSize());
					if (rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	public Rectangle getRightWallCollision(Rectangle rect) {
		int minIndexX = (rect.x + rect.width) / getUnitSize();
		int maxIndexX = minIndexX + 3;
		if (maxIndexX > getCols())
			maxIndexX = getCols();

		int minIndexY = rect.y / getUnitSize() - 2;
		int maxIndexY = (rect.y + rect.height) / getUnitSize() + 2;
		if (minIndexY < 0)
			minIndexY = 0;
		if (maxIndexY > getRows())
			maxIndexY = getRows();

		for (int x = minIndexX; x < maxIndexX; x++) {
			for (int y = minIndexY; y < maxIndexY; y++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getUnitSize(), (int) getY() + y * getUnitSize(),
							getUnitSize(), getUnitSize());
					if (r.y < rect.y + rect.height - 1 && rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	public Rectangle getLeftWallCollision(Rectangle rect) {
		int minIndexX = (rect.x + rect.width) / getUnitSize();
		int maxIndexX = minIndexX - 3;
		if (maxIndexX < 0)
			maxIndexX = 0;

		int minIndexY = rect.y / getUnitSize() - 2;
		int maxIndexY = (rect.y + rect.height) / getUnitSize() + 2;
		if (minIndexY < 0)
			minIndexY = 0;
		if (maxIndexY > getRows())
			maxIndexY = getRows();

		for (int x = minIndexX; x >= maxIndexX; x--) {
			for (int y = minIndexY; y < maxIndexY; y++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getUnitSize(), (int) getY() + y * getUnitSize(),
							getUnitSize(), getUnitSize());
					if (r.y < rect.y + rect.height - 1 && rect.intersects(r))
						return r;
				}
			}
		}
		return null;
	}

	public Rectangle getTopCollision(Rectangle rect) {
		int posX1 = rect.x / getUnitSize();
		posX1 -= 2;
		int posX2 = (rect.x + rect.width) / getUnitSize();
		posX2 += 2;
		int posY = rect.y / getUnitSize();

		if (posX1 < 0)
			posX1 = 0;
		if (posX2 >= getCols())
			posX2 = getCols() - 1;

		for (int y = posY; y >= 0; y--) {
			for (int x = posX1; x <= posX2; x++) {
				if (isBrick(x, y)) {
					Rectangle r = new Rectangle((int) getX() + x * getUnitSize(), (int) getY() + y * getUnitSize(),
							getUnitSize(), getUnitSize());
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

	public void draw(Graphics g) {
		Camera camera = getGameWorld().getCamera();
		Man man = getGameWorld().getMan();
		int lscreen = (int) (camera.getX() - getX()) / getUnitSize();
		int rscreen = lscreen + (int) (camera.getWidthView() / getUnitSize() + 1);
		int tscreen = (int) (camera.getY() - getY()) / getUnitSize();
		int bscreen = tscreen + (int) (camera.getHeightView() / getUnitSize() + 1);

		if (lscreen < 0)
			lscreen = 0;
		if (rscreen > getCols())
			rscreen = getCols();
		if (tscreen < 0)
			tscreen = 0;
		if (bscreen > getRows())
			bscreen = getRows();

		for (int y = tscreen; y < bscreen; y++)
			for (int x = lscreen; x < rscreen; x++)
				if (isBrick(x, y))
					g.drawImage(brickImage, (int) getX() + x * getUnitSize() - (int) camera.getX(),
							(int) getY() + y * getUnitSize() - (int) camera.getY(), getUnitSize(), getUnitSize(), null);
	}

}
