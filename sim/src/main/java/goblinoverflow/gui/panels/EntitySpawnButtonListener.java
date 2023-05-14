package goblinoverflow.gui.panels;

import goblinoverflow.gui.panels.buttons.EntityButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;


public class EntitySpawnButtonListener implements ActionListener {

	private final BottomButtonPanel panel;

	public EntitySpawnButtonListener(BottomButtonPanel panel) {
		this.panel = panel;
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
		}
		else if (button.isBlocked()) {
			return;
		} else {
			button.setPressed(true);
			button.setBackground(Color.BLACK);
			for (EntityButton b: this.getPanel().getButtons()) {
				if (b != button) {
					b.setBlocked(true);
				}
			}
		}
	}
}

