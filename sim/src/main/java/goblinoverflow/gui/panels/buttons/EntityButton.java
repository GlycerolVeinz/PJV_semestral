package goblinoverflow.gui.panels.buttons;

import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.gui.panels.BottomButtonPanel;
import goblinoverflow.gui.panels.GamePanel;
import goblinoverflow.gui.panels.listeners.CreatureSpawnButtonListener;
import goblinoverflow.gui.panels.listeners.CreatureSpawnMouseListener;

import javax.swing.*;
import java.awt.*;

/**
 * Button class that manages an entity button.
 */
public class EntityButton extends JButton {
	private CreatureType creatureType;
	private CreatureSpawnMouseListener listener;
	private boolean isBlocked = false;
	private boolean isPressed = false;

	/**
	 * EntityButton constructor.
	 * Sets colors, adds listener.
	 *
	 * @param name      - name of the button
	 * @param panel     - panel with buttons
	 * @param gamePanel - panel where entities are spawned
	 */
	public EntityButton(String name, BottomButtonPanel panel, GamePanel gamePanel) {
		super(name);
		this.setBackground(Color.GRAY);
		this.setForeground(Color.WHITE);
		this.addActionListener(new CreatureSpawnButtonListener(panel, gamePanel));

	}

	public CreatureSpawnMouseListener getListener() {
		return listener;
	}

	public void setListener(CreatureSpawnMouseListener listener) {
		this.listener = listener;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean blocked) {
		isBlocked = blocked;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean pressed) {
		isPressed = pressed;
	}

	public CreatureType getCreatureType() {
		return creatureType;
	}

	public void setCreatureType(CreatureType creatureType) {
		this.creatureType = creatureType;
	}
}
