import java.util.Random;
import java.util.Scanner;

/**
 * @author Jordan Campbell
 * 
 * This is the main method for the whole game. 
 */
public class Game {
	public static void main(String[] args) {
		//Activate the needed tools
		Scanner input = new Scanner(System.in);
		Random rng = new Random();
		
		//Activate the cutscene class
		Cutscene play = new Cutscene();
		
		//Constants and variables
		char userInput = 0;	//Stores user input
		String playerName;	//Stores the name the player enters at the start for debugging
		Monster enemy;		//Stores the current enemy
		int i;				//Index for getting enemies
		
		//Display the title screen, and ask the player to enter a name
		play.TitleScreen();
		do {
			System.out.print("Please enter a name: ");
			playerName = input.nextLine();
		} while (playerName.isEmpty());
		Player player = new Player(playerName);
		
		//Display the menu asking the player if they want to play the tutorial
		tutorialMenu(player, input, play);
		
		/**
		 * This loop contains the main bulk of the game.
		 * As long as the user doesn't quit the game (Q), the loop will continue.
		 */
		do {
			//Check the current floor
			switch(player.getFloor()) {
				case 4:		//Player is on floor 4, do a normal fight, then the boss, then level up.
					//Grab a random monster for the floor's only fight.
					i = rng.nextInt(3);
					enemy = player.getMonster(2, i);
					
					//Play the floor 4 cutscene and start a fight
					play.Floor4(player, input);
					fight(player, input, rng, enemy);
					
					//Check if the player died. If they did, abandon game.
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					//If they live, grab the floor 4 boss, play their cutscene, and start the fight
					enemy = player.getMonster(6, 0);
					play.Boss1A(player, input);
					fight(player, input, rng, enemy);
					
					//Check if the player died
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					//If they live, play the cutscene and level up the player
					play.Boss1B(player, input);
					player.levelUp();
					break;
				case 8:		//Player is on floor 8, do a normal fight, then the boss, then level up.
					//Grab a random monster for the generic fight
					i = rng.nextInt(3);
					enemy = player.getMonster(3, i);
					
					//Play the floor 8 cutscene and start a fight
					play.Floor8(player, input);
					fight(player, input, rng, enemy);
					
					//Check if the player died. If they did, abandon game.
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					//If they live, grab the floor 8 boss, play their cutscene, and start the fight
					enemy = player.getMonster(6, 1);
					play.Boss2A(player, input);
					fight(player, input, rng, enemy);
					
					//Check if the player died
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					//If they live, play the cutscene and level up the player
					play.Boss2B(player, input);
					player.levelUp();
					break;
				case 12:	//Player is on floor 12, do just the boss, then level up.
					//Play the cutscenes, then start a modified version of the fight method
					enemy = player.getMonster(6, 2);
					play.Floor12(player, input);
					play.Boss3(player, input);
					fightBoss3(player, input, rng, enemy);
					
					//Check if the player died
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					/*
					 * If they live, level them up.
					 * The end of boss cutscene goes stright into floor 13
					 * The cutscene handler will play it.
					 */
					player.levelUp();
					break;
				case 14:	//Player is on floor 14, do just the boss, then level up.
					//Play the cutscene, then start the boss fight
					enemy = player.getMonster(6, 3);
					play.Boss4(player, input);
					fight(player, input, rng, enemy);
					
					//Check if the player died
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					//If they live, play the cutscene and level them up.
					play.Floor14End(player, input);
					player.levelUp();
					break;
				case 15:	//Player is on floor 15, do the final boss, then end the game.
					//PLOT TIME! Play the cutscene for starting floor 15.
					play.Floor15Start(player, input);
					
					//Set the enemy to the final boss, play the boss intro and start the fight
					//The final boss has it's own special battle method for it's mechanics
					enemy = player.getMonster(6, 4);
					play.Boss5(player, input);
					fightFinal(player, input, rng, enemy);
					
					//Check if the player died
					if(player.getCurrentHealth() <= 0) {
						play.GameOver(player, input);
						userInput = 'Q';
						break;
					}
					
					//If they are alive, VICTORY! Play the final cutscenes before ending the game.
					play.Floor15End(player, input);
					play.Ending(player, input);
					play.Credits(input);
					userInput = 'Q';
					break;
				default:	//Non-boss floor, grab a cutscene and do the fight loop
					
					//Start of the floor, run the cutscene handler
					handleCutscene(player, input, play);
					
					//Run the standard floor's loop
					do {
						i = rng.nextInt(3);
						switch (player.getFloor()) {
							case 1:
							case 2:		//Encounters for floor's 1 and 2
								enemy = player.getMonster(1, i);	//Grab a monster from the first pool
								break;
							case 3:		//Encounters for floor's 3 and 5.
							case 5:
								enemy = player.getMonster(2, i);	//Grab a monster from the second pool
								break;
							case 6:
							case 7:		//Encounters for floor's 6 and 7
								enemy = player.getMonster(3, i);	//Grab a monster from the third pool
								break;
							case 9:
							case 10:		//Encounters for floor's 9 and 10
								enemy = player.getMonster(4, i);	//Grab a monster from the fourth pool
								break;
							case 11:
							case 13:	//Encounters for floor's 11 and 13
								enemy = player.getMonster(5, i);	//Grab a monster from the fifth pool
								break;
							default:	//In the event of an error, throw something from the first floor at them
								enemy = player.getMonster(1, i);
								break;
						}
						fight(player, input, rng, enemy);
						
						if(player.getCurrentHealth() > 0) {
							//Display this menu after the battle ends
							userInput = exploreMenu(player, input, play);
							switch(userInput) {
								case 'E':
									System.out.println("You open a nearby door, and continue into the next room.");
									break;
								case 'N':
									player.levelUp();
									break;
							}
						} else {
							play.GameOver(player, input);
							userInput = 'Q';
						}
					} while (userInput != 'Q' && userInput != 'N');
				break;
			}
		} while (userInput != 'Q');
		System.out.println("Ending Game...");
		input.close();
	}
	
