package goblinoverflow.gui.panels.buttons;

import goblinoverflow.Simulation;
import goblinoverflow.gui.panels.listeners.StartButtonListener;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {
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
