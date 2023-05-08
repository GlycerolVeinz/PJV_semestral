package goblinoverflow.gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel{

    final int tileSize = 16;

    final int mapTileWidth = 60;
    final int mapTileHeight = 45;
    final int mapWidth = mapTileWidth * tileSize;
    final int mapHeight = mapTileHeight * tileSize;

    public GamePanel(){
        this.setPreferredSize(new Dimension(mapWidth, mapHeight));
        this.setBackground(Color.BLACK);
    }

}
