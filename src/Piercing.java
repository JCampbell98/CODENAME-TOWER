/**
 * @author Jordan Campbell
 * A child of Weapon, weapons that extend Piercing have this as their type.
 */
public abstract class Piercing extends Weapon {
	public Piercing(String name, int power, String description) {
		super(name, power, "Piercing", description);
	}
	
	public String attack() {
		return "You jab the " + getName() + " at the enemy.";
	}
}