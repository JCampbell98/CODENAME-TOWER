/**
 * @author Jordan Campbell
 * A child of Weapon, weapons that extend Slashing have this as their type.
 */
public abstract class Slashing extends Weapon {
	public Slashing(String name, int power, String description) {
		super(name, power, "Slashing", description);
	}
	
	public String attack() {
		return "You slash at the enemy with the " + getName() + ".";
	}
}
