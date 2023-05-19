package goblinoverflow;

import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.tiles.Map;
import goblinoverflow.gui.Interface;
import goblinoverflow.logic.movement.CreatureMover;
import goblinoverflow.logic.spawn.Spawner;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

public class Simulation implements Runnable {
	private final static int mapTileWidth = 32;
	private final static int mapTileHeight = 24;
	private final static Map gameMap = new Map(getMapTileHeight(), getMapTileWidth());
	private final static Spawner spawner = new Spawner();
	private final static CreatureMover creatureMover = new CreatureMover();
	private static ArrayList<Creature> creatures = new ArrayList<>();
	final String name;
	final int framesPerSecond = 1;
	final int timePerLoop = 1000000000 / framesPerSecond;
	private final Interface gui;
	private boolean isRunning;

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

	public static ArrayList<Coord> findEmptyTiles() {
		ArrayList<Coord> emptyTiles = new ArrayList<>();
		for (int x = 0; x < getMapTileWidth(); x++) {
			for (int y = 0; y < getMapTileHeight(); y++) {
				if (getGameMap().getTile(x, y).getName().equals("floor")) {
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

	public Interface getGui() {
		return gui;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean running) {
		isRunning = running;
	}

	@Override
	public void run() {
		int iteration = 0;
		spawner.addGoblins(findEmptyTiles());
		spawner.updateMap();
		while (true) {
			long start = System.nanoTime();

			if (isRunning) {
				update(iteration);
			}

			redraw();


			iteration = (iteration + 1) % 600; //every 10 seconds

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

	private void update(int iteration) {
		if (iteration == 0) {
			spawner.updateMap();
		}
		creatureMover.moveAllCreatures();
	}

	private void redraw() {
		gui.repaint();
		gui.getGamePanel().repaint();
	}
}
