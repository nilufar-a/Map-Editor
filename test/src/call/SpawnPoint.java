package call;

public class SpawnPoint extends Point {
	public int x;
	public int y;
	Direction initialDirection;//min 2 max 10

	public SpawnPoint(int x, int y, Direction direction) {
		super(x, y);
		this.x = x;
		this.y = y;
		this.initialDirection = direction;
	}
	
}