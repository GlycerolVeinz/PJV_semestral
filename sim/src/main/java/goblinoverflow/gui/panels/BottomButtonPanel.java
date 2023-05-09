package goblinoverflow.gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class BottomButtonPanel extends JPanel
{
    final int buttonsCount = 8;

    public BottomButtonPanel(Color color)
    {
        this.setLayout(new GridLayout(1, buttonsCount));
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(color);
    }
}
