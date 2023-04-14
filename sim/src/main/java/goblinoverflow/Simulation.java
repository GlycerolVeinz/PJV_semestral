package goblinoverflow;

import goblinoverflow.logic.Logic;
import goblinoverflow.maps.Maps;

/**
 * Simulation
 */
public class Simulation {
    private int EntityCount;
    private int maxEntityCount;
    private Maps maps;
    private Logic logic;

    public Simulation(int maxEntityCount) {
        this.EntityCount = 0;
        this.maxEntityCount = maxEntityCount;
        this.maps = new Maps(50);
        this.logic = new Logic(this);
    }

    public void close_simulation() {
        // close simulation logic
    }

    public void run_simulation() {
        // run simulation logic
    }

    public void save_game() {
        // save game logic
    }

    public void load_game() {
        // load game logic
    }

    public Maps getMaps() {
        return maps;
    }
}