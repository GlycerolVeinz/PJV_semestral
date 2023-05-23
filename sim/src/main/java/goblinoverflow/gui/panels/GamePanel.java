package goblinoverflow.gui.panels;

import goblinoverflow.Simulation;
import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.tiles.Map;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Panel class that displays the game map and creatures on it.
 */
public class GamePanel extends JPanel {
	private static final int tileSize = 16;
	final static int panelWidth = Simulation.getMapTileWidth() * tileSize;
	final static int panelHeight = Simulation.getMapTileHeight() * tileSize;
	private final Map gameMap;

	/**
	 * GamePanel constructor.
	 * Creates panel and sets its size.
	 *
	 * @param gameMap - map of the game
	 */
	public GamePanel(Map gameMap) {
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		this.setBackground(Color.BLACK);
		this.gameMap = gameMap;
	}

	public static int getTileSize() {
		return tileSize;
	}

    /**
     * Draws the map based on the gameMap object.
     *
     * @param g2d - Graphics2D object
     */
	private void drawMap(Graphics2D g2d) {
		for (int y = 0; y < Simulation.getMapTileHeight(); ++y) {
			for (int x = 0; x < Simulation.getMapTileWidth(); ++x) {
				if (!Objects.equals(gameMap.getTile(x, y).getName(), "floor")) {
					g2d.drawImage(gameMap.getTile(x, y).getTexture(), x * getTileSize(), y * getTileSize(), null);
				}
			}
		}
	}

    /**
     * Draws all the creatures after redrawing the map.
     *
     * @param g - Graphics object
     */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawMap(g2d);

		if (Simulation.getCreatures().size() > 0) {
			for (Creature creature : Simulation.getCreatures()) {
				g2d.drawImage(creature.getTexture(), creature.getX() * getTileSize(), creature.getY() * getTileSize(), null);
			}
		}
		g2d.dispose();
	}
}

