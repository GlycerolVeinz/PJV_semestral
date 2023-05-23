package goblinoverflow.entities.tiles;

import goblinoverflow.entities.Entity;

/**
 * Tile class that holds most of the important information about the tiles.
 * extends Entity class.
 */
public class Tile extends Entity {

	private int fScore;
	private int gScore;
	private int hScore;
	private Tile parent;

	/**
	 * Tile constructor.
	 *
	 * @param name Name of the tile.
	 * @param x    X coordinate of the tile.
	 * @param y    Y coordinate of the tile.
	 */
	public Tile(String name, int x, int y) {
		super(name, x, y);
		fScore = 0;
		gScore = 0;
		hScore = 0;
		fetchEntityTexture(name, 't');
	}

	public int getF() {
		return this.fScore;
	}

	public void setF(int f) {
		this.fScore = f;
	}

	public int getG() {
		return this.gScore;
	}

	public void setG(int g) {
		this.gScore = g;
	}

	public int getH() {
		return this.hScore;
	}

	public void setH(int h) {
		this.hScore = h;
	}

	public Tile getParent() {
		return this.parent;
	}

	public void setParent(Tile parent) {
		this.parent = parent;
	}

	/**
	 * Calculates the diagonal distance between two tiles.
	 *
	 * @param end The tile to which the distance is calculated.
	 * @return The distance between the two tiles.
	 */
	public int getDistance(Tile end) {
		int x = Math.abs(this.getX() - end.getX());
		int y = Math.abs(this.getY() - end.getY());
		return Math.max(x, y);
	}
}
