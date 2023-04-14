package goblinoverflow.maps;

import goblinoverflow.entities.Entity;
import goblinoverflow.maps.tiles.Tiles;

/**
 * Maps
 */
public class Maps {
    private int Size;
    private Tiles[][] map;

    public Maps(int size) {
        this.Size = size;
        this.map = new Tiles[size][size];
    }

    public void generate_map() {
        // generate map logic
    }

    public void addEntity(Entity entity) {
    }
}