	/**
	 * This menu asks the player if they want to do the tutorial
	 */
	public static void tutorialMenu(Player player, Scanner input, Cutscene play) {
		//Constants and Variables
		char userInput;	//Stores single character inputs from the user
		
		do {
			System.out.println("--------------------------------------------------");
			System.out.println("Would you like to view a tutorial on how to play the game?");
			System.out.print("Please enter an option (Y/N) ");
			userInput = java.lang.Character.toUpperCase(input.nextLine().charAt(0));
			switch(userInput) {
				case 'Y':	//Player wants the tutorial, play the tutorial
					play.Tutorial(player, input, player.getMonster(1, 0));
					break;
				case 'N':	//Player doesn't want the tutorial, exit the menu
					System.out.println("If you say so. Let's get to the story!");
					break;
				default:	//Player entered incorrect option
					System.out.println("I don't understand that. Enter Y to do the tutorial or X to skip it.");
					break;
			}
		} while(userInput != 'Y' && userInput != 'N');
	}
	
	/**
	 * This menu asks the player if they want to explore the current floor, go to the next floor, or quit the game.
	 * @return char of either E (Explore), N (Next), or Q (Quit)
	 */
	public static char exploreMenu(Player player, Scanner input, Cutscene play) {
		char userInput = 0;
		do {
			try {
				System.out.println("--------------------------------------------------");
				System.out.println("What would you like to do?\n"
								 + "(E) Explore the current floor\n"
								 + "(N) Next Floor\n"
								 + "(Q) Quit the game\n");
				System.out.print("Please make a selection: ");
				userInput = java.lang.Character.toUpperCase(input.nextLine().charAt(0));
				if(userInput != 'E' && userInput != 'N' && userInput != 'Q') {
					System.out.println("I don't understand that. Please enter E, N, or Q.");
				}
			} catch (java.lang.StringIndexOutOfBoundsException e) {
				System.out.println("I don't understand that. Please enter E, N, or Q.");
			}
		} while (userInput != 'E' && userInput != 'N' && userInput != 'Q');
		return userInput;
	}
	
	/**
	 * This method handles playing cutscenes for all the non-boss floors.
	 * @param player
	 * @param input
	 * @param play
	 */
	public static void handleCutscene(Player player, Scanner input, Cutscene play) {
		switch(player.getFloor()) {
			case 1:
				play.Floor1(player, input);
				break;
			case 2:
				play.Floor2(player, input);
				break;
			case 3:
				play.Floor3(player, input);
				break;
			case 5:
				play.Floor5(player, input);
				break;
			case 6:
				play.Floor6(player, input);
				break;
			case 7:
				play.Floor7(player, input);
				break;
			case 9:
				play.Floor9(player, input);
				break;
			case 10:
				play.Floor10(player, input);
				break;
			case 11:
				play.Floor11(player, input);
				break;
			case 13:
				play.Floor13(player, input);
				break;
		}
	}
	
