import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Player {
	
	//Player's attributes
	String name;
	int gold;
	int health;
	int maxHealth;
	int experience;
	int expTillNextLevel;
	int level;
	int attack;
	int defense;
	int speed;
	
	
	public void readSavefile() throws FileNotFoundException {
		Scanner savefile = new Scanner(new File("Save_Files/Save1.txt"));
		
		name = savefile.next();
		gold = savefile.nextInt();
		health = savefile.nextInt();
		maxHealth = savefile.nextInt();
		experience = savefile.nextInt();
		expTillNextLevel = savefile.nextInt();
		level = savefile.nextInt();
		attack = savefile.nextInt();
		defense = savefile.nextInt();
		speed = savefile.nextInt();
		
		savefile.close();
	}
	
	public void saveGame() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("Save_Files/Save1.txt");
		
		pw.println(name + " " + gold);
		pw.println(health + " " + maxHealth + " " + experience + " " + expTillNextLevel + " " + level);
		pw.println(attack + " " + defense + " " + speed);
		pw.println();
		pw.println("Formatted as follows:");
		pw.println("Name Gold");
		pw.println("Health MaxHealth Experience ExpTillNextLevel Level");
		pw.println("Attack Defense Speed");
		
		pw.close();
		
	}
	
	//Accessors & Mutators-----------------------------------------
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getExperience() {
		return experience;
	}

	public int getExpTillNextLevel() {
		return expTillNextLevel;
	}

	public int getLevel() {
		return level;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpeed() {
		return speed;
	}

	public int getGold() {
		return gold;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void setExpTillNextLevel(int expTillNextLevel) {
		this.expTillNextLevel = expTillNextLevel;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	//-------------------------------------------------------------------------------------
	
	public void updateExpTillNextLevel() {
		if (level >= 1 && level <=6) expTillNextLevel = level*15;
		if (level < 10 && level > 6) expTillNextLevel = (int) Math.pow(2, level);
		if (level >= 10) expTillNextLevel = 1000*(level-9);
	}
	
	public void goldReward(int reward) {
		gold += reward;
	}
	
	public String toString() {
		return String.format("Name: %s  Gold: %d%n"
				+ "Health: %d/%d  Experience: %d/%d  Level: %d%n"
				+ "Attack: %d  Defense: %d  Speed: %d", name, gold, health, maxHealth, experience, expTillNextLevel, level, attack, defense, speed);
	}

}
