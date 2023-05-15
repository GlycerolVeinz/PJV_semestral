package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;
import goblinoverflow.gui.panels.GamePanel;

import java.awt.*;

public class Creature extends Entity {
	private static int goblinCount = 0;
	private static int wolfCount = 0;
	private static int humanCount = 0;
	private static int zombieCount = 0;
	private static int skeletonCount = 0;
	private static int creatureCount = 0;
	private static final int maxEntities = 20;

	public Creature(String name, int x, int y, char glyph, Color color) {
		super(name, x, y);
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
		}
		creatureCount++;
		getEntityTexture(name, 'c');
	}
	public void update() {
//        TODO: update entity
	}

	public void moveBy(int dx, int dy) {
		setX(getX() + (dx * GamePanel.getTileSize()));
		setY(getY() + (dy * GamePanel.getTileSize()));
	}
}