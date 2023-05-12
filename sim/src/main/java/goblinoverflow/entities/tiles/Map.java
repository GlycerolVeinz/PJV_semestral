package goblinoverflow.entities.tiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class Map {
	private Tile[][] tiles;

	public Map(){
		tiles = new Tile[24][32];

		try {
			BufferedReader reader = new BufferedReader(new FileReader(Objects.requireNonNull(getClass().getResource("/map/dungeon_map.txt")).getFile()));
			for (int y = 0; y < 24; y++) {
				String line = reader.readLine();
				for (int x = 0; x < 32; x++) {
					char glyph = line.charAt(x);
					String tileName = "";
					if (glyph == '#'){
						tiles[x][y] = new Tile("wall", x, y);
					} else if (glyph == '.') {
						tiles[x][y] = new Tile("floor", x, y);
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error loading map file");
			e.printStackTrace();
			System.exit(101);
		}
	}
}
