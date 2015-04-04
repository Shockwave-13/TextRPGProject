import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Weapons {
	
	int numberOfWeapons = 0;
	String[] weaponName;
	String[] weaponDescription;	
	/* Weapon stats in array as follows:
	 * 0		1		2		3			4
	 * attack	defense	speed	buyPrice	sellPrice */
	int[][] weaponStats;
	
	String[] weaponStrings;
	
	public String[] getWeaponName() {
		return weaponName;
	}

	public String[] getWeaponDescription() {
		return weaponDescription;
	}

	public int[][] getWeaponStats() {
		return weaponStats;
	}
	
	public void updateNumberOfWeapons() throws FileNotFoundException {
		Scanner weaponsfile = new Scanner(new File("Resources/Weapons/WeaponsList.txt"));
		
		while (weaponsfile.hasNextLine()) {
			weaponsfile.nextLine();
			weaponsfile.nextLine();
			weaponsfile.nextLine();
			
			numberOfWeapons++;
			
			if(weaponsfile.hasNextLine()) weaponsfile.nextLine();
		}		
		weaponsfile.close();
		
		weaponName = new String[numberOfWeapons];
		weaponDescription = new String[numberOfWeapons];
		weaponStats = new int[numberOfWeapons][5];		
		weaponStrings = new String[numberOfWeapons];
	}
	
	public void readWeaponsList() throws FileNotFoundException {
		updateNumberOfWeapons();
		
		Scanner weaponsfile = new Scanner(new File("Resources/Weapons/WeaponsList.txt"));
		
		for (int i = 0; weaponsfile.hasNextLine(); i++) {
			
			weaponName[i] = weaponsfile.nextLine();
			//System.out.println(weaponName[i]);
			
			weaponStats[i][0] = weaponsfile.nextInt();
			weaponStats[i][1] = weaponsfile.nextInt();
			weaponStats[i][2] = weaponsfile.nextInt();
			weaponStats[i][3] = weaponsfile.nextInt();
			weaponStats[i][4] = weaponsfile.nextInt();
			//System.out.printf("%d %d %d %d %d%n", weaponStats[i][3], weaponStats[i][4], weaponStats[i][0], weaponStats[i][1], weaponStats[i][2]);
			
			weaponsfile.nextLine();
			
			weaponDescription[i] = weaponsfile.nextLine();
			//System.out.println(weaponDescription[i]);
			
			if(weaponsfile.hasNextLine()) weaponsfile.nextLine();
		}
		
		weaponsfile.close();
	}
	
	
	public String[] toStringArray() {
		for (int i = 0; i <= weaponName.length-1; i++) {
			
			weaponStrings[i] = String.format("%d)	Name: %s  Cost: %dG  Sell: %dG%n"
					+ "	Atk: %d  Def: %d  Spd: %d%n"
					+ "	Description: %s%n%n", i+1,
					weaponName[i], weaponStats[i][3], weaponStats[i][4], weaponStats[i][0], weaponStats[i][1], weaponStats[i][2], weaponDescription[i]);
		}
		
		return weaponStrings;
	}
	
}
