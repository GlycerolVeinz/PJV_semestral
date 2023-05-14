package goblinoverflow.gui.panels;

import goblinoverflow.Simulation;
import goblinoverflow.entities.Entity;
import goblinoverflow.entities.tiles.Map;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{

    private static final int tileSize = 16;

    private final int mapTileWidth = Simulation.getMapTileWidth();
    private final int mapTileHeight = Simulation.getMapTileHeight();

    final int panelWidth = mapTileWidth * tileSize;
    final int panelHeight = mapTileHeight * tileSize;

    private ArrayList<Entity> entities = new ArrayList<>();

    private final Map gameMap;

    public GamePanel(Map gameMap)
    {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);
        this.gameMap = gameMap;
    }

    private void drawMap(Graphics2D g2d) {
        for (int y = 0; y < getMapTileHeight(); ++y) {
            for (int x = 0; x < getMapTileWidth(); ++x) {
                g2d.drawImage(gameMap.getTile(x, y).getTexture(), x * getTileSize(), y * getTileSize(), null);
            }
        }
    }

    public static int getTileSize() {
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
        drawMap(g2d);


        g2d.dispose();
    }
}

