package goblinoverflow.gui.panels.listeners;

import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.gui.panels.BottomButtonPanel;
import goblinoverflow.gui.panels.GamePanel;
import goblinoverflow.gui.panels.buttons.EntityButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Listener class for entity spawn buttons.
 * (decides who should be spawned)
 * Activates Mouse listener (CreatureSpawnMouseListener).
 * */
public class CreatureSpawnButtonListener implements ActionListener {
	private final BottomButtonPanel panel;
	private final GamePanel gamePanel;

	/**
	 * Constructor for spawn creatures button listener.
	 * @param panel - panel with buttons
	 * @param gamePanel - panel where entities are spawned
	 * */
	public CreatureSpawnButtonListener(BottomButtonPanel panel, GamePanel gamePanel) {
		this.panel = panel;
		this.gamePanel = gamePanel;
	}

	public BottomButtonPanel getPanel() {
		return panel;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * Listens for button clicks.
	 * Blocks all other Creature buttons and activates mouse listener.
	 * @param e - event that triggered the listener
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		EntityButton button = (EntityButton) e.getSource();
		if (button.isPressed()) {
			button.setPressed(false);
			button.setBackground(Color.GRAY);
			for (EntityButton b : this.getPanel().getButtons()) {
				b.setBlocked(false);
			}
			getGamePanel().removeMouseListener(button.getListener());
			button.setListener(null);
		} else if (button.isBlocked()) {
			// do nothing
		} else {
			button.setPressed(true);
			button.setBackground(Color.BLACK);
			for (EntityButton b : this.getPanel().getButtons()) {
				if (b != button) {
					b.setBlocked(true);
				}
			}
			CreatureType currentCreature = button.getCreatureType();
			CreatureSpawnMouseListener listener = new CreatureSpawnMouseListener(currentCreature);
			getGamePanel().addMouseListener(listener);
			button.setListener(listener);
		}
	}
}

