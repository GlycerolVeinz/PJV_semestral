package goblinoverflow.logic.spawn;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

public class Spawner {
	public void updateMap() {
		ArrayList<Coord> emptyTiles = Simulation.findEmptyTilesCoord(false);
		addGold(emptyTiles);
	}

	private void addGold(ArrayList<Coord> emptyTiles){
		for (int i = 0; i < 10; i++) {
			int randomIndex = (int) (Math.random() * emptyTiles.size());
			Coord randomCoord = emptyTiles.get(randomIndex);

			Creature newGold = new Creature(CreatureType.GOLD, randomCoord.getX(), randomCoord.getY());
			Simulation.getCreatures().add(newGold);
			
			emptyTiles.remove(randomIndex);
		}
	}


	public void addGoblins(ArrayList<Coord> emptyTiles) {
//	only for initial spawn of goblins
			for (int i = 0; i < 5; i++) {
				int randomIndex = (int) (Math.random() * emptyTiles.size());
				Coord randomCoord = emptyTiles.get(randomIndex);

				Creature newGoblin = new Creature(CreatureType.GOBLIN, randomCoord.getX(), randomCoord.getY());
				Simulation.getCreatures().add(newGoblin);

				emptyTiles.remove(randomIndex);
			}
	}
}
