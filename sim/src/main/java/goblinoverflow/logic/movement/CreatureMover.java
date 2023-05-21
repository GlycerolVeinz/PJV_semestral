package goblinoverflow.logic.movement;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.tiles.Tile;
import goblinoverflow.logic.movement.pathfinding.AStar;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

public class CreatureMover {
	public final static Coord up = new Coord(0, -1);
	public final static Coord down = new Coord(0, +1);
	public final static Coord left = new Coord(-1, 0);
	public final static Coord right = new Coord(+1, 0);
	public final static Coord upLeft = new Coord(-1, -1);
	public final static Coord upRight = new Coord(+1, -1);
	public final static Coord downLeft = new Coord(-1, +1);
	public final static Coord downRight = new Coord(+1, +1);
	public final static Coord[] directions = {up, down, left, right, upLeft, upRight, downLeft, downRight};

	public void moveAllCreatures() {
		ArrayList<Creature> goblins = new ArrayList<>();
		ArrayList<Creature> otherCreatures = new ArrayList<>();
		ArrayList<Creature> gold = new ArrayList<>();

		for (Creature creature : Simulation.getCreatures()) {
			if (creature.getName().equals("goblin")) {
				goblins.add(creature);
			} else if (creature.getName().equals("gold")) {
				gold.add(creature);
			} else {
				otherCreatures.add(creature);
			}
		}

		setCreatureTargets(goblins, gold);
		moveGoblins(goblins);

//		setCreatureTargets(otherCreatures, goblins);
//		moveCreatures();
	}

	public void setCreatureTargets(ArrayList<Creature> creatures, ArrayList<Creature> possibleTargets) {
		for (Creature creature : creatures) {
			if (creature.getCurrentTarget() == null) {
				int randomIndex = (int) (Math.random() * possibleTargets.size());
				Creature randomTarget = possibleTargets.get(randomIndex);
				creature.setCurrentTarget(randomTarget);
			}
		}
	}

	public void moveGoblins(ArrayList<Creature> goblins) {
		ArrayList<Creature> toRemove = new ArrayList<>();
		ArrayList<Creature> toAdd = new ArrayList<>();

		for (Creature goblin : goblins){
			AStar aStar = new AStar(Simulation.findEmptyTiles(true), Simulation.getGameMap().creatureLocation(goblin), Simulation.getGameMap().creatureLocation(goblin.getCurrentTarget()));
			Tile nextStep = aStar.findPath(true);
			goblin.setCoord(nextStep.getCoord());
			if (goblin.getCoord().equals(goblin.getCurrentTarget().getCoord())) {
				goblin.setCurrentTarget(null);
			}
			for (Creature creature : Simulation.getCreatures())
			{
				if (creature.getCoord().equals(goblin.getCoord()) && (creature != goblin)) {
					switch (creature.getName()) {
						case "gold":
							toRemove.add(creature);
							break;
						case "goblin":
							Creature newGoblin = new Creature("goblin", goblin.getX(), goblin.getY());
							toAdd.add(newGoblin);
							break;
						default:
							break;
					}
				}
			}

			aStar = null;
		}
		Simulation.getCreatures().removeAll(toRemove);
//		Simulation.getCreatures().addAll(toAdd);
	}

	public void moveCreatures() {

	}


}
