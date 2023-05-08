package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;

import java.awt.*;

public class Creature extends Entity
{
    public Creature(String name, int x, int y, char glyph, Color color) {
        super(name, x, y, glyph, color);
    }

    public void moveBy(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}