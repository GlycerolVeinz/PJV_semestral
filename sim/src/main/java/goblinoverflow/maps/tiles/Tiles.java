package goblinoverflow.maps.tiles;

import java.util.HashMap;

/**
 * Tiles
 */
public class Tiles {
    private boolean walkthru;
    private Character look;
    private String name;

    public Tiles(boolean walkthru, char look, String name) {
        this.walkthru = walkthru;
        this.look = look;
        this.name = name;
    }
}