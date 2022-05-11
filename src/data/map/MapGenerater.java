package data.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapGenerater {
// link  https://www.dcode.fr/maze-generator
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mazeString = "0001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n"
				+ "0000000001000000001000000000001001000000000001000000001000000000000000001001000000001000000000001001000000001000001001000000001000000001000001000000001\n"
				+ "1001111111001111001001111001111001001001111111001001001001001001001111001001111001111111001001001001001111111001111001111001111001111111111001111111001\n"
				+ "1000001000000001001001001000000000001000001000001001000001001001001000000001000000000000001001000001000000001001000001001000001001000000001001000000001\n"
				+ "1111001001111111111111001001111001001111111111111111111001001111001111001111111111111111001001001111111111001001001111001001111001111001001001111001001\n"
				+ "1000000001001000000000000001000001001000001001001001001001000001001000000001000001001001001001000000000000000000000001000000000001000001000000000001001\n"
				+ "1001111001001001111111111111001001111001111001001001001001111111111111001001001111001001111111001111111001001001001111111001111111111111111111001111001\n"
				+ "1000001001001000000000001000001001000000001000001001000001000000001001001000000000000001000001000000001001001001001000000000001000001000000000001000001\n"
				+ "1001111111001111111001001111111111111001001001001001111111001111111001001111001111001001001111111001111111001111111111001001111001111001111111111111001\n"
				+ "1000000000001000001001000000000001001001001001000000000001000000001001001000000001001000000000000001000001000000000000001001000000001000000001001001001\n"
				+ "1111111001001111001001001001001111001111001111111001001111001001111001001111001111111111111111001111001111111111001001111111111111001001111111001001001\n"
				+ "1000000001001000000001001001000000000000000001001001000001001001000001000001000000001001001001001000000000000000001000000000000000000001001001000001001\n"
				+ "1001001111111111001001111111111001111111111111001111111001001001111001001001111001111001001001001111111111111111001111001111111111111001001001001111001\n"
				+ "1001000001001000001000001000001001000000000001000000001001001000000000001000001001001001000001000001000000001001001001001000000000000001000000001000001\n"
				+ "1001001111001111001111111111001111111001111001111111001001111001111111001001111111001001001111111111111001111001001001001001111111001001111111001001001\n"
				+ "1001000000001001000001000000000000000000001001000000001000001001000000001000001001000000001000000000001000001001000001001000001000001001001001000001001\n"
				+ "1001001111111001001111111111001111111111001001001111001111001111111111111111111001001001111111111001001111001001001111001111111111111001001001111111111\n"
				+ "1001000000000000000000001000000000000001001000000001000000000000001001001001001000001000000000001001000000001000001001000001001000000001001001000000001\n"
				+ "1001111111111001001001001001001111111111111001111001001111001001111001001001001111111001111111001111111111001111111001111111001111001001001001001001111\n"
				+ "1001001000000001001001000001000001000001000001001001001001001000001001000001000001000000001000000001000000000000000000000001001000001000001001001001001\n"
				+ "1001001111111001111111001001111111001111001111001111001001111001111001001111001001001111111001001111111001001001111111001111001111001111001001111001001\n"
				+ "1000001000000001001001001001001000000001000001001000001000001000001000001000001000001000001001000001001001001000000001000000000001001000000000000001001\n"
				+ "1111111111111001001001111111001111001111001001001111111001111111001001111111111001111111001111001111001111001001001111001111111111111001111111111111001\n"
				+ "1000000001000000000000000001000001000000001000001001001000000000000001001000001000000000001000000001000000001001001001000000001000001000000001000000001\n"
				+ "1001111111001111001111001111111001111111111001001001001001111111001111001111001001001111111001111111111111111111001001111001001001001111001001111001001\n"
				+ "1000001000001000000001000000001000000000001001000000001000000001001001000001001001001001001001001001000000001000001000001001000001000000001000001001001\n"
				+ "1001111111001111111001111111111111111111001111111001111001111111111001001001001001111001001001001001111001111111111111001111001111001111001111111111001\n"
				+ "1001001000000001001000000000001000000000001000001000001000000000001000001001000001001001000000000000000000000000000000000000001001000001000000001000001\n"
				+ "1001001111111001001111111001111001111001001111001001111111111001111001111001001001001001001111111001001111001111111111001111001001111111001111111111001\n"
				+ "1000000001000000001001000000001000001001000000001001000000001000000001000001001001001000001000001001001001001000000000001000000001000001000000001001001\n"
				+ "1001111111111111111001001111001111111111001111001111111111001001111001111111111001001111111001001111001001001111111111001111111001001001001111001001001\n"
				+ "1000000000000000000000001000000000001000001000001000000000000000001001000000001000001001000001001000000001000000001001000001000001001001001000001000001\n"
				+ "1111001111111111111001111001001001111001001111001111111001001001111111111111001111001001001001111111001111111111001001111111111111111001001111001111001\n"
				+ "1001000000001000000001000001001000000001000001001001000001001001000000001001000000001001001001000000000000000001000001000000000000001000001001001000001\n"
				+ "1001111111111001111001111001111111111111001111001001111001111111001111001001001111001001001001111111001111111111111001111001111111111001111001001111001\n"
				+ "1001000001000001001001001000001000001001001000001000000001000001000001001000000001000001001000000000000001001000000001001001000000001001000001001000001\n"
				+ "1001001111111111001111001111001111001001001111111111111111001111001111111001111111111111111111111111001111001001001111001001111001111111111001111001111\n"
				+ "1000000000000000001001001000001000001000001000000000000000000001000000001001000000000000001000001000001001001001000001001000001000000000001001000000001\n"
				+ "1001111111001111001001001111001001001001111001111111001001111111001111111111111111111001111001111001001001001111111001001001111111111001001001111001001\n"
				+ "1000001000001001001000000001001001001001000000000001001000001000000000000001000000001000001000000001001000001000000001000001001000001001000000001001001\n"
				+ "1111111111001001111111001111001001111111111111001111001111111111111001111111111111001001001111001111111111001111001001001001001001111001111001001111001\n"
				+ "1000000000000000001000001000001000001001000001000001001000001000001000000000001001000001001000001001001000001001001000001001001001000001001001001000001\n"
				+ "1001111001001001111001111001001001001001001001111001001001111111001001001001111001001001111111001001001001111001111111001001001001001111001111001111001\n"
				+ "1001000001001001000000000001000001000001001000000001000001000000001001001000001001001001000001000001001001000000000000001000000001001000000000000000001\n"
				+ "1001111111111111111111111001111111001111001001001111111111001111111111111111001001001111001111111111001001001111111001111111111001111111111001111111001\n"
				+ "1000000000001000001001000001000001000000001001001000000000000000001000001000000000001001000000001000000001001001000001000000000000001001001000000001001\n"
				+ "1111111001001001111001001001111001111001111111111111111111111001001001111001001111001001001001111111001111001001001111001111001111111001001001111111001\n"
				+ "1000000001000000000000001000000000001001000001000000000000000001001000001001001001001000001000000001001000000001000001000001001001000000000000001000001\n"
				+ "1111001001001111001111001111001001001001001111111111001001111111111111001001111001001001111111111111001001111111111111111001111001111111111001001001001\n"
				+ "1001001001001000000001000001001001001001000001001000001000000000000001000000000001001000000000000000000000000001000001001001001001001001001001001001001\n"
				+ "1001001111111111001001111111111111001111001111001111111001111111111111111001111111111111001001111001111001111111001111001111001001001001001001111001111\n"
				+ "1000001001000000001000000000001001000000001001000000000000001000001000000001000001000000001000001000001000001000001000000000001001000001001001000000001\n"
				+ "1111001001001001001111111111111001111001111001111111111111001111001111111001001111001111001111001111111111111111001001001001111001001111001111111111001\n"
				+ "1001001001001001000001000000000000001000000000000001000000000000001000000000001000001000001000000001000000001001000001001001000001000000000001001000001\n"
				+ "1001001001001111001111001111111111001111001111001111111111111001001001111111001111111001111111111111111001111001001001111111001001001111001111001111001\n"
				+ "1000001001000001000000000000001001001000001001000001001001001001001001001000000000000001001000001000000000001000001000001001001000001000001000000000001\n"
				+ "1001001001111001111001111001001001001111001001001111001001001111001001001001001001111111001111001001111111001001001111111001111001001111111001111001001\n"
				+ "1001001000001001000001000001000001001001001001000000000000000000000001000001001000000000000001000000000001000001000000000001001001001000000001000001001\n"
				+ "1111111001001001111111001001001111111001001001001111111001111111001111111111111001111111001001001111111111001111001111001111001111001001001111111111111\n"
				+ "1000000001000000001001001001001000000001000001001001001001000001001001000000001000000001001000001000001000000001000001000000000001000001000001000000001\n"
				+ "1001111001111111111001001001001111001111001111111001001001111001001001001001111111111111111001111001001001001001001111001001001111001111001001001111001\n"
				+ "1000001000001000001000001001000001001000000001000001000001000000000000001000001000001000001001000001000001001001000001001001000000001001001000001000001\n"
				+ "1111111111111111001111111111111001001001001111111001111111111111111111111111001111001111001001111111001111001001111001001001111111001001111111111111111\n"
				+ "1000000001000000000001000001001001000001000000000000001001000000000001001000000000001000000000000001001000001001000001001001000000000000000001000000001\n"
				+ "1111111001111111111001111001001111111111111111001111001001001001001111001111001111111001111001111001111111111001111111111111111111001111001111111111001\n"
				+ "1000001001000000001001000000000000001000000001001001001001001001000001000000001000001000001001001000001000000001001000000001000001001001000000000000001\n"
				+ "1001111001111001001001001111111001111001111001001001111001111111111001001001111001111001111001001001001111111111001001111001001001111001001111001111111\n"
				+ "1000000000000001000001000001000000001001000000000001000000001000001000001000001000001001000001000001001000001000000000001000001001000001000001001000001\n"
				+ "1111111111001001111001001111111111001111001111001111111001001111001001111111001111001001111111001001001111001111111001111001111111111001111111001001001\n"
				+ "1000001000001001000000000001000000001000000001000001000001001000000001001000001001000001000001001001001001000000001000001000000000001001000000001001001\n"
				+ "1111001111111001111111111001111001111111111001111111111111001111001001001111111001111001001001111111111001001111001001001001111111111001001111111001111\n"
				+ "1000001001000001000000000001000001001000001000001000001001000001001000001001000000000000001000000001001001000001000001001000000000001000000001000001001\n"
				+ "1111001001001001111001111111001111001111001111111111001001111001001111111001111111001111111001001001001001111111111111111001001001111111001111001001001\n"
				+ "1000001001001000001001000001001000001000001001001000000000000001000000001000001001001001000001001000001000001001000000000001001000001000000001001000001\n"
				+ "1001001001111111001111111001001001001111001001001111001111001111001001001001001001111001111111111111001001111001001001111111111111111111111111111111001\n"
				+ "1001000001000000000001000000000001001000001000001000001000000001001001000001001000000001000001000000000000001001001001000000001000000001001000000001001\n"
				+ "1001001001111001001001001111111001001111001001111111111001111111001111111111111111001111001111111001111001111001111001111001111001001111001001111001001\n"
				+ "1001001000001001001001001000001001001001001001001000000000001000001001000001000000000001000000001001000001000000001000000001001001001000000000001001001\n"
				+ "1001111111001001001111111001001111111001001001001111001001111111001001111001111111001111111001111111001111001111001001111001001111001111001111001111001\n"
				+ "1001001000000001000000001001001001000001000000001000001000000000001000001001000000001000000000001000001000000001001000001001000000000001000001000000001\n"
				+ "1001001111111111001111111001111001001111001111111001111111001001111001111001111001111111001111001001111001001111001001111111111001001111111001111111001\n"
				+ "1000001000000001000000001000001000000001000000000000001000001001001000000000000001000000001000000001001001001000000001000000001001001000001001000000001\n"
				+ "1001001001111111001001111111001111001001111001111111111111001001001111111111001111111001111111001111001111111001111111111001111001001001001111001001111\n"
				+ "1001000001001000001000001000000001001001001001000000000001001001000000000000000000000001000000000000000000001001001000000000001001000001001000001000001\n"
				+ "1001111111001111111111001111111001001111001001001111111001001001001111111001001001111111001001001111111001001001001111001111001001111001111001111111001\n"
				+ "1000001000000001000000000000000000001000000001000001000000001001000000001001001001000000001001000000001001000000000000000001000001000001000000001001001\n"
				+ "1001111001111111001111111111001111001111111111111111001001111111111111111001111111111111001001111111111111111111001001111111111001001111001111001001111\n"
				+ "1001000000001001000001001000000001000000001000000000001001000001000000000001000000000000001000000000000000000001001000000001000001000000001001000000001\n"
				+ "1001001111111001001111001001111111111111001111001001001111001111001111111111111111111111111111001001001001111001111111111001001111111111111001001111001\n"
				+ "1000001000001000001001000001000000001001001001001001000000001000001000001000000000001000001001001001001001001001000001000001000001001000001001001001001\n"
				+ "1001111111001111111001001001111111001001111001111001111001111111001001111111001001001001111001111001111111001001111001001111111111001111001001111001001\n"
				+ "1000000000001001001000001000001001000000000000000000001001000001000000001000001001001001000000000001000000000001000001000001000001000000000001000000001\n"
				+ "1111111111111001001111001111111001001001111001111111111111111001001001111111001111001001111111001001111111111001111001001111111001001001111111111001001\n"
				+ "1000000000001001000000000001000001001001000001000001001000000000001000000001000001000000000000001001000001001000001001000001000000001001000000000001001\n"
				+ "1111001111001001111001111001001111111001111111001111001111001111001001111111001001111111001001111111111001001001111001001001001001001001001111001111111\n"
				+ "1000001001001000000001000000000001000000000001000001000001000001001001000000001000001000001000001001000000001000001000001001001001001001001000000000001\n"
				+ "1001111001001001111111111111001001111111001111001111001111001111111111111111111111001001111001001001001111111111111001111111001111111001111111111111001\n"
				+ "1000001000001000001000000001001000001000000000001000000001000000001000000000000001001000001001001001001001000000000000000000001001001000000001000000001\n"
				+ "1001111001001001001001111001111001111111001001001001111111001001001001111001111111001111111001001001001001111001001111111001111001001111001001111111001\n"
				+ "100100000100000100000100000100000000000000100100100000000000100100100100000000000000100000000100000000000000100100000000100000000000100000100100000000\n"
				+ "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100\n";
		
		List<String> myList = new ArrayList<String>(Arrays.asList(mazeString.split("")));
		System.out.print(myList);
				
	}

}