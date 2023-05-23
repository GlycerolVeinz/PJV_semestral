package goblinoverflow.gui.panels;

import goblinoverflow.Simulation;
import goblinoverflow.gui.panels.buttons.StartButton;

import javax.swing.*;
import java.awt.*;


/**
 * Panel class that displays start / stop button
 */
public class SideButtonPanel extends JPanel {
	/**
	 * SideButtonPanel constructor.
	 * Creates panel and adds start / stop button to it.
	 *
	 * @param color - background-color of the panel
	 * @param sim   - main game-loop object that needs to be animated.
	 */
	public SideButtonPanel(Color color, Simulation sim) {
		this.setLayout(new GridLayout(1, 1));
		this.setPreferredSize(new Dimension(150, 100));
		this.setBackground(color);

		StartButton startButton = new StartButton("Start", sim);
		this.add(startButton);
	}
}
