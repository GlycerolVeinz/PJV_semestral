package goblinoverflow;

import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.tiles.Map;
import goblinoverflow.entities.tiles.Tile;
import goblinoverflow.gui.Interface;
import goblinoverflow.logic.movement.CreatureMover;
import goblinoverflow.logic.spawn.Spawner;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

/**
 * Simulation class is responsible for running the game.
 * It contains the main game loop. It can do so by being runnable.
 * Connects logic, gui and model.
 * It also has implementation of vsync of drawing frames.
 * <p>
 * @Interface gui
 * @Map model
 * @CreatureMover logic
 * </p>
 * @author glycerolveinz
 */
public class Simulation implements Runnable {
	private final static int mapTileWidth = 32;
	private final static int mapTileHeight = 24;
	private final static Map gameMap = new Map(getMapTileHeight(), getMapTileWidth());
	private final static Spawner spawner = new Spawner();
	private final static CreatureMover creatureMover = new CreatureMover();
	private static final ArrayList<Creature> creatures = new ArrayList<>();
	final String name;
	final static int framesPerSecond = 1;
	final static int timePerLoop = 1000000000 / framesPerSecond;
	private final Interface gui;
	private boolean isRunning;

	/**
	 * Simulation constructor.
	 * Sets simulation state to not running.
	 * Creates gui of the simulation.
	 *
	 * @param name name of the simulation.
	 *             Also name of the frame that will display the simulation.
	 */
	public Simulation(String name) {
		this.name = name;
		this.isRunning = false;
		this.gui = new Interface(name, gameMap, this);
	}

	public static ArrayList<Creature> getCreatures() {
		return creatures;
	}
	public static int getMapTileWidth() {
		return mapTileWidth;
	}
	public static int getMapTileHeight() {
		return mapTileHeight;
	}
	public static Map getGameMap() {
		return gameMap;
	}
	public Interface getGui() {
		return gui;
	}
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean running) {
		isRunning = running;
	}

	/**
	 * Method that finds all coordinates of empty tiles on the map.
	 *
	 * @param doors if true, it will also return coordinates of doors.
	 * @return ArrayList of coordinates of empty tiles.
	 */
	public static ArrayList<Coord> findEmptyTilesCoord(boolean doors) {
		ArrayList<Coord> emptyTiles = new ArrayList<>();
		for (int x = 0; x < getMapTileWidth(); x++) {
			for (int y = 0; y < getMapTileHeight(); y++) {
				if (getGameMap().getTile(x, y).getName().equals("floor") || (doors && getGameMap().getTile(x, y).getName().equals("door"))) {
					boolean isEmpty = true;
					for (Creature creature : getCreatures()) {
						if (creature.getX() == x && creature.getY() == y) {
							isEmpty = false;
							break;
						}
					}
					if (isEmpty) {
						emptyTiles.add(new Coord(x, y));
					}
				}
			}
		}
		return emptyTiles;
	}

	/**
	 * Method that finds all empty tiles on the map.
	 *
	 * @param doors if true, it will also return doors.
	 * @return ArrayList of empty tiles.
	 */
	public static ArrayList<Tile> findEmptyTiles(boolean doors) {
		ArrayList<Tile> emptyTiles = new ArrayList<>();
		for (Coord cord : findEmptyTilesCoord(doors)) {
			emptyTiles.add(getGameMap().getTile(cord.getX(), cord.getY()));
		}
		return emptyTiles;
	}

	/**
	 * Method that runs the simulation (main game loop).
	 */
	@Override
	public void run() {
		int iteration = 0;
		spawner.addGoblins(findEmptyTilesCoord(false));
		spawner.updateMap();
		while (true) {
			long start = System.nanoTime();

			if (isRunning) {
				update(iteration);
			}

			redraw();

			iteration = (iteration + 1) % (framesPerSecond * 10);

			long end = System.nanoTime();
			long elapsed = end - start;
			// manages fps vsync
			if (elapsed < timePerLoop) {
				try {
					Thread.sleep((timePerLoop - elapsed) / 1000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Update game logic.
	 *
	 * @param iteration number of iteration of the main game loop.
	 *                  (should be modulo of frames per second)
	 */
	private void update(int iteration) {
		if (iteration == 0) {
			spawner.updateMap();
		}
		creatureMover.moveAllCreatures();
	}

	/**
	 * Updates game dui.
	 */
	private void redraw() {
		gui.getGamePanel().repaint();
		gui.update();
	}
}
