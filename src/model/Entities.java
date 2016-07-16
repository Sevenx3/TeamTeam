package model;

import java.awt.Point;

import stages.Level1;

public class Entities {

	private EntityEnum[] EntityList;
	private Point[] EntityPositions;
	
	private void createEntities(String[] data){
		
	}
	
	public void loadEntities(String stageName){
		LevelInterface lvlInterface;
		lvlInterface = getInstance(stageName);
		String[] data = lvlInterface.getData();
		createEntities(data);
	}
	
	private static LevelInterface getInstance(String whichClass) {
		try {
			Class clazz = Class.forName(whichClass);
			return (LevelInterface) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
