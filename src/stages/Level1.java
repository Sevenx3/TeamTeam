package stages;

import model.LevelInterface;

public class Level1 implements LevelInterface{
	
	public static String[] data =
		{"0|50 10?0","1|50 100?1"};
	
	public String[] getData(){
		return data;
	}
}
