package tdtu.dp.Objects;

import java.awt.Color;
import java.awt.Graphics;

import tdtu.dp.effect.DataLoader;

public class Map {
	public int[][] map;
	private int tileSize;
	
	public float x,y;

	public Map(float x, float y) {
		this.x=x;
		this.y=y;
		this.tileSize = 30;
		map = DataLoader.getInstance().getMap();
	}

	public int getTileSize() {
		return tileSize;
	}
	
	
	 public void draw(Graphics g){
	        
//	        Camera camera = getGameWorld().camera;
	        
	        g.setColor(Color.GRAY);
	        for(int i = 0;i< map.length;i++)
	            for(int j = 0;j<map[0].length;j++)
	                if(map[i][j]!=0) g.fillRect((int) + j*tileSize , 
	                          i*tileSize , tileSize, tileSize);
	        
	    }

}
