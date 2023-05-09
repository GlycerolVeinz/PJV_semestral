package goblinoverflow.gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class SideButtonPanel extends JPanel{
    final int buttonsCount = 4;

    public SideButtonPanel()
    {
        this.setLayout(new GridLayout(buttonsCount, 1));
        this.setPreferredSize(new Dimension(150, 100));
        this.setBackground(Color.DARK_GRAY);
    }
}
