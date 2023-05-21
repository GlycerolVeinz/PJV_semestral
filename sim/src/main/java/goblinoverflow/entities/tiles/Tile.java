package goblinoverflow.entities.tiles;

import goblinoverflow.entities.Entity;

import java.io.IOException;

public class Tile extends Entity {

	private int fScore;
	private int gScore;
	private int hScore;

	private Tile parent;

	public Tile(String name, int x, int y) throws IOException{
		super(name, x, y);
		fScore = 0;
		gScore = 0;
		hScore = 0;
		getEntityTexture(name, 't');
	}

	public int getF() {
		return this.fScore;
	}

	public int getG() {
		return this.gScore;
	}

	public int getH() {
		return this.hScore;
	}

	public void setF(int f){
		this.fScore = f;
	}
	public void setG(int g) {
		this.gScore = g;
	}


	public void setH(int h) {
		this.hScore = h;
	}

	public int getDistance(Tile end) {
		int x = Math.abs(this.getX() - end.getX());
		int y = Math.abs(this.getY() - end.getY());
		return Math.max(x, y);
	}

	public Tile getParent() {
		return this.parent;
	}

	public void setParent(Tile parent) {
		this.parent = parent;
	}


}