	/**
	 * This method handles the battle mechanics for a normal battle. 
	 * @param player
	 * @param input
	 * @param rng
	 */
	public static void fight(Player player, Scanner input, Random rng, Monster enemy) {
		int playerInput;	//The input for the weapon the player picks
		Weapon weapon;		//Stores the weapon for calculations
		int bonus;			//The random bonus to the attack, from 1 to 20
		int totalPower;		//The total power behind the attack
		int damageDelt;		//The total damage delt, either to the player or monster.
		
		do {	//Run the battle while the player and enemy are both alive
			//Display the enemy's stats
			System.out.println("--------------------------------------------------");
			System.out.println(enemy);
			
			//Display the player's stats
			System.out.println("--------------------------------------------------");
			System.out.println(player);
			
			//Text Rest
			System.out.println("--------------------------------------------------");
			System.out.println("");
			System.out.print("Press ENTER to continue...");
			input.nextLine();
			
			//Display the player's inventory
			System.out.println("--------------------------------------------------");
			player.displayInventory();
			
			//Ask the user to select a weapon from their inventory
			System.out.println("--------------------------------------------------");
			System.out.print("Please select a weapon: (#) ");
			try {
				playerInput = input.nextInt();
				input.nextLine();
				
				//Check if they entered an invalid number
				if(playerInput > player.getNumWeapons()-1) {
					//Player attempts to grab a weapon that doesn't exist
					System.out.println("You don't have that many weapons!");
					
					//Text Rest
					System.out.println("--------------------------------------------------");
					System.out.println("");
					System.out.print("Press ENTER to continue...");
					input.nextLine();
				} else {
					weapon = player.getWeapon(playerInput);		//Grab the selected weapon
					bonus = rng.nextInt(20)+1;	//Grab a random bonus on the attack
					totalPower = weapon.getPower() + bonus;	//Calculate the total power
					if (weapon.getType() == enemy.getWeakness()) {
						//If the attack is super effective, do double damage
						System.out.println("Super effective! Power Doubled.");
						totalPower = totalPower * 2;
					} else if (weapon.getType() == enemy.getStrength()) {
						//If the attack is resisted, half the damage (rounded down)
						System.out.println("It resists! Power halved. (Rounded Down)");
						totalPower = (int) Math.floor(totalPower / 2);
					}
					
					//Tell the player how much damage they did and how much defense the enemy has
					System.out.println("Total attack power: " + totalPower);
					System.out.println("Enemy defense: " + enemy.getDefense());
					
					if (totalPower >= enemy.getDefense()) {	//The attack hits
						damageDelt = totalPower - enemy.getDefense();
						System.out.println("You stun the enemy and deal " + damageDelt + " damage.");
						enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDelt);
					} else {	//The attack fails
						System.out.println("You fail to hurt the enemy.");
						damageDelt = enemy.getDefense() - totalPower + enemy.getAttack();
						System.out.println("The enemy strikes you for " + damageDelt + " damage.");
						player.setCurrentHealth(player.getCurrentHealth() - damageDelt);
					}	
					//Text Rest
					System.out.println("--------------------------------------------------");
					System.out.println("");
					System.out.print("Press ENTER to continue...");
					input.nextLine();
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("You have to enter a number to select a weapon.");
				input.nextLine();
			}
		} while (enemy.getCurrentHealth() > 0 && player.getCurrentHealth() > 0);
		
		if(enemy.getCurrentHealth() <= 0) {
			System.out.println("--------------------------------------------------");
			System.out.println("You have defeated the enemy!");
			player.giveItem(rng);
		}
	}
	
