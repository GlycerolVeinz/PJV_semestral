package goblinoverflow.entities;

import goblinoverflow.gui.panels.GamePanel;

import java.awt.*;

public class Entity
{
    private int x;
    private int y;

    private String name;
    private static GamePanel gamePanel;

    public Entity(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d) {
//        TODO: draw entity
    }

    public void update() {
//        TODO: update entity
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

    public void moveBy(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}