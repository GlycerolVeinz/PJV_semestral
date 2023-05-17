package goblinoverflow;

import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.tiles.Map;
import goblinoverflow.gui.Interface;
import goblinoverflow.logic.spawn.Spawner;
import goblinoverflow.util.Coord;

import java.util.ArrayList;

public class Simulation implements Runnable {
	final String name;
	private boolean isRunning;
	final int framesPerSecond = 60;
	final int timePerLoop = 1000000000 / framesPerSecond;
	private final static int mapTileWidth = 32;
	private final static int mapTileHeight = 24;
	private final static Map gameMap = new Map(getMapTileHeight(), getMapTileWidth());
	private static ArrayList<Creature> creatures = new ArrayList<>();
	private final static Spawner spawner = new Spawner();

	public static ArrayList<Creature> getCreatures() {
		return creatures;
	}

	private final Interface gui;

	public Simulation(String name) {
		this.name = name;
		this.isRunning = false;
		this.gui = new Interface(name, gameMap, this);
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


	@Override
	public void run() {
		int iteration = 0;
		while (true) {
			long start = System.nanoTime();

			if (isRunning) {
				update(iteration);
			}

			redraw();


			iteration = (iteration + 1) % 60;

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
		if (iteration == 0){
			spawner.updateMap();
		}
	}

	private void redraw() {
		gui.repaint();
		gui.getGamePanel().repaint();
	}
}
