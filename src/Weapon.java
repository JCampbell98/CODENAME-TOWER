/**
 * @author Jordan Campbell
 * This is the base template used by all weapons.
 * Any item that is considered a weapon will extend this class.
 */
public abstract class Weapon {
	//Constants and Variables
	private String name;
	private int power;
	private String type;
	private String description;
	
	/**
	 * All child classes must provide the following information
	 * @param name The name of the weapon
	 * @param power The weapon's power. This number is added onto the d20 roll
	 * @param type The weapon's type. All monsters are strong against 1 type and weak against another.
	 * @param description A description of the weapon. Must be provided by each UNIQUE weapon
	 */
	public Weapon(String name, int power, String type, String description) {
		this.name = name;
		this.power = power;
		this.type = type;
		this.description = description;
	}
	
	/*
	 * Once a weapon is created, it is impossible to change it's name, power, or type.
	 * It is only possible to get the name power and type.
	 */
	public String getName() {
		return name;
	}
	public int getPower() {
		return power;
	}
	public String getType() {
		return type;
	}
	
	/**
	 * Each weapon type is required to provide how it attacks.
	 * As such, an "attack()" method is required
	 */
	public abstract String attack();
	
	/**
	 * When the weapon list is displayed, each weapon will display like this
	 */
	public String toString() {
		return this.name + "\t| " + "Power: " + this.power + "\t| " + this.type + "\n"
				+ this.description;
	}
}
