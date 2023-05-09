package goblinoverflow.gui;

import goblinoverflow.gui.panels.*;


import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame
{
    private GamePanel gamePanel;
    private BottomButtonPanel bottomButtonPanel;
    private SideButtonPanel sideButtonPanel;
    private SideStatsPanel SideStatsPanel;

    final Color sidePanelsColor = Color.DARK_GRAY;

    public Interface(String title)
    {
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        this.gamePanel = new GamePanel();
        window.add(gamePanel, BorderLayout.CENTER);

        this.bottomButtonPanel = new BottomButtonPanel(sidePanelsColor);
        window.add(bottomButtonPanel, BorderLayout.SOUTH);

        this.sideButtonPanel = new SideButtonPanel(sidePanelsColor);
        window.add(sideButtonPanel, BorderLayout.EAST);

        this.SideStatsPanel = new SideStatsPanel(sidePanelsColor);
        window.add(SideStatsPanel, BorderLayout.WEST);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
