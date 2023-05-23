package goblinoverflow.entities.creatures;

import goblinoverflow.entities.Entity;

import static java.lang.System.exit;

public class Creature extends Entity {
	private static final int maxEntities = 7;
	private static final int maxGoblins = 15;
	private static int goblinCount = 0;
	private static int wolfCount = 0;
	private static int humanCount = 0;
	private static int zombieCount = 0;
	private static int skeletonCount = 0;
	private static int creatureCount = 0;

	private Creature currentTarget;
	private CreatureType type;

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
		getEntityTexture(type.getName(), 'c');
	}


	public Creature getCurrentTarget() {
		return currentTarget;
	}

	public void setCurrentTarget(Creature currentTarget) {
		this.currentTarget = currentTarget;
	}

	public void moveBy(int dx, int dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public static void creatureDied(CreatureType creature){
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
		if (goblinCount == 0){
			System.out.println("YOU WIN");
			exit(0);
		}
		creatureCount = wolfCount + humanCount + zombieCount + skeletonCount;
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

	public CreatureType getType() {
		return type;
	}
}