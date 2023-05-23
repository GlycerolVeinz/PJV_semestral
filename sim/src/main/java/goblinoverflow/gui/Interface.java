package goblinoverflow.gui;

import goblinoverflow.Simulation;
import goblinoverflow.entities.tiles.Map;
import goblinoverflow.gui.panels.BottomButtonPanel;
import goblinoverflow.gui.panels.GamePanel;
import goblinoverflow.gui.panels.SideButtonPanel;
import goblinoverflow.gui.panels.SideStatsPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Main View class, responsible for the whole gui.
 * Based on java swing.
 * Divides Frame into 4 panels:
 *
 * @GamePanel - displays the map
 * @BottomButtonPanel - displays buttons for spawn of creatures
 * @SideButtonPanel - displays start / stop button
 * @SideStatsPanel - displays statistics about the simulation (number of creatures)
 */
public class Interface extends JFrame {
	final Color sidePanelsColor = Color.DARK_GRAY;
	private final GamePanel gamePanel;
	private final SideStatsPanel SideStatsPanel;

	/**
	 * Interface constructor.
	 * Creates frame and adds all panels to it.
	 *
	 * @param title   - title of the frame
	 * @param gameMap - map of the game
	 * @param sim     - main game-loop object that needs to be animated.
	 */

	public Interface(String title, Map gameMap, Simulation sim) {
		JFrame window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		this.gamePanel = new GamePanel(gameMap);
		window.add(gamePanel, BorderLayout.CENTER);

		BottomButtonPanel bottomButtonPanel = new BottomButtonPanel(sidePanelsColor, gamePanel);
		window.add(bottomButtonPanel, BorderLayout.SOUTH);

		SideButtonPanel sideButtonPanel = new SideButtonPanel(sidePanelsColor, sim);
		window.add(sideButtonPanel, BorderLayout.EAST);

		this.SideStatsPanel = new SideStatsPanel(sidePanelsColor);
		window.add(SideStatsPanel, BorderLayout.WEST);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * Updates the statistics panel.
	 */
	public void update() {
		SideStatsPanel.updateCounts();
	}
}
