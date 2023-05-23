package goblinoverflow.entities.tiles;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.logic.movement.CreatureMover;
import goblinoverflow.util.Coord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Map class that holds all tiles in one place (map).
 */
public class Map {
	private final Tile[][] tiles;

	/**
	 * Map constructor.
	 * Creates a map based on .txt file in resources of a given size.
	 * Exits with code 101 if fails to load the file.
	 * @param Height Height of the map.
	 * @param Width  Width of the map.
	 * <p>
	 * (sizes are in tiles not pixels)
	 * </p>
	 */
	public Map(int Height, int Width) {
		tiles = new Tile[Height][Width];

		try {
			BufferedReader reader = new BufferedReader(new FileReader(Objects.requireNonNull(getClass().getResource("/map/dungeon_map.txt")).getFile()));
			for (int y = 0; y < Height; ++y) {
				String line = reader.readLine();
				for (int x = 0; x < Width; ++x) {
					char glyph = line.charAt(x);
					if (glyph == '#') {
						tiles[y][x] = new Tile("wall", x, y);
					} else if (glyph == '.') {
						tiles[y][x] = new Tile("floor", x, y);
					} else if (glyph == '/') {
						tiles[y][x] = new Tile("door", x, y);
					}
				}
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Error loading map file");
			e.printStackTrace();
			System.exit(101);
		}
	}

	public Tile getTile(int x, int y) {
		return tiles[y][x];
	}

	public Tile creatureLocation(Creature creature) {
		return tiles[creature.getY()][creature.getX()];
	}

	/**
	 * Returns a list of all neighbours of a given tile.
	 *
	 * @param tile Tile to get neighbours of.
	 * @return List of all neighbours of a given tile.
	 * (ALL NEIGHBOURS, even walls)
	 */
	public ArrayList<Tile> getNeighbours(Tile tile) {
		ArrayList<Tile> neighbours = new ArrayList<>();
		int x = tile.getX();
		int y = tile.getY();
		for (Coord dir : CreatureMover.directions) {
			int newX = x + dir.getX();
			int newY = y + dir.getY();
			if (newX >= 0 && newX < Simulation.getMapTileWidth() && newY >= 0 && newY < Simulation.getMapTileHeight()) {
				neighbours.add(getTile(newX, newY));
			}
		}
		return neighbours;
	}
}
