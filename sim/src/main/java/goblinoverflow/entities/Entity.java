package goblinoverflow.entities;

import java.awt.Color;

public class Entity
{
    private int x;
    private int y;

    private String name;
    private char glyph;
    private Color color;

    public Entity(String name, int x, int y, char glyph, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.glyph = glyph;
        this.color = color;
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

    public char getGlyph() {
        return glyph;
    }

    public Color getColor() {
        return color;
    }
}