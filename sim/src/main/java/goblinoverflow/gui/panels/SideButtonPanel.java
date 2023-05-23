package goblinoverflow.gui.panels;

import goblinoverflow.Simulation;
import goblinoverflow.gui.panels.buttons.StartButton;

import javax.swing.*;
import java.awt.*;

public class SideButtonPanel extends JPanel {
	final int buttonsCount = 4;

	public SideButtonPanel(Color color, Simulation sim) {
		this.setLayout(new GridLayout(buttonsCount, 1));
		this.setPreferredSize(new Dimension(150, 100));
		this.setBackground(color);

		StartButton startButton = new StartButton("Start", sim);
		this.add(startButton);

	}
}
