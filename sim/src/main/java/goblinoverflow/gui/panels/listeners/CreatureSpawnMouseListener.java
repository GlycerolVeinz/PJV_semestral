package goblinoverflow.gui.panels.listeners;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.gui.panels.GamePanel;

import java.awt.event.MouseAdapter;

/**
 * Listener class for entity spawn.
 * */
public class CreatureSpawnMouseListener extends MouseAdapter {
	private final CreatureType currentCreature;

	/**
	 * Constructor for spawn creatures listener.
	 * @param currentCreature - creature type to spawn
	* */
	public CreatureSpawnMouseListener(CreatureType currentCreature) {
		super();
		this.currentCreature = currentCreature;
	}

	/**
	 * Listens for mouse clicks.
	 * Spawns a creature on position where clicked.
	 * (only on GamePanel)
	 * @param e - event that triggered the listener
	 * */
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

	public CreatureType getCurrentCreature() {
		return currentCreature;
	}

	/**
	 * Checks if tile is empty from any Entity.
	 * (only "floor" tiles are allowed)
	 * @param x - x coordinate of tile
	 * @param y - y coordinate of tile
	 * @return true if tile is empty, false otherwise
	 * */
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
}
