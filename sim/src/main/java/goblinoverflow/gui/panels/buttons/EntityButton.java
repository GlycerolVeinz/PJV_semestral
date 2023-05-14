package goblinoverflow.gui.panels.buttons;

import goblinoverflow.gui.panels.BottomButtonPanel;
import goblinoverflow.gui.panels.EntitySpawnButtonListener;

import javax.swing.*;
import java.awt.*;

public class EntityButton extends JButton{

	private boolean isBlocked = false;
	private boolean isPressed = false;
	public EntityButton(String name, BottomButtonPanel panel) {
		super(name);
		this.setBackground(Color.GRAY);
		this.setForeground(Color.WHITE);
		this.addActionListener(new EntitySpawnButtonListener(panel));
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
