/**
 * @author Jordan Campbell
 * A child of Weapon, weapons that extend Magic have this as their type.
 */
public abstract class Magic extends Weapon {
	public Magic(String name, int power, String description) {
		super(name, power, "Magic", description);
	}
	
	public String attack() {
		return "You cast the spell " + getName() + " at the enemy.";
	}
}
