package goblinoverflow.entities.creatures;

/**
* Enum class for Creature names.
* */
public enum CreatureType {
	GOBLIN("goblin"),
	GOLD("gold"),
	HUMAN("human"),
	WOLF("wolf"),
	ZOMBIE("zombie"),
	SKELETON("skeleton");

	private final String name;

	CreatureType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
