package goblinoverflow;

import goblinoverflow.entities.creatures.Creature;
import goblinoverflow.entities.tiles.Map;
import goblinoverflow.gui.Interface;

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

	@Override
	public void run() {
		while (true) {
			long start = System.nanoTime();

			if (isRunning) {
				update();
			}

			redraw();

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

	private void update() {
//	TODO implement update
	}

	private void redraw() {
		gui.repaint();
		gui.getGamePanel().repaint();
	}
}
