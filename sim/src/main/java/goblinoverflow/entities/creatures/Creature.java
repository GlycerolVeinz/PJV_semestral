package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;

import static java.lang.System.exit;

/**
 * Creature class that holds most of the important information about the creatures.
 * extends Entity class.
 * Checks loose and win conditions.
 */
public class Creature extends Entity {
	private static final int maxEntities = 7;
	private static final int maxGoblins = 15;
	private static int goblinCount = 0;
	private static int wolfCount = 0;
	private static int humanCount = 0;
	private static int zombieCount = 0;
	private static int skeletonCount = 0;
	private static int creatureCount = 0;
	private final CreatureType type;
	private Creature currentTarget;

	/**
	 * Creature constructor.
	 * Increases creatureCount,
	 * checks game status, loose condition.
	 *
	 * @param type Type of the creature.
	 * @param x    X coordinate of the creature.
	 * @param y    Y coordinate of the creature.
	 */
	public Creature(CreatureType type, int x, int y) {
		super(type.getName(), x, y);
		this.type = type;
		if (creatureCount >= maxEntities) {
			System.err.println("Max entities reached");
			throw new RuntimeException("Max entities reached");
		}
		switch (type) {
			case WOLF:
				wolfCount++;
				break;
			case HUMAN:
				humanCount++;
				break;
			case ZOMBIE:
				zombieCount++;
				break;
			case SKELETON:
				skeletonCount++;
				break;
			case GOBLIN:
				goblinCount++;
				if (goblinCount > maxGoblins) {
					System.out.println("GOBLIN OVERFLOW");
					exit(0);
				}
				break;
			default:
				break;
		}
		creatureCount = wolfCount + humanCount + zombieCount + skeletonCount;
		fetchEntityTexture(type.getName(), 'c');
	}

	public static int getGoblinCount() {
		return goblinCount;
	}

	public static int getWolfCount() {
		return wolfCount;
	}

	public static int getHumanCount() {
		return humanCount;
	}

	public static int getZombieCount() {
		return zombieCount;
	}

	public static int getSkeletonCount() {
		return skeletonCount;
	}

	public Creature getCurrentTarget() {
		return currentTarget;
	}

	public void setCurrentTarget(Creature currentTarget) {
		this.currentTarget = currentTarget;
	}

	public CreatureType getType() {
		return type;
	}

	/**
	 * Creature "destructor".
	 * Decreases creatureCount,
	 * checks game status, win condition.
	 *
	 * @param creature Type of the creature.
	 */
	public static void creatureDied(CreatureType creature) {
		switch (creature) {
			case WOLF:
				wolfCount--;
				break;
			case HUMAN:
				humanCount--;
				break;
			case ZOMBIE:
				zombieCount--;
				break;
			case SKELETON:
				skeletonCount--;
				break;
			case GOBLIN:
				goblinCount--;
				break;
			default:
				break;
		}
		if (goblinCount == 0) {
			System.out.println("YOU WIN");
			exit(0);
		}
		creatureCount = wolfCount + humanCount + zombieCount + skeletonCount;
	}
}