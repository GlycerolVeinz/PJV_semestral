package goblinoverflow.gui.panels;

import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.gui.panels.buttons.EntityButton;
import goblinoverflow.gui.panels.listeners.EntitySpawnMouseListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntitySpawnButtonListener implements ActionListener {

	private final BottomButtonPanel panel;
	private final GamePanel gamePanel;

	public EntitySpawnButtonListener(BottomButtonPanel panel, GamePanel gamePanel) {
		this.panel = panel;
		this.gamePanel = gamePanel;
	}

	public BottomButtonPanel getPanel() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EntityButton button = (EntityButton) e.getSource();
		if (button.isPressed()) {
			button.setPressed(false);
			button.setBackground(Color.GRAY);
			for (EntityButton b: this.getPanel().getButtons()) {
				b.setBlocked(false);
			}
			getGamePanel().removeMouseListener(button.getListener());
			button.setListener(null);
		}
		else if (button.isBlocked()) {
		} else {
			button.setPressed(true);
			button.setBackground(Color.BLACK);
			for (EntityButton b: this.getPanel().getButtons()) {
				if (b != button) {
					b.setBlocked(true);
				}
			}
			CreatureType currentCreature = button.getCreatureType();
			EntitySpawnMouseListener listener = new EntitySpawnMouseListener(currentCreature);
			getGamePanel().addMouseListener(listener);
			button.setListener(listener);
		}
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}
}

