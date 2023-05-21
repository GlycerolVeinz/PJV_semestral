package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;
import goblinoverflow.gui.panels.GamePanel;
import goblinoverflow.util.Coord;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Creature extends Entity {
	private static final int maxEntities = 7;
	private static final int maxGoblins = 15;
	private static int goblinCount = 0;
	private static int wolfCount = 0;
	private static int humanCount = 0;
	private static int zombieCount = 0;
	private static int skeletonCount = 0;
	private static int creatureCount = 0;

	private Creature currentTarget;

	public Creature(String name, int x, int y) {
		super(name, x, y);
		if (creatureCount >= maxEntities) {
			System.err.println("Max entities reached");
			throw new RuntimeException("Max entities reached");
		}
		switch (name) {
			case "wolf":
				wolfCount++;
				break;
			case "human":
				humanCount++;
				break;
			case "zombie":
				zombieCount++;
				break;
			case "skeleton":
				skeletonCount++;
				break;
			case "goblin":
				goblinCount++;
				if (goblinCount > maxGoblins) {
					System.out.println("GOBLIN OVERFLOW");
					exit(0);
				}
				break;
			default:
				break;
		}
		creatureCount = wolfCount + humanCount + zombieCount + skeletonCount;
		getEntityTexture(name, 'c');
	}


	public Creature getCurrentTarget() {
		return currentTarget;
	}

	public void setCurrentTarget(Creature currentTarget) {
		this.currentTarget = currentTarget;
	}

	public void moveBy(int dx, int dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public static void creatureDied(Creature creature){
		switch (creature.getName()) {
			case "wolf":
				wolfCount--;
				break;
			case "human":
				humanCount--;
				break;
			case "zombie":
				zombieCount--;
				break;
			case "skeleton":
				skeletonCount--;
				break;
			case "goblin":
				goblinCount--;
				break;
			default:
				break;
		}
		if (goblinCount == 0){
			System.out.println("YOU WIN");
			exit(0);
		}
		creatureCount = wolfCount + humanCount + zombieCount + skeletonCount;
	}

}