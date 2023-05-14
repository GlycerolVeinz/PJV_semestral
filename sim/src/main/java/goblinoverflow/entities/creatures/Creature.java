package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;
import goblinoverflow.gui.panels.GamePanel;

import java.awt.*;

public class Creature extends Entity {
	private static int entityCount = 0;
	private static final int maxEntities = 20;

	public Creature(String name, int x, int y, char glyph, Color color) {
		super(name, x, y);
		entityCount++;
	}

	public void update() {
//        TODO: update entity
	}

	public void moveBy(int dx, int dy) {
		setX(getX() + (dx * GamePanel.getTileSize()));
		setY(getY() + (dy * GamePanel.getTileSize()));
	}
}