package goblinoverflow.entities;

import goblinoverflow.gui.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static java.lang.System.exit;

public class Entity
{
    private int x;
    private int y;

    protected BufferedImage texture;
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

    public void getEntityTexture(String name, char mode) {
        BufferedImage image;
        try {
            String source = "";
            switch (mode)
            {
                case 't':
                    source = "/map/tiles/";
                    break;
                case 'c':
                    source = "/creatures/";
                    break;
            }

            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/map/tiles/" + name + ".png")));
            setTexture(image);
        } catch (IOException e) {
            System.err.println("Error loading tile image");
            e.printStackTrace();
            exit(100);
        }
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

    public void setTexture(BufferedImage image) {
        this.texture = image;
    }
    public BufferedImage getTexture() {
        return texture;
    }
}