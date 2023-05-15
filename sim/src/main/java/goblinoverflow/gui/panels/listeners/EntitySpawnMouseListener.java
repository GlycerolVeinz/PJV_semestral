package goblinoverflow.gui.panels.listeners;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.gui.panels.GamePanel;

import java.awt.event.MouseAdapter;

public class EntitySpawnMouseListener extends MouseAdapter {
	private String currentCreature;
	private GamePanel gamePanel;

	public EntitySpawnMouseListener(String currentCreature, GamePanel gamePanel) {
		super();
		this.currentCreature = currentCreature;
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int x = e.getX() / GamePanel.getTileSize();
		int y = e.getY() / GamePanel.getTileSize();

		Creature creature = new Creature(getCurrentCreature(), x, y);
		Simulation.getCreatures().add(creature);
	}

	public String getCurrentCreature() {
		return currentCreature;
	}
}
