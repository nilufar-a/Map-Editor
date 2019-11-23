package pkg;

public class Map {

	public String [][] obstacles;
	public String [][] powerups;
	public SpawnPoints[] spawnPoints;

	public int width;
	public int height;
	public int numberOfPlayers;
	public int id;
	public String name;
	
	public Map( int width, int height, int numberOfPlayers, int id, String name) {
		super();
		
			if (width >numberOfPlayers && width < 65)this.width = width;
			if (height >numberOfPlayers && height < 65)this.height = height;
	
		this.numberOfPlayers = numberOfPlayers;
		this.id = id;
		//if(isNameOccupied(name)== Boolean.TRUE)
		
		int totalMapCells = width*height;
		
		this.obstacles = new String[2][(int)(totalMapCells*0.5)]; // The number of obstacles can be at most 50% of the whole tiles
		this.powerups = new String[2][(int)(totalMapCells*0.3)];
		this.spawnPoints = new SpawnPoints[numberOfPlayers];
		

	}
	//64*6
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
