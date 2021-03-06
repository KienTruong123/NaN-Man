package tdtu.dp.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {
	private static DataLoader instance = null;
	private String mapFile = System.getProperty("user.dir") + "/src/data/map/map.txt";

	private byte[][] map;

	private DataLoader() {
	}

	public static DataLoader getInstance() {
		if (instance == null)
			instance = new DataLoader();
		return instance;
	}

	public void loadData() throws IOException {
		loadMap();
	}

	public byte[][] getMap() {
		return instance.map;
	}

	public void loadMap() throws IOException {
		FileReader fr = new FileReader(mapFile);
		BufferedReader br = new BufferedReader(fr);

		String line = null;

		line = br.readLine();
		short rows = Short.parseShort(line);
		line = br.readLine();
		short cols = Short.parseShort(line);

		instance.map = new byte[rows][cols];

		for (int i = 0; i < rows; i++) {
			line = br.readLine();
			String[] str = line.split(" ");
			for (int j = 0; j < cols; j++)
				instance.map[i][j] = Byte.parseByte(str[j]);
		}
		br.close();
	}
}
