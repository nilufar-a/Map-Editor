package call;

import java.util.ArrayList;

public class MapInfo {
	public int width;
	public int height;
	public int numberOfPlayers;
	public int id;
	public String name;
	
	public ArrayList<Point> obstacles;
	public ArrayList<Point> powerups;
	public ArrayList<SpawnPoint> spawnPoints;
	
	public MapInfo(int width, int height, int numberOfPlayers, int id, String name, ArrayList<Point> obstacles,
			ArrayList<Point> powerups, ArrayList<SpawnPoint> spawnPoints) {
		super();
		this.width = width;
		this.height = height;
		this.numberOfPlayers = numberOfPlayers;
		this.id = id;
		this.name = name;
		this.obstacles = obstacles;
		this.powerups = powerups;
		this.spawnPoints = spawnPoints;
	}
}
