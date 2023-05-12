package goblinoverflow.entities;

import goblinoverflow.gui.panels.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity
{
    private int x;
    private int y;

    private final String name;
    private static GamePanel gamePanel;

    public Entity(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d, BufferedImage image) {
//        TODO: draw entity
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}