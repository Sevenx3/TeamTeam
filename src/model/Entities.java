package model;

import java.awt.Point;

import stages.*;

public class Entities {

	private EntityEnum[] EntityList;
	private Point[] EntityPositions;
	private int[] EntityTimeSpawn;
	
	private void createEntities(String[] data){
		int candidateIndex = 0;
		for(String candidate: data){
			int index = Integer.parseInt(candidate.substring(0, candidate.indexOf("|")));
			EntityEnum newEntity = (0 == index) ? EntityEnum.PLAYER : null;
			newEntity = (0 == index) ? EntityEnum.ALIEN_EASY : null;
			newEntity = (0 == index) ? EntityEnum.ALIEN_NORMAL : null;
			newEntity = (0 == index) ? EntityEnum.ALIEN_HARD : null;
			newEntity = (0 == index) ? EntityEnum.ALIEN_BOSS : null;
			EntityList[candidateIndex] = newEntity;
			int xCord = Integer.parseInt(candidate.substring(candidate.indexOf("|")+1));
			int yCord = Integer.parseInt(candidate.substring(candidate.indexOf(" ")+1, candidate.indexOf("?")));
			EntityPositions[candidateIndex] = new Point(xCord,yCord);
			EntityTimeSpawn[candidateIndex] = Integer.parseInt(candidate.substring(candidate.indexOf("?")+1));
			candidateIndex++;
		}
		
	}
	
	public void loadEntities(String stageName){
		LevelInterface lvlInterface;
		lvlInterface = getInstance(stageName);
		String[] data = lvlInterface.getData();
		createEntities(data);
	}
	
	private static LevelInterface getInstance(String whichClass) {
		try {
			@SuppressWarnings("rawtypes")
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
