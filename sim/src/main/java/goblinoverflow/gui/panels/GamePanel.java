package goblinoverflow.gui.panels;

import goblinoverflow.entities.Entity;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{

    private static final int tileSize = 16;

    private static final int mapTileWidth = 32;
    private static final int mapTileHeight = 24;

    final int panelWidth = mapTileWidth * tileSize;
    final int panelHeight = mapTileHeight * tileSize;

    private ArrayList<Entity> entities = new ArrayList<>();

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);
    }

    public static int getTileSize() {
        return tileSize;
    }

    public static int getMapTileWidth() {
        return mapTileWidth;
    }

    public static int getMapTileHeight() {
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

