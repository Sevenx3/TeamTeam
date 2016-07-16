package stages;

import model.LevelInterface;

public class Level1 implements LevelInterface{
	
	public static String[] data =
		{"1|50 10|0","2|50 100|1"};
	
	public String[] getData(){
		return data;
	}
}
