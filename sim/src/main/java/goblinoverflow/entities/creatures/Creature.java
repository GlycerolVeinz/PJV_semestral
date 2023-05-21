package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;
import goblinoverflow.gui.panels.GamePanel;
import goblinoverflow.util.Coord;

import java.awt.*;
import java.util.ArrayList;

public class Creature extends Entity {
	private static final int maxEntities = 20;
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
}