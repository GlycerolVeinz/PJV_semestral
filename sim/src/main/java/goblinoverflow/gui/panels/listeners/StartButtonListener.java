package goblinoverflow.gui.panels.listeners;

import goblinoverflow.Simulation;
import goblinoverflow.gui.panels.buttons.StartButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class for start / stop button.
 * */
public class StartButtonListener implements ActionListener {
	private final Simulation simulation;
	public StartButtonListener(Simulation simulation) {
		this.simulation = simulation;
	}
	public Simulation getSimulation() {
		return simulation;
	}

	/**
	 * Listens for button clicks.
	 * Changes button's and simulation's state accordingly.
	 * @param e - event that triggered the listener
	 * */
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
