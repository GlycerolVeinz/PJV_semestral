package goblinoverflow.util;

public class Coord {
	private int x;
	private int y;

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

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int distance(Coord coord) {
		return Math.abs(coord.getX() - this.getX()) + Math.abs(coord.getY() - this.getY());
	}
}
