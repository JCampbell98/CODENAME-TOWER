import java.util.Scanner;

/**
 * @author Jordan Campbell
 *
 * The cutscene class contains all the cutscenes in the game.
 * Any that contain dialogue contain blank inputs between each line.
 * This is so the player can read the text at their own pace, then hit enter to go to the next line.
 * This class only holds the text for cutscenes. All menus and gameplay are handled by other classes.
 * 
 * The TitleScreen method displays the title screen.
 * The various Floor# methods display cutscene text before the start of that floor. (Ex. Floor1 for the first floor)
 * The Ending method displays the ending cutscene for when the player beats the game.
 * The GameOver method display the cutscene for when the player runs out of health and dies.
 */

/*
 * Ignore this comment block. It was used to hold the cutscene template
System.out.println("--------------------------------------------------");
System.out.println("");
System.out.print("Press ENTER to continue...");
input.nextLine();
 */

/**
 * <b>I cannot take credit for the cutscenes.</b><br />
 * I had a huge amount of help from a friend of mine (only know him as PotentChaos online) with the
 * writing of the story, plot, and characters. All the programming, enemies, weapons, and combat
 * were designed by me, but without his help, this game wouldn't have the cutscenes to tie it all
 * together.
 */
public class Cutscene {
	//Display the title screen for when the game starts
	public void TitleScreen() {
		System.out.println("                    +--------+                    ");
		System.out.println("                    |        |                    ");
		System.out.println("                    |  ****  |                    ");
		System.out.println("                    |  *  *  |                    ");
		System.out.println("                    |  ****  |                    ");
		System.out.println("                    |        |                    ");
		System.out.println("                    |  ****  |                    ");
		System.out.println("                    |  *  *  |                    ");
		System.out.println("                    |  ****  |                    ");
		System.out.println("                    |        |                    ");
		System.out.println("                    |        |                    ");
		System.out.println("                    |        |                    ");
		System.out.println("                    |  +--+  |                    ");
		System.out.println("                    |  |  |  |                    ");
		System.out.println("                    |  |  |  |                    ");
		System.out.println("+-------------------+--------+-------------------+");
		System.out.println("|                 CODENAME TOWER                 |");
		System.out.println("+------------------------------------------------+");
	}
	
