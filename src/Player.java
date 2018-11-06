import java.util.ArrayList;
import java.util.Random;

public class Player {
	/**
	 * @author Jordan Campbell
	 * 
	 * This class contains all the basics of the player's character.
	 * 
	 */
	
	//Constants and Variables
	private String name;
	private int floor;
	private int maxHealth;
	private int currentHealth;
	private int[] healthTable = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};
	
	/**
	 * This ArrayList stores the weapons the player gets
	 */
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	
	/** Weapon pool for floor's 1.*/
	private Weapon[] weaponPoolA = {
		new MagicA(), new PierceA(), new SlashA()
	};
	
	/** Weapon pool for floor's 2.*/
	private Weapon[] weaponPoolB = {
		new MagicA(), new PierceA(), new SlashA(), new MagicB(), new PierceB(), new SlashB()
	};
	
	/** Weapon pool for floor's 4.*/
	private Weapon[] weaponPoolC = {
		new MagicB(), new PierceB(), new SlashB(), new MagicC(), new PierceC(), new SlashC()
	};
	
	/** Weapon pool for floor's 5.*/
	private Weapon[] weaponPoolD = {
		new MagicC(), new PierceC(), new SlashC(), new MagicD(), new PierceD(), new SlashD()
	};
	
	/** Weapon pool for floor's 7.*/
	private Weapon[] weaponPoolE = {
		new MagicD(), new PierceD(), new SlashD(), new MagicE(), new PierceE(), new SlashE()
	};
	
	/** Weapon pool for floor's 8.*/
	private Weapon[] weaponPoolF = {
		new MagicE(), new PierceE(), new SlashE(), new MagicF(), new PierceF(), new SlashF()
	};
	
	/** Weapon pool for floor's 10.*/
	private Weapon[] weaponPoolG = {
		new MagicF(), new PierceF(), new SlashF(), new MagicG(), new PierceG(), new SlashG()
	};
	
	/** Weapon pool for floor's 11.*/
	private Weapon[] weaponPoolH = {
		new MagicG(), new PierceG(), new SlashG(), new MagicH(), new PierceH(), new SlashH()
	};
	
	/** Weapon pool for floor's 13.*/
	private Weapon[] weaponPoolI = {
		new MagicH(), new PierceH(), new SlashH(), new MagicI(), new PierceI(), new SlashI()
	};
	
	/** Weapon pool for floor's 14.*/
	private Weapon[] weaponPoolJ = {
		new MagicI(), new PierceI(), new SlashI(), new MagicJ(), new PierceJ(), new SlashJ()
	};
	
	/**
	 * This constructor requires the input of a name for the character.
	 * When run, it sets the name to the name input.
	 * It also sets the current floor to 1, as well as the players max and current health for floor 1.
	 * Finally, it gives the player a wooden sword as a starting weapon.
	 */
	public Player(String name) {
		this.name = name;
		this.floor = 1;
		this.maxHealth = healthTable[(floor-1)];
		this.currentHealth = this.maxHealth;
		weapons.add(new SlashA());
	}

	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth() {
		this.maxHealth = this.healthTable[(this.floor-1)];
	}

	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public String getName() {
		return name;
	}
	
	/** This custom getter sends the selected weapon to the main game for use in combat. */
	public Weapon getWeapon(int i) {
		return weapons.get(i);
	}
	
	/** This custom getter gets the number of weapons the player has */
	public int getNumWeapons() {
		return weapons.size();
	}
	
	/**
	 * This custom getter gets a monster based on the provided info
	 * @param pool Which pool to pull a monster from. 1-5 for standard enemies, 6 for a boss.
	 * @param index The slot of the monster. Ranges from 0 to 2 for standard, 0-4 for bosses.
	 * @return Returns the selected monster or boss.
	 */
	public Monster getMonster(int pool, int index) {
		/**
		 * These arraylists store the monsters the player can fight
		 */
		/** Monster pool for floor's 1-2 */
		Monster[] monsterPoolA = {
				new Monster1A(), new Monster1B(), new Monster1C()
		};
		
		/** Monster pool for floor's 3-5. Floor 4 only uses 1 monster before the boss */
		Monster[] monsterPoolB = {
				new Monster2A(), new Monster2B(), new Monster2C()
		};
		
		/** Monster pool for floor's 6-8. Floor 8 only uses 1 monster before the boss */
		Monster[] monsterPoolC = {
				new Monster3A(), new Monster3B(), new Monster3C()
		};
		
		/** Monster pool for floor's 9-10 */
		Monster[] monsterPoolD = {
				new Monster4A(), new Monster4B(), new Monster4C()
		};
		
		/** Monster pool for floor's 11-13 Floor 12 doesn't use any monsters */
		Monster[] monsterPoolE = {
				new Monster5A(), new Monster5B(), new Monster5C()
		};
		
		/** Boss Pool. Stores the bosses on floor's 4, 8, 12, 14, and 15 */
		Monster[] bossPool = {
			new BossF4(), new BossF8(), new BossF12(), new BossF14(), new BossF15()	
		};
		
		switch(pool) {
			case 1:
				return monsterPoolA[index];
			case 2:
				return monsterPoolB[index];
			case 3:
				return monsterPoolC[index];
			case 4:
				return monsterPoolD[index];
			case 5:
				return monsterPoolE[index];
			case 6:
				return bossPool[index];
			default:
				return monsterPoolA[index];
		}
	}
	
	/**
	 * When this method is run, it triggers the health and floor increases of "leveling up"
	 */
	public void levelUp() {
		this.floor++;
		this.maxHealth = healthTable[(floor-1)];
		this.currentHealth = this.maxHealth;
	}
	
	/**
	 * This method has a chance of giving a player a new item depending on their current floor.
	 */
	public void giveItem(Random rng) {
		boolean found = false;
		int itemSlot;
		Weapon item = null;
		
		/*
		 * If the player is on the first or second floor, grab a number from 0-2. Otherwise, grab one from 0-6.
		 * This is to make sure on the first two floors that it doesn't try and grab an item that doesn't exist
		 */
		if(this.floor <= 1) {
			itemSlot = rng.nextInt(3);
		} else {
			itemSlot = rng.nextInt(6);
		}
		/*
		 * Depending on the floor the player is on, grab an item from a different item pool.
		 */
		switch(this.floor) {
			case 1:
				//Floor 1
				item = weaponPoolA[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 2:
				//Floor 2
				item = weaponPoolB[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 3:
			case 4:
				//Floors 3 and 4
				item = weaponPoolC[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 5:
				//Floor 5
				item = weaponPoolD[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 6:
				//Floor 6
				item = weaponPoolE[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 7:
			case 8:
				//Floors 7 and 8 
				item = weaponPoolF[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 9:
				//Floor 9
				item = weaponPoolG[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 10:
				//Floor 10
				item = weaponPoolH[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 11:
			case 12:
				//Floors 11 and 12
				item = weaponPoolI[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			case 13:
			case 14:
				//Floors 13 and 14
				item = weaponPoolJ[itemSlot];
				System.out.println(this.name + " found (" + item.getName() + "), a " + item.getType() + " weapon!");
				break;
			default:
				//This should only happen on the 15th floor, since there's no items to grab.
				item = null;
				break;
		}
		if (item != null) {
			for (int i=0; i < weapons.size(); i++) {
				if(item.getClass() == (weapons.get(i).getClass())) {
					found = true;
				}
			}
			if (!found) {
				weapons.add(item);
				System.out.println(name + " added it to their inventory.");
			} else {
				System.out.println(name + " already has this weapon, so they toss it to the side.");
			}
		}
	}
	
	/**
	 * This method displays the weapons in the player's inventory.
	 * This runs at the start of each turn
	 */
	public void displayInventory() {
		Weapon weapon;
		System.out.println("Weapons:");
		for(int i=0; i < weapons.size(); i++) {
			weapon = weapons.get(i);
			System.out.println("--------------------------------------------------");
			System.out.println(i + ") | " + weapon);
		}
	}
	
	/**
	 * The toString method will display the player's stats alongside the enemies during combat.
	 */
	public String toString() {
		return this.name +  "\n"
				+ "Health: " + this.currentHealth + "/" + this.maxHealth;
	}
}
