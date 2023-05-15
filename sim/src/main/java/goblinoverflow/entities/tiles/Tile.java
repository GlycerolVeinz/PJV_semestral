package goblinoverflow.entities.tiles;

import goblinoverflow.entities.Entity;

import java.io.IOException;

public class Tile extends Entity {


	public Tile(String name, int x, int y) throws IOException{
		super(name, x, y);
		getEntityTexture(name, 't');
	}


}
