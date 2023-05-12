package goblinoverflow;

import goblinoverflow.gui.Interface;

public class Simulation implements Runnable {
	final String name;
	final int framesPerSecond = 60;
	final int timePerLoop = 1000000000 / framesPerSecond;
	private final Interface gui;
	private boolean isRunning;


	public Simulation(String name) {
		this.name = name;
		this.isRunning = false;
		this.gui = new Interface(name);
	}

	public Interface getGui() {return gui;}

	@Override
	public void run() {
		isRunning = true;

		while (isRunning) {
			long start = System.nanoTime();

			update();

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

	private void redraw(){
		gui.repaint();
	}
}
