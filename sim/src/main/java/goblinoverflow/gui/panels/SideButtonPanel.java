package goblinoverflow.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SideButtonPanel extends JPanel {
	final int buttonsCount = 4;

	public SideButtonPanel(Color color) {
		this.setLayout(new GridLayout(buttonsCount, 1));
		this.setPreferredSize(new Dimension(150, 100));
		this.setBackground(color);

		ArrayList<JButton> buttons = new ArrayList<>();
		JButton startButton = new JButton("Start / Stop");
		buttons.add(startButton);
		JButton saveButton = new JButton("Save");
		buttons.add(saveButton);
		JButton loadButton = new JButton("Load");
		buttons.add(loadButton);

		for (JButton button : buttons) {
			button.setBackground(Color.GRAY);
			button.setForeground(Color.WHITE);
			this.add(button);
		}
	}
}
