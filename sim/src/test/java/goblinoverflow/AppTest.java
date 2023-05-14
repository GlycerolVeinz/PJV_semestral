package goblinoverflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import goblinoverflow.entities.tiles.Map;
import goblinoverflow.entities.tiles.Tile;
import org.junit.Test;


import java.io.IOException;

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
}
