/**
 * @author Jordan Campbell
 * All monsters use this as their base template.
 */
public abstract class Monster {
	//Constants and Variables
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int defense;
	private int attack;
	private String strength;
	private String weakness;
	
	/**
	 * All monsters require the following
	 * @param name The name of the monster.
	 * @param maxHealth The number of hits required to defeat this monster.
	 * @param defense The target number to deal damage to the monster.
	 * @param attack The additional damage the player takes if their attack misses.
	 * @param strength The type of attack this monster is strong against. Takes half damage.
	 * @param weakness The type of attack this monster is weak against. Takes double damage.
	 */
	public Monster(String name, int maxHealth, int defense, int attack, String strength, String weakness) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		this.defense = defense;
		this.attack = attack;
		this.strength = strength;
		this.weakness = weakness;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getDefense() {
		return defense;
	}

	public int getAttack() {
		return attack;
	}

	public String getStrength() {
		return strength;
	}

	public String getWeakness() {
		return weakness;
	}
	
	
	/**
	 * During battle, this will display at the start of the round
	 */
	public String toString() {
		return this.name + "\n"
				+ "Health: " + this.currentHealth + "/" + this.maxHealth + "\n"
				+ "Defense: " + this.defense + "\n"
				+ "Attack: " + this.attack;
	}
	
	
}
