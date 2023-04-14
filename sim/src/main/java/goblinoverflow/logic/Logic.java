package goblinoverflow.logic;

import goblinoverflow.Simulation;
import goblinoverflow.entities.Entity;
import goblinoverflow.maps.Maps;

/**
 * Logic
 */
public class Logic {
    private int currentTime;
    private Simulation sim;

    public Logic(Simulation sim) {
        this.sim = sim;
        this.currentTime = 0;
    }

    public void tickTimer() {
        this.currentTime++;
    }

    public void addEntity(Entity entity) {
        sim.getMaps().addEntity(entity);
    }
}