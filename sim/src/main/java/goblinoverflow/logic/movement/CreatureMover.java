package goblinoverflow.logic.movement;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
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

		setGoblinTargets(goblins, gold);
		moveGoblins();

		setCreatureTargets(otherCreatures, goblins);
		moveCreatures();
	}

	public void setGoblinTargets(ArrayList<Creature> goblins, ArrayList<Creature> gold) {
		for (Creature goblin : goblins) {
			if (goblin.getCurrentTarget() == null) {
				Creature target = findClosestGold(goblin, gold);
				goblin.setCurrentTarget(target);
			}
		}
	}

	public Creature findClosestGold(Creature goblin, ArrayList<Creature> gold) {
		Creature closestGold = gold.get(0);
		for (Creature g : gold) {
			if (goblin.getCoord().distance(g.getCoord()) < goblin.getCoord().distance(closestGold.getCoord())) {
				closestGold = g;
			}
		}
		return closestGold;
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

	public void moveGoblins() {

	}

	public void moveCreatures() {

	}
}
