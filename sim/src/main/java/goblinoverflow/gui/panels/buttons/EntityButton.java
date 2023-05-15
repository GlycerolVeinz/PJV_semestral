package goblinoverflow.gui.panels.buttons;

import goblinoverflow.gui.panels.BottomButtonPanel;
import goblinoverflow.gui.panels.EntitySpawnButtonListener;
import goblinoverflow.gui.panels.GamePanel;
import goblinoverflow.gui.panels.listeners.EntitySpawnMouseListener;

import javax.swing.*;
import java.awt.*;

public class EntityButton extends JButton{

	public void setListener(EntitySpawnMouseListener listener) {
		this.listener = listener;
	}

	public EntitySpawnMouseListener getListener() {
		return listener;
	}

	private EntitySpawnMouseListener listener;
	private boolean isBlocked = false;
	private boolean isPressed = false;
	public EntityButton(String name, BottomButtonPanel panel, GamePanel gamePanel) {
		super(name);
		this.setBackground(Color.GRAY);
		this.setForeground(Color.WHITE);
		this.addActionListener(new EntitySpawnButtonListener(panel, gamePanel));
	}

	public void setPressed(boolean pressed) {
		isPressed = pressed;
	}

	public void setBlocked(boolean blocked) {
		isBlocked = blocked;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public boolean isPressed() {
		return isPressed;
	}
}
