package goblinoverflow.util;

/**
 * Class for storing coordinates, made for utility and comfort purposes.
 * */
public class Coord {
	private final int x;
	private final int y;

	/**
	 * Constructor for Coord class.
	 *
	 * @param x x coordinate.
	 * @param y y coordinate.
	 * */
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Coord)) return false;
		Coord coord = (Coord) o;
		return getX() == coord.getX() && getY() == coord.getY();
	}
}
