package goblinoverflow.gui.panels.listeners;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.gui.panels.GamePanel;

import java.awt.event.MouseAdapter;

public class EntitySpawnMouseListener extends MouseAdapter {
	private String currentCreature;

	public EntitySpawnMouseListener(String currentCreature) {
		super();
		this.currentCreature = currentCreature;
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int x = e.getX() / GamePanel.getTileSize();
		int y = e.getY() / GamePanel.getTileSize();

		if (isTileEmpty(x, y)) {
			try {
				Creature creature = new Creature(getCurrentCreature(), x, y);
				Simulation.getCreatures().add(creature);
			} catch (RuntimeException exception) {
				System.err.println("Max entities reached");
			}
		}
	}

	private boolean isTileEmpty(int x, int y) {
		boolean isEmpty = true;
		if (Simulation.getGameMap().getTile(x, y).getName().equals("floor")) {
			for (Creature creature : Simulation.getCreatures()){
				if (creature.getX() == x && creature.getY() == y) {
					isEmpty = false;
					break;
				}
			}
		} else {
			isEmpty = false;
		}
		return isEmpty;
	}

	public String getCurrentCreature() {
		return currentCreature;
	}
}
