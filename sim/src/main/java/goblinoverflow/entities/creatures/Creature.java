package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;
import goblinoverflow.gui.panels.GamePanel;

import java.awt.*;

public class Creature extends Entity {
	public Creature(String name, int x, int y, char glyph, Color color) {
		super(name, x, y);
	}

	public void update() {
//        TODO: update entity
	}

	public void moveBy(int dx, int dy) {
		setX(getX() + (dx * GamePanel.getTileSize()));
		setY(getY() + (dy * GamePanel.getTileSize()));
	}
}