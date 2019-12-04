package call;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//import javax.validation.constraints.Max;

public class Map {
	public int width;
	public int height;
	public int numberOfPlayers;
	public int id;
	public String name;
	
	public ArrayList<Point> obstacles;
	public ArrayList<Point> powerups;
	public ArrayList<SpawnPoint> spawnPoints;
	
	public MapInfo mapInfo;


	
	public Map( int width, int height, int numberOfPlayers, int id, String name) {
		super();

		
			if (width >numberOfPlayers && width < 65)this.width = width;
			if (height >numberOfPlayers && height < 65)this.height = height;
	
		this.numberOfPlayers = numberOfPlayers;
		this.id = id;
		this.name = name;
		this.mapInfo = new MapInfo(width, height, numberOfPlayers, id, name);

	}
	
	public void populateMapMatrix() {
		for (int i = 0; i < spawnPoints.size(); i++) {
			int x= spawnPoints.get(i).x;
			int y = spawnPoints.get(i).y;
			
			mapInfo.mapMatrix[x][y] = "SPAWN";
		}
		
		for (int i = 0; i < obstacles.size(); i++) {
			int x= spawnPoints.get(i).x;
			int y = spawnPoints.get(i).y;
			
			mapInfo.mapMatrix[x][y] = "OBSTACLE";
		}
		
		for (int i = 0; i < powerups.size(); i++) {
			int x= spawnPoints.get(i).x;
			int y = spawnPoints.get(i).y;
			
			mapInfo.mapMatrix[x][y] = "POWERUP";
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(mapInfo.mapMatrix[j][i] == null)
				mapInfo.mapMatrix[j][i] = "EMPTY";

			}
		}
		
	}
	
	public MapInfo toMapInfo(Map map) { // attributes were set at creation of the map
		mapInfo.obstacles = (Point[]) map.obstacles.toArray();
		mapInfo.powerups = (Point[]) map.obstacles.toArray();
		mapInfo.spawnPoints = (SpawnPoint[]) map.obstacles.toArray();
		
		populateMapMatrix();
		return mapInfo;
	}

	public Boolean addObstacle(int x, int y) {
		
		if (pointIsWithinTheMap(x, y)) {
			if(isPointFree(x,y)) {
				obstacles.add(new Point(x,y));
			}
			else {
				removePointFromAllArrays(x,y);
				obstacles.add(new Point(x,y));
			}
		}
		
		return true; 
	}
	public Boolean addPowerUp(int x, int y ) {
		
		if (pointIsWithinTheMap(x, y)) {
			if(isPointFree(x,y)) {
				powerups.add(new Point(x,y));
			}
			else {
				removePointFromAllArrays(x,y);
				powerups.add(new Point(x,y));
			}
		}
		
		return true; 
	}
	public Boolean addSpawnPoint(int x, int y, Direction dir) {
		
		if (pointIsWithinTheMap(x, y)) {
			if(isPointFree(x,y)) {
				powerups.add(new SpawnPoint(x,y,dir));
			}
			else {
				removePointFromAllArrays(x,y);
				powerups.add(new SpawnPoint(x,y,dir));
			}
		}
		
		return true; 
	}
	
	
		
	private void removePointFromAllArrays(int x, int y) {
		Point pointToBeRemoved = new Point(x, y);
		obstacles.removeAll(Collections.singletonList(pointToBeRemoved));
		powerups.removeAll(Collections.singletonList(pointToBeRemoved));
		spawnPoints.removeAll(Collections.singletonList(pointToBeRemoved));
	}

	public boolean pointIsWithinTheMap(int x, int y) {
		Boolean isWithin = Boolean.FALSE;
		
		if (x>=0 && x<=width && y>=0 && y<=height) {
			isWithin = Boolean.TRUE;
		}
		return isWithin;
	}

	public Boolean isPointFree(int X, int Y) {
		Boolean free = Boolean.TRUE;
		Point p = new Point(X, Y);

		if(obstacles.contains(p)) {
			free = Boolean.FALSE;
			return free;
		}

		if(spawnPoints.contains(p)) {
			free = Boolean.FALSE;
			return free;
		}
		
		
		if(spawnPoints.contains(p)) {
			free = Boolean.FALSE;
			return free;
		}
		
		return free;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	

}