package tdtu.dp.effect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {
	private static DataLoader instance = null;

	private String mapFile = System.getProperty("user.dir") + "/src/data/map/map.txt";

	private int[][] map;

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

	public int[][] getMap() {
		return instance.map;
	}

	public void loadMap() throws IOException {

		FileReader fr = new FileReader(mapFile);
		BufferedReader br = new BufferedReader(fr);

		String line = null;

		line = br.readLine();
		int rows = Integer.parseInt(line);
		line = br.readLine();
		int cols = Integer.parseInt(line);

		instance.map = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			line = br.readLine();
			String[] str = line.split(" ");
			for (int j = 0; j < cols; j++)
				instance.map[i][j] = Integer.parseInt(str[j]);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				System.out.print(" " + instance.map[i][j]);
			System.out.println();
		}

		br.close();

	}

}