	//Display the tutorial
	public void Tutorial(Player player, Scanner input, Monster enemy) {
		System.out.println("--------------------------------------------------");
		System.out.println("\"DAD! Pay attention!\" You hear the nearby voice of\n"
						 + "your daughter say. \"That slime may be weak but it\n"
						 + "doesn’t mean you can zone out!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to start the tutorial fight.");
		input.nextLine();
		
		/**
		 * This battle does not function like a normal one.
		 * Everything that happens is pre-determined.
		 * The player does not take damage, and they do not get any items for it.
		 * It's just so they can learn the basics of combat.
		 * That is why it does not use the normal system for combat.
		 */
		System.out.println("--------------------------------------------------");
		System.out.println(enemy);
		System.out.println("--------------------------------------------------");
		System.out.println(player);
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		//The daughter tells the player the VERY basics of how the combat system works
		//If your attack hits, you deal damage. Otherwise, you take damage.
		System.out.println("--------------------------------------------------");
		System.out.println("Your daughter speaks up.\n"
						+ "\"Now dad, you know that when you attack you stun the\n"
						+ "monster right? Otherwise it will attack you back. Seriously\n"
						+ "dad, you have been doing this since I was born 16 years ago,\n"
						+ "and you still have troubles with slimes...\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		//Display the player's inventory, and tell them about weapons
		player.displayInventory();
		System.out.println("--------------------------------------------------");
		System.out.println("\"At the moment, you only have your wooden sword.\n"
						 + "Normally, you'd have to select it by pressing 0.\n"
						 + "I'll selected it for you this time though.\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		int tutorialTotalPower = 13;
		System.out.println("Total attack power: " + tutorialTotalPower);
		System.out.println("Enemy defense: " + enemy.getDefense());
		int damage = tutorialTotalPower - enemy.getDefense();
		System.out.println("You stun the enemy and deal " + damage + " damage.");
		enemy.setCurrentHealth(enemy.getCurrentHealth() - damage);
		System.out.println("--------------------------------------------------");
		System.out.println("\"Way to go dad! One more time!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println(enemy);
		System.out.println("--------------------------------------------------");
		System.out.println(player);
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		player.displayInventory();
		System.out.println("--------------------------------------------------");
		System.out.println("\"I'll select the weapon for you again. After this\n"
						 + "you'll have to do it on your own though, ok Dad?\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue!");
		input.nextLine();
		
		tutorialTotalPower = 1;
		System.out.println("Total attack power: " + tutorialTotalPower);
		System.out.println("Enemy defense: " + enemy.getDefense());
		damage = enemy.getDefense() - tutorialTotalPower + enemy.getAttack();
		System.out.println("You were about to take " + damage + " damage, when suddenly...");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("\"DAD!\" " + player.getName() + " lashes out in fear,\n"
						 + "eyes closed, then the sound of impact as slime goes\n"
						 + "flying everywhere. “...Dad, that is enough for today.\n"
						 + "We are going home. If you worry mom anymore than you\n"
						 + "already do I’ll be forced to babysit you ALL the time.\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to return to the village...");
		input.nextLine();
	}
	
	//Display the game over screen for when the player dies
	public void GameOver(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("As the enemy's attack hits, your vision starts to fade.\n"
						 + "It appears as though you were not strong enough to make\n"
						 + "it to the end. Perhaps you didn't explore enough to find\n"
						 + "better weapons? Or maybe you explored too much and found\n"
						 + "creatures you were not ready for? No matter how you went,\n"
						 + "use this as a lesson so that on your next adventure, you\n"
						 + "may make it to the top of the tower.\n"
						 + "Sadly, this is the end for " + player.getName() + ".");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("   #####                          #######                      \n"
						 + "  #     #   ##   #    # ######    #     # #    # ###### #####  \n"
						 + "  #        #  #  ##  ## #         #     # #    # #      #    # \n"
						 + "  #  #### #    # # ## # #####     #     # #    # #####  #    # \n"
						 + "  #     # ###### #    # #         #     # #    # #      #####  \n"
						 + "  #     # #    # #    # #         #     #  #  #  #      #   #  \n"
						 + "   #####  #    # #    # ######    #######   ##   ###### #    # ");
		System.out.println("-----------------------------------------------------------------");
	}
	
	/**
	 * Floor 1
	 */
	public void Floor1(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("After returning home from training, " + player.getName() + " goes to\n"
						 + "the tavern to unwind after nearly dying to a slime...\n"
						 + "again.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("As he sits down, he hears some of the townspeople\n"
						 + "talking of stronger monsters having escaped from a\n"
						 + "menacing tower in the area, and rumors that the one\n"
						 + "who conquered it would be credited for keeping the\n"
						 + "land safe, and that a wish granting item lay in the\n"
						 + "top room.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + " gets a glitter in his eye and spins towards these\n"
						 + "gossipping fellows. \"Why this sounds like a quest if\n"
						 + "I have ever heard one! As the town’s greatest adventurer,\n"
						 + "I will keep our fair hamlet safe and claim this wish\n"
						 + "as compensense!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("The entire bar turns towards " + player.getName() + " and after a few\n"
						 + "moments a man starts to clap. \"Why thank you! It’s\n"
						 + "satisfying to know that the jester of combat will\n"
						 + "take down dragons with his comedic failures! Perhaps\n"
						 + "you can make them choke on your bones while laughing\n"
						 + "at you!\" Even the bartender lets loose a chuckle at this.\n"
						 + "\"Richard means no harm " + player.getName() + ", it’s just the entire village\n"
						 + "knows that you are hardly a fighter, never have been\n"
						 + "honestly. Perhaps it’s time you found a different source\n"
						 + "of income than the pocket change of monsters.\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("In a huff, " + player.getName() + " leaves the tavern, grabs his wooden sword\n"
						 + "and leather armor from his house, kisses his wife telling\n"
						 + "her he has a quest to complete, and walks off towards the\n"
						 + "tower. The next morning after resting at camp he arrives,\n"
						 + "only to find a group of impressively equipped adventurers\n"
						 + "preparing to enter. From left to right there is a Knight\n"
						 + "decked in heavy armor, a Rogue covered in pouches brimmed with\n"
						 + "interesting colors, a young woman with a bow and wearing a\n"
						 + "tribal mask, a burly man equipped with a tower shield and\n"
						 + "javelin, and leading them is a mage wearing a massive hat\n"
						 + "and face guard.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.println("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("You are about to try to enter when the knight turns\n"
						 + "towards you \"Haha! A runt like you raiding a dungeon?\n"
						 + "You are obviously an amateur if you don’t know dungeon\n"
						 + "etiquette! It is only fair to wait an hour before entering\n"
						 + "a dungeon if someone else enters before you!\" The mage\n"
						 + "glances over their shoulder, and with that they trek into\n"
						 + "the tower, leaving you only that much more excited.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("After waiting, you enter to find them knocking over\n"
						 + "slimes left and right, beating down enemies you have\n"
						 + "always struggled with like paper dolls, and they reach\n"
						 + "the stairwell. Excited, you rush in after them, starting\n"
						 + "your adventure into the tower...");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to start the game!");
		input.nextLine();
	}
	
	/**
	 * Floor 2
	 */
	public void Floor2(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("After tirelessly fending off each onslaught, you realize\n"
						 + "the entire day has passed in your trek, and only the first\n"
						 + "floor has been cleared. Climbing the stairs you find a room\n"
						 + "with a fire pit and pot, and decide it may be a good chance to\n"
						 + "rest. On the wall you notice a note written by the other group.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();		
		
		System.out.println("--------------------------------------------------");
		System.out.println("\"I’m glad you made it this far, you at least have\n"
						 + "a little potential. Oh, by the way, i’m the mage of\n"
						 + "the party earlier. I figured I would explain how this\n"
						 + "dungeon works since you are obviously an amateur. The\n"
						 + "energy of this tower seems to strengthen those within,\n"
						 + "be it friend or foe. The higher in the tower you travel,\n"
						 + "the stronger you will get, but so will the monsters. There\n"
						 + "are also a large amount of weapons scattered about. With\n"
						 + "your... skill level... you'll probably want to collect\n"
						 + "as many of them as you can.\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("\"Good luck, get rest and perhaps you can even get\n"
						 + "partial credit!\" Unhappy about the last line, you\n"
						 + "venture up the stairs and find them once again breezing\n"
						 + "through fights you struggle with and feel a little\n"
						 + "helpless. but it is too late now! You charge forward\n"
						 + "into the floor and start looking around.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	/**
	 * Floor 3
	 */
	public void Floor3(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("You fought through the night, pushed and clawed, and\n"
						 + "have finally made it to the end of the second floor!\n"
						 + "And in record time too, you took only half as long as\n"
						 + "you did to finish the first floor. You decide to go\n"
						 + "straight to the third floor after only a quick break.\n"
						 + "Reaching it, you see the Knight get leapt upon by a\n"
						 + "goblin, but seemingly shrug off the blow effortlessly.\n"
						 + "What you would give to get that armor, though you don’t\n"
						 + "think you could budge in all that metal. Well, your turn\n"
						 + "to fight!");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor4(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Reaching the end of the third floor, you gasp as you\n"
						 + "realize how much stronger these enemies were than any\n"
						 + "before. Between exhaustion and pain, you slump down\n"
						 + "next to the fire and pass out, unsure of the time.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Waking up, you realize that the fire had been lit when\n"
						 + "you arrived, and remnants of cooked food lie about.\n"
						 + "In your time on the third floor, the adventurers must\n"
						 + "have rested up. And now they have an even greater lead!\n"
						 + "You leap up the steps, scaling them excitedly ready to\n"
						 + "roar your way through. But the site atop sends shivers\n"
						 + "down your spine. You find the adventurers engaging in\n"
						 + "the tail end of a long battle with a massive shark headed\n"
						 + "lion. As you peer out, the mage casts a powerful lightning\n"
						 + "spell and shock the last shreds of life from the powerful\n"
						 + "foe. and they stop to recuperate. Looking about you see\n"
						 + "monsters creep from their hiding places and approach the\n"
						 + "exhausted fighters. You engage them to protect them.");
		System.out.println("--------------------------------------------------");
		System.out.println("SPECIAL FLOOR. No Exploration Available.");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Boss1A(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("The ordeal over you go towards the exit and find the\n"
						 + "Knight sitting next to the stairs, speaking to the mage.\n"
						 + "Listening in you hear the mage address the knight in a\n"
						 + "muffled voice \"I’m sorry I didn’t notice that the\n"
						 + "goblin poisoned you sooner... we could have cured it...\n"
						 + "but it’s too late now. If you see him though, well I\n"
						 + "suppose do what you will do.\" With a pat on the back\n"
						 + "the mage rushes up the stairs and out of sight.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("You wait a moment, then approach the knight, who looks\n"
						 + "up at you through his full helm. \"Well! I’ll be dashed,\n"
						 + "I bet you would have died by now with muscles like yours!\n"
						 + "WELL DONE!\" The knight shifts to his feet and towers\n"
						 + "over you. \"You’ve made it pretty far nipping at our\n"
						 + "heels! Ah now I remember! I know you, " + player.getName() + ",\n"
						 + "and I know how weak you are. You struggle with the\n"
						 + "weakest enemies and rely on your daughter to bail you\n"
						 + "out of sticky situations... Quite literally as she saved\n"
						 + "you from a SLIME not three days ago! HAHAHAHAHA!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("You try to walk past him, but he steps squarely into\n"
						 + "your path. \"HAH! I cannot let one as weak as you go\n"
						 + "on any further. As such, we will duel. If I beat you,\n"
						 + "leave this tower at once! Understand that this battle\n"
						 + "will not be one to hold back in!\"");
		System.out.println("--------------------------------------------------");
		player.setCurrentHealth(player.getMaxHealth());
		System.out.println("BOSS BATTLE! Your health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		//
	}
	
	public void Boss1B(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("After beating the knight, he falls to his knees,\n"
						 + "obviously unable to hold on much longer. You reach\n"
						 + "for your medicines, but he stops you. \"Heh, I’m in\n"
						 + "no need of your pity. I stopped here so as to keep\n"
						 + "myself from hindering the party’s progress. I was\n"
						 + "already too weak to leave the dungeon and intended\n"
						 + "to keep you from the same fate. Little did I know\n"
						 + "you had grown so quickly. HAH! Don’t waste precious\n"
						 + "medicine on a dead man, you will need it more than I!\n"
						 + "Do as you wish, be it follow their heels or turn back,\n"
						 + "but leave me to my fate.\" Stepping forward, you advance\n"
						 + "further in, the weight of what had happened still sinking in.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	//
	
	public void Floor5(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Stepping up into the next floor you see the brave party\n"
						 + "in battle once again, and as you watch in horror a\n"
						 + "Goblin drops down upon the rogue in an ambush. As it\n"
						 + "draws back it’s strike, the mage leaps in between the\n"
						 + "Rogue and the knife, taking the blow with a flash of\n"
						 + "light, and next only a puddle of goo is left of the\n"
						 + "monster and the mage is kneeling in pain. Quickly the\n"
						 + "party rushes to the stairs and moves on, treating their\n"
						 + "wounds as they move. Best keep your wits about you.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor6(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Another floor, another glimpse. You have done an\n"
						 + "excellent job keeping up with these skilled Dungeoneers,\n"
						 + "and see them wielding new weaponry. A flaming Javelin and\n"
						 + "an impressive shield with a Demon’s horns on top belong\n"
						 + "to the Shield bearer. The Ranger woman has a great bow\n"
						 + "larger than her, and the mage now wields a massive tome\n"
						 + "and quickly shifts through their pages casting such a\n"
						 + "variety of spells, and the rogue seems to turn invisible\n"
						 + "at will. Jealousy building, you charge into the floor\n"
						 + "hoping to ascertain the location of similar finds.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor7(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Hopping up the stairs double time you excitedly approach\n"
						 + "the 7th floor, hoping to watch the powerful friends\n"
						 + "you have made in action once again. Sure enough, you\n"
						 + "see them executing an impressive maneuver as the mage\n"
						 + "stands upon the shield bearers shoulders and casts\n"
						 + "spell after spell at the horde of Tar Slimes encroaching\n"
						 + "upon them from every side. Just as one leaps at her\n"
						 + "an arrow launches through it and pins it to a wall,\n"
						 + "and when a demon peeks from around a corner the rogue\n"
						 + "silently slits it’s throat and moves on. The exhilaration\n"
						 + "is too much as you let them finish the floor and step\n"
						 + "into it yourself.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor8(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("An eternity of drudge fights later, you reach the\n"
						 + "stairs to the 8th floor, and looking through the slit\n"
						 + "of a window in the rest zone you see a full moon high\n"
						 + "in the sky, and seeing as the window faces east you\n"
						 + "know the night is almost through. Settling down next\n"
						 + "to the warm lit embers you quickly drift to sleep");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("You are woken by a rumbling and realize that a roar\n"
						 + "of pain has shattered the silence. Rushing up the\n"
						 + "stairs you see the rogue cutting slabs of meat off\n"
						 + "a massive bull and handing them to the mage. Sadly,\n"
						 + "you slept through the entire fight, only to see the\n"
						 + "clean up. Either way you step in and are immediately\n"
						 + "rushed by the once terrified enemies.");
		System.out.println("--------------------------------------------------");
		System.out.println("SPECIAL FLOOR. No Exploration Avaliable.");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Boss2A(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Approaching the stairs, the Rogue stands in your way.\n"
						 + "\"Sorry " + player.getName() + ", but orders are orders.\n"
						 + "I'm hoping that she only said it for your own safety,\n"
						 + "but I can’t let you go any further. I’ll give you this\n"
						 + "escape feather, but you can’t beat me.\" Drawing your\n"
						 + "sword you swing, but he nimbly dodges it. \"If you insist,\n"
						 + "I’ll beat you down first then send you out!\"");
		System.out.println("--------------------------------------------------");
		player.setCurrentHealth(player.getMaxHealth());
		System.out.println("BOSS BATTLE. Your health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();		
	}
	
	public void Boss2B(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Beaten and bruised, you exert all of your strength\n"
						 + "hoping to strike the sly man, and with an surprising\n"
						 + "impact you realize that your blade not only hit, but\n"
						 + "has been lodged deep into his side. He looks at you,\n"
						 + "then collapses \"Guess I let my guard down thinking\n"
						 + "you were much weaker than this.. don’t blame yourself,\n"
						 + "I'm the one who provoked you... I’ll be fine anyways.\n"
						 + "I wouldn't be so unresourceful as to not bring health\n"
						 + "potions into a dungeon. I’ll use the feather and return\n"
						 + "home, it's been too long since I did this adventure thing\n"
						 + "anyways. Take some meat from the bull with you\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("After harvesting some prime cuts you slowly step up\n"
						 + "the stairs. You collapse next to the fire and let\n"
						 + "your thoughts and stomach settle. Just as you are about\n"
						 + "to move on your hear a scream, the sound of blade on\n"
						 + "stone then silence... Trying to forget, you forge ahead.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor9(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Reaching the next floor, there is no sign of life,\n"
						 + "not the party or the monsters. Stopping for a moment,\n"
						 + "you hear the mage shout \"Hurry up, dammit! If that\n"
						 + "fool catches up to us we won’t get the wish we want!\n"
						 + "I won’t hesitate to leave you behind either!\"The\n"
						 + "echoes of the room make it hard to distinguish pitch,\n"
						 + "but you can easily tell they are much more irritable\n"
						 + "than before. Shrugging off an ominous feeling, you\n"
						 + "begin the treacherous task of engaging in the next floor.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor10(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Before reaching the top of the stairs, you hear more\n"
						 + "commands being shouted. You peer into the open room\n"
						 + "to see the shield bearer taking the brunt of an onslaught\n"
						 + "while the mage sits upon his shoulders, almost laughing\n"
						 + "at his struggle. Just as the man’s guard is to be broken,\n"
						 + "a volley of arrows rains upon the enemies and quickly\n"
						 + "ends the fight. Jumping off his shoulders, the mage\n"
						 + "congratulates themself and proudly climbs the stairs.\n"
						 + "You stop and think, but still can't decide what gender\n"
						 + "the mage actually is. You laugh at this and move forward.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor11(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Encroaching upon the stairs to the 11th floor, you\n"
						 + "stop and wonder at how strong you have become. Confidence\n"
						 + "wells in you as you realize that before you entered\n"
						 + "this dungeon even the second floor enemies would have\n"
						 + "easily killed you with hardly a flick of their wrist,\n"
						 + "and now you do the same to monsters of such greater\n"
						 + "strength. Perhaps you really were cut out for this\n"
						 + "adventuring schtick after all! At the top you find\n"
						 + "hide nor hare of the party, but can see how bold the\n"
						 + "monsters are here. No time to waste you suppose.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor12(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Having overexerted yourself on the last floor, you\n"
						 + "plop down at the flaring fire and cook up your meal\n"
						 + "of bull’s meat, and begin to wonder how lucky you were\n"
						 + "that this party has spearheaded your travels, even\n"
						 + "though you did bring two of them to untimely demise...\n"
						 + "As you consider what else you could have done you drift\n"
						 + "to slumber so deep the stone seems like the perfect pillow.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("With a satisfying yawn you rise and dust yourself\n"
						 + "off, a bright morning sun welcoming you into what\n"
						 + "you hope is a less gory day. Climbing up the stairs,\n"
						 + "you see the tail end of battle with another ferocious\n"
						 + "beast! Sitting down you decide to let them finish\n"
						 + "what they started, and watch as the remains of a\n"
						 + "beached kraken has its tentacles severed endlessly.\n"
						 + "The mage stands back to back with the shield knight\n"
						 + "prepping an immense cast, while the shield gets\n"
						 + "beaten upon by endless blows. Just as the kraken rips\n"
						 + "the shield from his hands with its beak, the mage turns\n"
						 + "towards the man and kicks him down, stepping onto him and\n"
						 + "casting an immense black hole on the monster’s body, and\n"
						 + "when the spell ends the shield and all but the Kraken’s\n"
						 + "tentacles have been completely erased.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Stepping in you expect an onslaught of enemies as\n"
						 + "usual, but nothing rears it’s head. Perhaps the Kraken\n"
						 + "ate them all? Either way, you look over and see the\n"
						 + "mage yelling at the man. \"What do you mean I shouldn’t\n"
						 + "have stepped upon you?! At least I kept you from ending\n"
						 + "up like your ridiculous shield! All men are alike I\n"
						 + "swear! Take your small spare shield and keep him from\n"
						 + "progressing any further, I will not lose this wish to\n"
						 + "someone as weak as him!\" With that, they storm off\n"
						 + "towards the stairs, and to your amazement he actually\n"
						 + "obeys the Mage’s orders, and stands in your way.\n"
						 + "No way around it then.");
		System.out.println("--------------------------------------------------");
		System.out.println("SPECIAL FLOOR. No Exploration Alowed.");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	//
	
	public void Boss3(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("\"Well " + player.getName() + ", I’m honestly impressed.\n"
						 + "If you don’t mind my asking, how did you get past\n"
						 + "Richard and Berem?\" Ashamedly, you look away and he\n"
						 + "quickly catches on. “...well. This dungeon has changed\n"
						 + "us all, don’t blame yourself. I believe it’s the curse\n"
						 + "that protects it. Either way, i’m going to stop you,\n"
						 + "not because I was told to, but because their intention\n"
						 + "was only for your sake. No one in the village wanted to\n"
						 + "let you die, so a few of us picked up our old gear and\n"
						 + "decided to get it before you, and look now! Well, draw\n"
						 + "your sword. Let’s not get emotional!”");
		player.setCurrentHealth(player.getMaxHealth());
		System.out.println("--------------------------------------------------");
		System.out.println("BOSS BATTLE. Your health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor13(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Breaking his guard and sending his shield flying,\n"
						 + "your opportunity is there, his throat is exposed, and\n"
						 + "you know you can slit it. In the back of your mind\n"
						 + "you hear something small that makes you hesitate, and\n"
						 + "in that time he throws a full bodied uppercut into your\n"
						 + "chin, and you pass out.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("When you come to your senses, he is tending to your\n"
						 + "bruised chin in the rest area, and you realize what\n"
						 + "you heard. Somewhere along the way you had been cursed,\n"
						 + "and slowly your common sense repressed. Thankfully,\n"
						 + "the jolt to your head brought it back to normal, and\n"
						 + "you look at him apologetically. Laughing, he thanks\n"
						 + "you himself. \"When you broke my guard and I thought\n"
						 + "I would die, the curse lifted, and I realized what to\n"
						 + "do. Thankfully, you weren’t taken completely and gave\n"
						 + "me the time to hit you to your senses. Never thought you\n"
						 + "could counter magic with brute force, but here we are!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("\"Either way, I'm going to head back. I have a feather\n"
						 + "and have already packed up, but do me a favor and stop\n"
						 + "the other two. I believe you need not worry about the\n"
						 + "curse anymore, and that only you can stop them making\n"
						 + "a mistake they will regret for their entire lives.\n"
						 + "Another beast lies on the fourteenth floor, so you can\n"
						 + "catch them there.\" Tossing the feather in the flame,\n"
						 + "he steps in and is gone, and with that you raise yourself\n"
						 + "and move up to the 13th floor.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Boss4(Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Another floor bagged you step into the 14th floor without\n"
						 + "any hesitation, and find the two remaining party members\n"
						 + "struggling to keep an enormous sword wielding Bear at\n"
						 + "bay, each having to focus only on dodging, and quickly\n"
						 + "getting worn out. Rushing in, you taunt the bear and\n"
						 + "grab its attention and do your best to protect the\n"
						 + "two of them.");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("--------------------------------------------------");
		System.out.println("BOSS BATTLE! There is no escape!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor14End (Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("The bear finds itself unable to handle you, and with\n"
						 + "a surge of speed rushes down the ranger, knocking her\n"
						 + "solidly into the wall. Before you can react the mage\n"
						 + "blasts it with a bolt of lightning, then retreats up\n"
						 + "the stairs, leaving you to finish the stunned bear before\n"
						 + "it kills the young Ranger woman. Leaping onto it's back,\n"
						 + "you take your sword and swing it at the bear’s head,\n"
						 + "decapitating it. A gush of wind swirls around you and\n"
						 + "dark thoughts seem to cloud your mind, but shaking your\n"
						 + "head you come back to your senses. Thankfully, you had\n"
						 + "already been cleared of the curse and were aware of the danger.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Helping up the young woman, you recognize her as your\n"
						 + "wife’s best friend and panic. \"Don’t tell me my wife\n"
						 + "is the mage who just climbed to the 15th floor!?\"\n"
						 + "shaking her head no, she tries to regain her balance,\n"
						 + "but you rush off up the stairs before she can ever fully\n"
						 + "answer the question, assured your wife isn’t the mage.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor15Start (Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Reaching the top, you find the mage patiently waiting\n"
						 + "for you. As you step onto the final floor, the door\n"
						 + "behind you closes. A voice booms throughout the room\n"
						 + "\"This is your final test! Only one may claim the wish,\n"
						 + "and only if the battle should satisfy my enjoyment!\"\n"
						 + "Laughter fills the room as you panic. \"Before you get\n"
						 + "any funny ideas about walking out, I have watched your\n"
						 + "entire journey, and have the ability to blow your entire\n"
						 + "village to ash should you not engage in my fight! Who\n"
						 + "will win? The Leader, who has fought against each\n"
						 + "grueling boss, and earned her way up the tower!\n"
						 + "Or the fool, who believed himself strong and followed\n"
						 + "in the wake of true adventurers!\n"
						 + "Best hurry lest I get impatient...\"");
		System.out.println("--------------------------------------------------");
		System.out.println(player.getName() + "'s Max Health has increased by 10, and their health has been restored!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Boss5 (Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("The mage wastes no time and casts a spell upon her\n"
						 + "cloak, sets up speed spells, and her body glows, seeming\n"
						 + "to invigorate her. Already at a disadvantage, and wanting\n"
						 + "to protect your daughter and wife, you rush forward to\n"
						 + "stop her from setting up anymore.");
		System.out.println("--------------------------------------------------");
		System.out.println("BOSS BATTLE! There is no escape!");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Floor15End (Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("Knocking away the staff and book the mage holds, all\n"
						 + "the spells fade instantly. Pinning the mage to the\n"
						 + "ground with one knee you declare victory, while the\n"
						 + "mage claws toward the altar in the back of the room.\n"
						 + "Suddenly, the booming voice laughs. \"Losers get nothing\n"
						 + "but death! " + player.getName().toUpperCase() + "! Strike her down!\n"
						 + "Claim your wish through her blood!\" You hear these words\n"
						 + "and release her from your pin, and turn towards the altar.\n"
						 + "\"No wish is worth another life. I have killed two close\n"
						 + "friends through your curse, why should I kill another?!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("As you finish your rejection, the wind from before\n"
						 + "engulfs your vision, and you see a hulking figure in\n"
						 + "front of you. \"YOU THINK YOU CAN STAND UP TO ME? DO\n"
						 + "AS I SAY AND KILL THE WOMAN BEHIND YOU!\" Lunging your\n"
						 + "sword forward into the figure, you reject his demand\n"
						 + "and strike him down, and the wind begins to fade.\n"
						 + "\"I will never strike another friend down.\"\n"
						 + "Slowly the clouds over your vision fade, and the deadly\n"
						 + "thoughts in your head clearly leave. Then the voice\n"
						 + "booms, \"Hah, indeed it will not be friend, but family!\"\n"
						 + "The wind blows the hat from her head, and you see not\n"
						 + "the demon impaled by your sword, but your daughter,\n"
						 + "who had been trying to stand.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Shock engulfs her face, and she mutters, \"The wish!\n"
						 + "I want the wish! With it I could have ruled, slaughtered\n"
						 + "and taken as I pleased!\" Her voice is clouded, and\n"
						 + "something unnatural infects her tone. Falling to his\n"
						 + "knees, he shouts to the fiend \"What have you done to\n"
						 + "my daughter?!\" \"ME?! This tower protected itself by\n"
						 + "drawing out human greed! It's too late to knock her\n"
						 + "senses back, you'd best give up on her! Besides, you\n"
						 + "have a wish to claim, if you still have to motivation!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Content and vile excitement fill his voice as he basks\n"
						 + "in your agony. \"The only rules to this wish are that\n"
						 + "it cannot bring back the dead, and that to have it granted\n"
						 + "you must feed the altar’s mouth the blood of one close to\n"
						 + "you. So don't think you can save your poor friend Richard.\n"
						 + "As for Berem... he lied about his potions, and found a\n"
						 + "goblin fatal. You’ll never be able to return to your old\n"
						 + "life in the village after killing so many, perhaps you can\n"
						 + "use this wish to gain their trust! HAHAHAHA!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Standing you approach the altar, removing your blade\n"
						 + "from your daughters stomach and quickly demanding your wish.\n"
						 + "\"Heal my daughter's wounds, and free of her of the curse!\n"
						 + "Bring her back to the state of mental mind she had when\n"
						 + "she entered this damned tower, then obliterate the tower!\"\n"
						 + "Screaming these words, you slam the sword covered in\n"
						 + "blood into the altar. As the wish is granted, the voice echoes.\n"
						 + "\"DAMN YOU! This... This is cheating! You think your village\n"
						 + "will accept because you saved your own daughter’s life?!\n"
						 + "You will be shunned forever and you know it!\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Laughing, you watch as the tower begins to disappear\n"
						 + "brick by brick from top to bottom with satisfying pops.\n"
						 + "Running down the stairs, you grab the young woman and\n"
						 + "continue to sprint past room after room, descending as\n"
						 + "you hear the sounds of the damned spirit howling in pain.\n"
						 + "Reaching the bottom you collapse, energy spent and equipment lost.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Ending (Player player, Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("A week later, you arrive back at the village, and head\n"
						 + "straight to the tavern to prove those who laughed wrong.\n"
						 + "After much boasting and tales of your feat, you return\n"
						 + "home to rest, and to relieve your wife of here worry.\n"
						 + "Stepping into the door, you yell out proudly and open\n"
						 + "your arms for an embrace from your loving wife, and after\n"
						 + "a few minutes realize that no one is coming. Assuming she\n"
						 + "must be asleep, you step into the kitchen where your\n"
						 + "daughter stands shocked. She turns to you and asks,\n"
						 + "\"Dad… do you still intend to adventure anymore?\"\n"
						 + "Putting a hand on her head you shake your head \"No,\n"
						 + "nearly killing my daughter and killing two other men are\n"
						 + "signs enough that my adventure’s have reached their peak,\n"
						 + "and should be laid to rest before I worry your mother anymore.\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Your daughter removes a crumpled letter from her pocket,\n"
						 + "and looks away from you ashamed. You read the letter\n"
						 + "worriedly. \"I’m sorry honey, if you are reading this,\n"
						 + "then I worried myself for nothing, but I just couldn’t\n"
						 + "help it. I know I should have told you, but I used\n"
						 + "to be a powerful mage, and I taught our daughter some\n"
						 + "magic to defend herself, and you. I’m going to a dungeon\n"
						 + "that has the ability to bring those you wish to revive\n"
						 + "back to life, should you defeat it's creator, and one\n"
						 + "way or another, I will see you again soon.\"");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	
		System.out.println("--------------------------------------------------");
		System.out.println("Wiping the tears from his eyes, " + player.getName() + "turn towards\n"
						 + "his daughter. \"After all of this, how do you feel\n"
						 + "about adventuring now?\" She stops and thinks, then\n"
						 + "firmly responds \"Aside from the curse, it was honestly\n"
						 + "fun. But fun isn’t why I would go, and trust me, I\n"
						 + "will go save mom!\" Laughing, you pull her into a hug.\n"
						 + "\"As if I could let you go alone! Go grab your spell\n"
						 + "book, I still have a few wooden weapons in storage.\n"
						 + "If this dungeon is as tough as she claims, neither of\n"
						 + "us can do it on our own, so let's go as soon as possible!”");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Running about preparing for journey, you prepare for\n"
						 + "another gruelling fight! \"And that is how I came to\n"
						 + "adventure. But the tale of this second dungeon is longer\n"
						 + "than this one, and we could both use some sleep, now\n"
						 + "could we?\" " + player.getName() + " rises from next to his granddaughter's\n"
						 + "bed, and let's her get to sleep as he goes to do the same.");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public void Credits (Scanner input) {
		System.out.println("--------------------------------------------------");
		System.out.println("                     CREDITS                      ");
		System.out.println("--------------------------------------------------");
		System.out.println("Gameplay, Setting, and Coding By:");
		System.out.println("                 Jordan Campbell                  ");
		System.out.println("--------------------------------------------------");
		System.out.println("Story By:");
		System.out.println("              Twitch User PotentChaos             ");
		System.out.println("--------------------------------------------------");
		System.out.println("Created in 1 Month for St Clair MAD Club Hackathon");
		System.out.println("--------------------------------------------------");
		System.out.println("                Thanks For Playing!               ");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.print("Press ENTER to end the game...");
		input.nextLine();
	}
}