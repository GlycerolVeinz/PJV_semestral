package goblinoverflow.gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel{

    private final int tileSize = 16;

    private final int mapTileWidth = 32;
    private final int mapTileHeight = 24;

    final int panelWidth = mapTileWidth * tileSize;
    final int panelHeight = mapTileHeight * tileSize;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMapTileWidth() {
        return mapTileWidth;
    }

    public int getMapTileHeight() {
        return mapTileHeight;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.dispose();
    }
}

