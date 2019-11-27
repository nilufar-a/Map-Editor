package call;
import java.util.ArrayList;

public class MapEditor {
		
		ArrayList<Map> maps;
		
		public MapEditor() {
			super();
			this.maps = new ArrayList<Map>();
		}
		
		public void addMap(int width, int height, int numberOfPlayers, String name) {// exceptions! w,h, min max 0
			
			Map newMap = new Map(width, height, numberOfPlayers, maps.size(), name);
			maps.add(newMap);
			
		}
		
		public void removeMap(int id) { // it doesn't check for duplicates yet tho

					maps.remove(id);
		}
	
}