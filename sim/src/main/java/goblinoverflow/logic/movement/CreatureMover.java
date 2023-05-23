package goblinoverflow.logic.movement;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.entities.tiles.Tile;
import goblinoverflow.logic.movement.pathfinding.AStar;
import goblinoverflow.util.Coord;

import java.util.ArrayList;
import java.util.Random;

/**
* Main simulation logic class, that moves every creature.
*
* @Coord[] directions array of all possible directions that creatures can move in.
* */
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

	/**
	* Main move method.
	* Gives target to every Creature that doesn't have one.
	* Move everyone by 2 tiles, except goblins.
	* Moves goblins after everyone else.
	* */
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

		setCreatureTargets(otherCreatures, goblins);
		moveCreatures(otherCreatures);
		moveCreatures(otherCreatures);

		setCreatureTargets(goblins, gold);
		moveGoblins(goblins);
	}

	/**
	* Sets target for every creature that doesn't have one.
	* Picks a random target from possible targets.
	*
	* @param creatures list of all creatures that should have a target
	* @param possibleTargets list of all possible targets
	* */
	public void setCreatureTargets(ArrayList<Creature> creatures, ArrayList<Creature> possibleTargets) {
		for (Creature creature : creatures) {
			if (creature.getCurrentTarget() == null) {
				int randomIndex = (int) (Math.random() * possibleTargets.size());
				Creature randomTarget = possibleTargets.get(randomIndex);
				creature.setCurrentTarget(randomTarget);
			}
		}
	}

	/**
	* Method that moves every goblin by 1 tile.
	* Decides path using AStar class.
	* Processes goblin interactions with gold and other goblins.
	*
	* @param goblins list of all goblins
	* */
	public void moveGoblins(ArrayList<Creature> goblins) {
		ArrayList<Creature> toRemove = new ArrayList<>();
		ArrayList<Creature> toAdd = new ArrayList<>();

		for (Creature goblin : goblins) {
			if (goblin.getCurrentTarget() == null) {
				continue;
			}
			AStar aStar = new AStar(Simulation.getGameMap().creatureLocation(goblin), Simulation.getGameMap().creatureLocation(goblin.getCurrentTarget()));
			Tile nextStep = aStar.findPath(true);
			goblin.setCoord(nextStep.getCoord());
			if (goblin.getCoord().equals(goblin.getCurrentTarget().getCoord())) {
				goblin.setCurrentTarget(null);
			}
			for (Creature creature : Simulation.getCreatures()) {
				if (creature.getCoord().equals(goblin.getCoord()) && (creature != goblin)) {
					switch (creature.getType()) {
						case GOLD:
							toRemove.add(creature);
							break;
						case GOBLIN:
							Creature newGoblin = new Creature(CreatureType.GOBLIN, goblin.getX(), goblin.getY());
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
		for (Creature creature : toRemove) {
			creature = null;
		}
		Simulation.getCreatures().addAll(toAdd);
	}


	/**
	 * Method that moves every creature by 1 tile.
	 * Decides path using AStar class.
	 * Processes creature interactions, mainly fight with goblins.
	 *
	 * @param creatures list of all creatures
	 * */
	public void moveCreatures(ArrayList<Creature> creatures) {
		ArrayList<Creature> toRemove = new ArrayList<>();
		ArrayList<Creature> toAdd = new ArrayList<>();

		for (Creature creature : creatures) {
			if (creature.getCurrentTarget() == null) {
				continue;
			}
			AStar aStar = new AStar(Simulation.getGameMap().creatureLocation(creature), Simulation.getGameMap().creatureLocation(creature.getCurrentTarget()));
			Tile nextStep = aStar.findPath(false);
			if (nextStep != null) {
				creature.setCoord(nextStep.getCoord());
			}
			if (creature.getCoord().equals(creature.getCurrentTarget().getCoord())) {
				creature.setCurrentTarget(null);
			}

			for (Creature otherCreature : Simulation.getCreatures()) {
				if (otherCreature.getCoord().equals(creature.getCoord()) && (otherCreature != creature)) {
					switch (otherCreature.getType()) {
						case GOBLIN:
							Random fight = new Random();
							int fightResult = fight.nextInt(100);
							if (fightResult < 90){
								toRemove.add(otherCreature);
							}
							else{
								toRemove.add(creature);
							}
							fight = null;
							break;
						case HUMAN:
							if (creature.getType().equals(CreatureType.SKELETON) || creature.getType().equals(CreatureType.WOLF)) {
								toRemove.add(otherCreature);
							}
							else if (creature.getType().equals(CreatureType.ZOMBIE)) {
								toRemove.add(otherCreature);
								Creature newZombie = new Creature(CreatureType.ZOMBIE, creature.getX(), creature.getY());
								toAdd.add(newZombie);
							}
							break;
						case WOLF:
							if (creature.getType().equals(CreatureType.ZOMBIE)) {
								toRemove.add(otherCreature);
							}
						default:
							break;
					}
				}
			}
			aStar = null;
		}

		Simulation.getCreatures().removeAll(toRemove);
		for (Creature creature : toRemove) {
			Creature.creatureDied(creature.getType());
			creature = null;
		}
		Simulation.getCreatures().addAll(toAdd);
	}


}
