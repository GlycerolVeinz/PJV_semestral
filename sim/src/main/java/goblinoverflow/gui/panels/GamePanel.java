package goblinoverflow.gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel{

    final int tileSize = 16;

    final int mapTileWidth = 32;
    final int mapTileHeight = 24;

    final int panelWidth = mapTileWidth * tileSize;
    final int panelHeight = mapTileHeight * tileSize;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(10,10, this.tileSize, this.tileSize);
        g2d.dispose();
    }
}
