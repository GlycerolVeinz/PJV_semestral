package goblinoverflow.gui;

import goblinoverflow.Simulation;
import goblinoverflow.entities.tiles.Map;
import goblinoverflow.gui.panels.*;


import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame
{
    private final GamePanel gamePanel;
    private final BottomButtonPanel bottomButtonPanel;
    private final SideButtonPanel sideButtonPanel;
    private final SideStatsPanel SideStatsPanel;

    final Color sidePanelsColor = Color.DARK_GRAY;

    public Interface(String title, Map gameMap, Simulation sim)
    {
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        this.gamePanel = new GamePanel(gameMap);
        window.add(gamePanel, BorderLayout.CENTER);

        this.bottomButtonPanel = new BottomButtonPanel(sidePanelsColor);
        window.add(bottomButtonPanel, BorderLayout.SOUTH);

        this.sideButtonPanel = new SideButtonPanel(sidePanelsColor, sim);
        window.add(sideButtonPanel, BorderLayout.EAST);

        this.SideStatsPanel = new SideStatsPanel(sidePanelsColor);
        window.add(SideStatsPanel, BorderLayout.WEST);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
