package goblinoverflow.gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class SideButtonPanel extends JPanel {
	final int buttonsCount = 4;

	public SideButtonPanel(Color color) {
		this.setLayout(new GridLayout(buttonsCount, 1));
		this.setPreferredSize(new Dimension(150, 100));
		this.setBackground(color);
	}
}
