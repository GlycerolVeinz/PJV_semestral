package goblinoverflow.gui.panels.buttons;

import goblinoverflow.Simulation;
import goblinoverflow.gui.panels.listeners.StartButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Button class that manages start / stop button.
 */
public class StartButton extends JButton {
	/**
	 * StartButton constructor.
	 * Creates button and adds listener to it.
	 *
	 * @param name - name of the button
	 * @param sim  - main game-loop object that needs to be animated.
	 */
	public StartButton(String name, Simulation sim) {
		super(name);
		this.setForeground(Color.BLACK);

		if (!sim.isRunning()) {
			this.setText("Start");
			this.setBackground(Color.GREEN);
		} else {
			this.setText("Stop");
			this.setBackground(Color.RED);
		}

		this.addActionListener(new StartButtonListener(sim));
	}
}