	/**
	 * This method handles the special mechanics of Floor 12's boss 
	 * @param player
	 * @param input
	 * @param rng
	 */
	public static void fightBoss3(Player player, Scanner input, Random rng, Monster enemy) {
		int playerInput;	//The input for the weapon the player picks
		Weapon weapon;		//Stores the weapon for calculations
		int bonus;			//The random bonus to the attack, from 1 to 20
		int totalPower;		//The total power behind the attack.
		int damageDelt;		//The total damage delt to the boss.
		
		do {	//Run the battle while the player and boss are both alive
			//Display the boss's stats
			System.out.println("--------------------------------------------------");
			System.out.println(enemy);
			
			//Display the player's stats
			System.out.println("--------------------------------------------------");
			System.out.println(player);
			
			//Text Rest
			System.out.println("--------------------------------------------------");
			System.out.println("");
			System.out.print("Press ENTER to continue...");
			input.nextLine();
			
			//Display the player's inventory
			System.out.println("--------------------------------------------------");
			player.displayInventory();
			
			//Ask the user to select a weapon from their inventory
			System.out.println("--------------------------------------------------");
			System.out.print("Please select a weapon: (#) ");
			try {
				playerInput = input.nextInt();
				input.nextLine();
				
				//Check if they entered an invalid number
				if(playerInput > player.getNumWeapons()-1) {
					//Player attempts to grab a weapon that doesn't exist
					System.out.println("You don't have that many weapons!");
					
					//Text Rest
					System.out.println("--------------------------------------------------");
					System.out.println("");
					System.out.print("Press ENTER to continue...");
					input.nextLine();
				} else {
					weapon = player.getWeapon(playerInput);		//Grab the selected weapon
					bonus = rng.nextInt(20)+1;	//Grab a random bonus on the attack
					totalPower = weapon.getPower() + bonus;	//Calculate the total power
					if (weapon.getType() == enemy.getWeakness()) {
						//If the attack is super effective, do double damage
						System.out.println("Super effective! Power Doubled.");
						totalPower = totalPower * 2;
					} else if (weapon.getType() == enemy.getStrength()) {
						//If the attack is resisted, half the damage (rounded down)
						System.out.println("It resists! Power halved. (Rounded Down)");
						totalPower = (int) Math.floor(totalPower / 2);
					}
					
					//Tell the player how much damage they did and how much defense the enemy has
					System.out.println("Total attack power: " + totalPower);
					System.out.println("Enemy defense: " + enemy.getDefense());
					System.out.println("The Paladin defends, preventing Stun, but letting you hit!");
					
					/** SPECIAL FOR THIS BOSS:
					 * The player's attack will always hit.
					 * If it doesn't beat defense, it does the weapon power as damage.
					 * The boss cannot be stunned, and will always attack.
					 * It's a pure endurance battle.
					 * Don't have strong weapons? Should have explored more.
					 */
					
					//Check the attack's strength compared to the Paladin's defense
					if (totalPower >= enemy.getDefense()) {	//Powerful hit
						damageDelt = totalPower - enemy.getDefense();
						if (damageDelt < enemy.getDefense()) {
							damageDelt = weapon.getPower();
						}
						System.out.println("You hit the Paladin and deal " + damageDelt + " damage.");
						enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDelt);
					} else {	//Standard Hit
						damageDelt = weapon.getPower();
						System.out.println("You hit the Paladin and deal " + damageDelt + " damage.");
						enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDelt);
					}
					
					/** Since the Paladin defends, he get's to attack as well. */
					//But only if he isn't defeated.
					if(enemy.getCurrentHealth() > 0) {
						System.out.println("The Paladin strikes you for " + enemy.getAttack() + " damage.");
						player.setCurrentHealth(player.getCurrentHealth() - enemy.getAttack());
					}
					
					//Text Rest
					System.out.println("--------------------------------------------------");
					System.out.println("");
					System.out.print("Press ENTER to continue...");
					input.nextLine();
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("You have to enter a number to select a weapon.");
				input.nextLine();
			}
		} while (enemy.getCurrentHealth() > 0 && player.getCurrentHealth() > 0);
		
