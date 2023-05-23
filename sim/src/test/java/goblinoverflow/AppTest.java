package goblinoverflow;

import goblinoverflow.entities.tiles.Map;
import goblinoverflow.entities.tiles.Tile;
import goblinoverflow.logic.movement.pathfinding.AStar;
import org.junit.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Unit test for goblin overflow.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void testGetTileImage() {
        boolean existingTileLoad = false;
        try {
            Tile tile = new Tile("wall", 0, 0);
        } catch (IOException e) {
            existingTileLoad = true;
        }
        assertFalse(existingTileLoad);
    }

    @Test
    public void testGetNonExistingTileImage() {
        boolean nonExistingTileLoad = false;
        try {
            Tile tile = new Tile("nonExistingTile", 0, 0);
        } catch (Exception e) {
            nonExistingTileLoad = true;
        }
        assertTrue(nonExistingTileLoad);
    }

    @Test
    public void testMapLoad() {
        boolean mapLoad = false;
        try {
            Map map = new Map(24,32);
        } catch (Exception e) {
            mapLoad = true;
        }
        assertFalse(mapLoad);
    }

    @Test
    public void testAStar(){
        Map map = new Map(24,32);
        ArrayList<Tile> emptyTiles = Simulation.findEmptyTiles(true);
        Random rand = new Random();
        Tile start = emptyTiles.get(rand.nextInt(emptyTiles.size()));
        Tile end = emptyTiles.get(rand.nextInt(emptyTiles.size()));
        AStar aStar = new AStar(start, end);

        aStar.findPath(true);
        Tile current = end;
        while (!current.getParent().equals(start)) {
            current = aStar.reconstructPath(current);
            if (current == null) {
                fail();
            }
        }

        assertTrue(true);
    }
}
