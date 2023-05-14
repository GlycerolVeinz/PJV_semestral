package goblinoverflow.entities.tiles;

import goblinoverflow.entities.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static java.lang.System.exit;

public class Tile extends Entity {
	private BufferedImage texture;

	public Tile(String name, int x, int y) throws IOException{
		super(name, x, y);

		getTileImage(name);
	}
	public void getTileImage(String name) {
		BufferedImage image;
		try {
			image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/map/tiles/" + name + ".png")));
			setTexture(image);
		} catch (IOException e) {
			System.err.println("Error loading tile image");
			e.printStackTrace();
			exit(100);
		}
	}

	public void setTexture(BufferedImage image) {
		this.texture = image;
	}

	public BufferedImage getTexture() {
		return texture;
	}
}