		if(enemy.getCurrentHealth() <= 0) {
			System.out.println("--------------------------------------------------");
			System.out.println("You have defeated the enemy!");
			player.giveItem(rng);
			
			//Text Rest
			System.out.println("--------------------------------------------------");
			System.out.println("");
			System.out.print("Press ENTER to continue...");
			input.nextLine();
		}
	}
	
	/**
	 * This method controls the special mechanics of the final boss
	 * @param player
	 * @param input
	 * @param rng
	 * @param enemy
	 */
	public static void fightFinal(Player player, Scanner input, Random rng, Monster enemy) {
		int playerInput;	//The input for the weapon the player picks
		Weapon weapon;		//Stores the weapon for calculations
		int bonus;			//The random bonus to the attack, from 1 to 20
		int totalPower;		//The total power behind the attack
		int damageDelt;		//The total damage delt, either to the player or monster.
		boolean usedHeal = false;	//Special for this boss. They get a 1-time heal.
		
		do {	//Run the battle while the player and enemy are both alive
			//Display the enemy's stats
			System.out.println("--------------------------------------------------");
			System.out.println(enemy);
			
			//Display the player's stats
			System.out.println("--------------------------------------------------");
			System.out.println(player);
			
			//Text Rest
			System.out.println("--------------------------------------------------");
			System.out.println("");
			System.out.print("Press ENTER to continue...");
			input.nextLine();
			
			//Display the player's inventory
			System.out.println("--------------------------------------------------");
			player.displayInventory();
			
			//Ask the user to select a weapon from their inventory
			System.out.println("--------------------------------------------------");
			System.out.print("Please select a weapon: (#) ");
			try {
				playerInput = input.nextInt();
				input.nextLine();
				
				//Check if they entered an invalid number
				if(playerInput > player.getNumWeapons()-1) {
					//Player attempts to grab a weapon that doesn't exist
					System.out.println("You don't have that many weapons!");
					
					//Text Rest
					System.out.println("--------------------------------------------------");
					System.out.println("");
					System.out.print("Press ENTER to continue...");
					input.nextLine();
				} else {
					weapon = player.getWeapon(playerInput);		//Grab the selected weapon
					bonus = rng.nextInt(20)+1;	//Grab a random bonus on the attack
					totalPower = weapon.getPower() + bonus;	//Calculate the total power
					if (weapon.getType() == enemy.getWeakness()) {
						//If the attack is super effective, do double damage
						System.out.println("Super effective! Power Doubled.");
						totalPower = totalPower * 2;
					} else if (weapon.getType() == enemy.getStrength()) {
						//If the attack is resisted, half the damage (rounded down)
						System.out.println("It resists! Power halved. (Rounded Down)");
						totalPower = (int) Math.floor(totalPower / 2);
					}
					
					//Tell the player how much damage they did and how much defense the enemy has
					System.out.println("Total attack power: " + totalPower);
					System.out.println("Enemy defense: " + enemy.getDefense());
					
					if (totalPower >= enemy.getDefense()) {	//The attack hits
						damageDelt = totalPower - enemy.getDefense();
						System.out.println("You stun the enemy and deal " + damageDelt + " damage.");
						enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDelt);
					} else {	//The attack fails
						System.out.println("You fail to hurt the enemy.");
						damageDelt = enemy.getDefense() - totalPower + enemy.getAttack();
						System.out.println("The enemy strikes you for " + damageDelt + " damage.");
						player.setCurrentHealth(player.getCurrentHealth() - damageDelt);
					}	
					
					/**
					 * SPECIAL FOR THIS FIGHT
					 * When the boss is at 25% health, they heal back to 50%.
					 * The boss has a 10% chance each turn to fire off a weak 5 damage attack.
					 * Since it's the final boss, there is no weapon drop for winning.
					 */
					//Check if below 25% health and if the heal spell was used
					if(enemy.getCurrentHealth() <= (enemy.getMaxHealth()/4) && usedHeal == false) {
						//If it was used, heal for 25% health. No more healing.
						System.out.println("The mage casts a healing spell and heals 25% of her health!");
						enemy.setCurrentHealth(enemy.getCurrentHealth() + (enemy.getMaxHealth()/4));
						usedHeal = true;
					}
					
					//Roll a number from 1 to 100. If 10 or lower, deal 5 damage to the player
					if(rng.nextInt(100)+1 <= 10) {
						System.out.println("The mage manages to cast a weaker magic missle!");
						System.out.println(player.getName() + " takes 5 damage.");
						player.setCurrentHealth(player.getCurrentHealth() - 5);
					}
					
					//Text Rest
					System.out.println("--------------------------------------------------");
					System.out.println("");
					System.out.print("Press ENTER to continue...");
					input.nextLine();
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("You have to enter a number to select a weapon.");
				input.nextLine();
			}
		} while (enemy.getCurrentHealth() > 0 && player.getCurrentHealth() > 0);
	}
}