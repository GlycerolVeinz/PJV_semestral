package goblinoverflow.entities;

import goblinoverflow.util.Coord;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static java.lang.System.exit;

/**
 * Entity class that holds most of the important information about the entities.
 */
public class Entity {
	private final String name;
	protected BufferedImage texture;
	private int x;
	private int y;

	/**
	 * Entity constructor.
	 *
	 * @param name Name of the entity.
	 * @param x    X coordinate of the entity.
	 * @param y    Y coordinate of the entity.
	 */
	public Entity(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Coord getCoord() {
		return new Coord(getX(), getY());
	}

	public void setCoord(Coord coord) {
		setX(coord.getX());
		setY(coord.getY());
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage image) {
		this.texture = image;
	}

	/**
	 * Fetches the texture of the entity from resources.
	 * Exits with exit status 100 if the texture is not found.
	 *
	 * @param name Name of the entity.
	 * @param mode Mode of fetch, ('t' - Tile/'c' - Creature).
	 */
	public void fetchEntityTexture(String name, char mode) {
		BufferedImage image;
		try {
			String source = "";
			switch (mode) {
				case 't':
					source = "/map/tiles/";
					break;
				case 'c':
					source = "/creatures/";
					break;
			}

			image = ImageIO.read(Objects.requireNonNull(getClass().getResource(source + name + ".png")));
			setTexture(image);
		} catch (IOException e) {
			System.err.println("Error loading tile image");
			e.printStackTrace();
			exit(100);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Entity)) return false;
		Entity entity = (Entity) o;
		return getX() == entity.getX() && getY() == entity.getY() && Objects.equals(getName(), entity.getName());
	}
}