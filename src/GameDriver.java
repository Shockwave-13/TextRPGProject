import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GameDriver {
	
	
	
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		Scanner ask = new Scanner(System.in);
		
		Weapons weapons = new Weapons();
		weapons.readWeaponsList();
		System.out.println(Arrays.toString(weapons.toStringArray()));
		//System.out.println(Arrays.toString(weapons.getWeaponName()));
		
		System.out.println();
		
		Player player = new Player();
		player.readSavefile();
		System.out.println(player);
		
		player.setGold(250);
		player.saveGame();
		
		System.out.println();
		
		
		//Name of world: Vallerin
		
		
		
		String welcome = "Welcome to Vallerin adventurer!";		
		printDelay(welcome);
		printDelay("This is so cool!!!!!!!!!!!!!!!!!!!!!");
		
		
		ask.close();
	}
	
	public static void printDelay (String text) throws InterruptedException {
		for (int i = 0; i < text.length(); i++) {
		    System.out.print(text.charAt(i));
		    Thread.sleep(25); // in milliseconds
		}
		System.out.println();
	}	

}