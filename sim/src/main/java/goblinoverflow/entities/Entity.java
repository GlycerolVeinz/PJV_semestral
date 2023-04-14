package goblinoverflow.entities;

/**
 * Entity
 */
public class Entity {
    private int HP;
    private int maxHP;
    private char look;
    private boolean living;

    public Entity(int maxHP, char look) {
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.look = look;
        this.living = true;
    }

    public void pathing() {
        // entity pathing logic
    }
}