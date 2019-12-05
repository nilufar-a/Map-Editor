package call;


import java.util.ArrayList;

public class MapInfo {
	
	public int width;
	public int height;
	public int numberOfPlayers;
	public int id;
	public String name;
	
	public Point [] obstacles;
	public Point [] powerups;
	public SpawnPoint[] spawnPoints;
	
	public String [][] mapMatrix;
	
	
	
	public MapInfo(int width, int height, int numberOfPlayers, int id, String name) {
		super();
		this.width = width;
		this.height = height;
		this.numberOfPlayers = numberOfPlayers;
		this.id = id;
		this.name = name;

		int totalMapCells = width*height;

		
		int maxNumberOfObstacles = (int) (totalMapCells*0.5);
		int maxNumberOfPowerUps = (int)(totalMapCells*0.3);

		this.obstacles = new Point[maxNumberOfObstacles]; // The number of obstacles can be at most 50% of the whole tiles
		this.powerups = new Point[maxNumberOfPowerUps];
		this.spawnPoints = new SpawnPoint[numberOfPlayers];
		this.mapMatrix = new String[width][height];
	}
	
	
}