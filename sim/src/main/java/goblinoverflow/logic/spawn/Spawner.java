package goblinoverflow.logic.spawn;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

/**
 * Spawner class is responsible for spawning goblins and gold.
 */
public class Spawner {

	/**
	* Updates map by spawning 10 gold coins on empty tiles
	* */
	public void updateMap() {
		addGold(Simulation.findEmptyTilesCoord(false));
	}

	/**
	* Method that generates 10 different random coordinates and spawns gold on them.
	* Gold is categorized as a creature for the sake of simplicity.
	*
	* @param emptyTiles list of tiles from the map (preferably empty)
	* */
	private void addGold(ArrayList<Coord> emptyTiles){
		for (int i = 0; i < 10; i++) {
			int randomIndex = (int) (Math.random() * emptyTiles.size());
			Coord randomCoord = emptyTiles.get(randomIndex);

			Creature newGold = new Creature(CreatureType.GOLD, randomCoord.getX(), randomCoord.getY());
			Simulation.getCreatures().add(newGold);
			
			emptyTiles.remove(randomIndex);
		}
	}

	/**
	 * Method that generates 5 different random coordinates and spawns goblins on them.
	 * Gold is categorized as a creature for the sake of simplicity.
	 *
	 * @param emptyTiles list of tiles from the map (preferably empty)
	 * */
	public void addGoblins(ArrayList<Coord> emptyTiles) {
			for (int i = 0; i < 5; i++) {
				int randomIndex = (int) (Math.random() * emptyTiles.size());
				Coord randomCoord = emptyTiles.get(randomIndex);

				Creature newGoblin = new Creature(CreatureType.GOBLIN, randomCoord.getX(), randomCoord.getY());
				Simulation.getCreatures().add(newGoblin);

				emptyTiles.remove(randomIndex);
			}
	}
}
