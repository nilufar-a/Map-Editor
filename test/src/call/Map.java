package call;

//import javax.validation.constraints.Max;

public class Map {
	public int width;
	public int height;
	public int numberOfPlayers;
	public int id;
	public String name;
	
	public Point [] obstacles;
	public Point [] powerups;
	public SpawnPoint[] spawnPoints;


	
	public Map( int width, int height, int numberOfPlayers, int id, String name) {
		super();

		
			if (width >numberOfPlayers && width < 65)this.width = width;
			if (height >numberOfPlayers && height < 65)this.height = height;
	
		this.numberOfPlayers = numberOfPlayers;
		this.id = id;
		this.name = name;
		//if(isNameOccupied(name)== Boolean.TRUE)
		
		int totalMapCells = width*height;

		
		int maxNumberOfObstacles = (int) (totalMapCells*0.5);
		int maxNumberOfPowerUps = (int)(totalMapCells*0.3);

		this.obstacles = new Point[maxNumberOfObstacles]; // The number of obstacles can be at most 50% of the whole tiles
		this.powerups = new Point[maxNumberOfPowerUps];
		this.spawnPoints = new SpawnPoint[numberOfPlayers];
		

	}
	
	public Boolean addObstacle(int x, int y) {
		
		if (pointIsWithinTheMap(x, y)) {
			if(isPointFree(x,y)) {
				obstacles[obstacles.length] = new Point(x,y);
			}
			else {
				obstacles[obstacles.length] = new Point(x,y);
				removePointFromOtherArrays(x,y, "obstacles");
			}
		}
		
		return true; 
	}
	
		
	private void removePointFromOtherArrays(int x, int y, String array) {
		// TODO Auto-generated method stub
		
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

		for (Point point : obstacles) {
			if(point.getX() == X && point.getY() == Y) {
				free = Boolean.FALSE;
				return free;
			}
		}
		for (Point point : spawnPoints) {
			if(point.getX() == X && point.getY() == Y) {
				free = Boolean.FALSE;
				return free;
			}
		}
		for (Point point : powerups) {
			if(point.getX() == X && point.getY() == Y) {
				free = Boolean.FALSE;
				return free;
			}
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