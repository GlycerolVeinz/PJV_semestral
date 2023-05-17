package goblinoverflow.logic.spawn;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Spawner {
	public void updateMap() {
		ArrayList<Coord> emptyTiles = Simulation.findEmptyTiles();
//		addGold(emptyTiles);
		addGoblins(emptyTiles);
	}

//	private void addGold(ArrayList<Coord> emptyTiles){
//		for (int i = 0; i < 10; i++) {
//			int randomIndex = (int) (Math.random() * emptyTiles.size());
//			Coord randomCoord = emptyTiles.get(randomIndex);
//
//
//			emptyTiles.remove(randomIndex);
//		}
//	}

	private void addGoblins(ArrayList<Coord> emptyTiles) {
		try {
			for (int i = 0; i < 5; i++) {
				int randomIndex = (int) (Math.random() * emptyTiles.size());
				Coord randomCoord = emptyTiles.get(randomIndex);

				Creature newGoblin = new Creature("goblin", randomCoord.getX(), randomCoord.getY());
				Simulation.getCreatures().add(newGoblin);

				emptyTiles.remove(randomIndex);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("DEFEAT");
			System.out.println("GOBLINS HAVE OVERFLOWN YOUR DUNGEON");
			exit(0);
		}
	}
}
