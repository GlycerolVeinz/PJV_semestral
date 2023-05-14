package goblinoverflow.gui.panels.buttons.listeners;

import goblinoverflow.Simulation;
import goblinoverflow.gui.panels.buttons.StartButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {

	private final Simulation simulation;

	public StartButtonListener(Simulation simulation) {
		this.simulation = simulation;
	}

	public Simulation getSimulation() {
		return simulation;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		StartButton button = (StartButton) e.getSource();
		if (this.getSimulation().isRunning()){
			this.getSimulation().setRunning(false);
			button.setText("Start");
			button.setBackground(java.awt.Color.GREEN);
		} else {
			this.getSimulation().setRunning(true);
			button.setText("Stop");
			button.setBackground(java.awt.Color.RED);
		}
	}
}
