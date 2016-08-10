import java.util.Scanner;

public class Game {
	
	static Players[] player = new Players[2];
	
	static Scanner holder = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		playerSetup();
		
		while (player[0].shipsLeft != 0 && player[1].shipsLeft != 0)
		{
			int t = 0;
			while (t < 2)
			{
				System.out.println("Player: " + player[t].name);
				player[t].printOffenseGrid();
				System.out.println("_______________________________________\n");
				player[t].printDefenseGrid();
				fire(t);
				
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
						+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
						+ "Your turn is over. Please pass the device to your opponent."
						+ "\nOpponent, press enter when you have the device.");
				Scanner temp = new Scanner(System.in);
				String gameEnter = temp.nextLine();
				if (gameEnter.equals('\n') == false)
					t++;
			}
		}
	}
	
	
	// Players give names and setup ship positions
	public static void playerSetup() {
		for (int p = 0; p <= 1; p++)
		{
			// Set player name
			player[p] = new Players(p);
		}
	}
	
	
	// Fire player's shot
	public static void fire(int turn) {
		
		int opponent = 1 - turn;
		
		System.out.println("Enter shot:");
		
		System.out.print("X: ");
		int targetY = holder.nextInt() - 1;
		
		System.out.print("Y: ");
		int targetX = holder.nextInt() - 1;
		
		int opponentDefense = player[opponent].defenseGrid[targetX][targetY];
		
		if (opponentDefense == 1 | opponentDefense == 2 | opponentDefense == 3 | 
				opponentDefense == 4 | opponentDefense == 5)
		{
			System.out.println("Hit!");	
			player[opponent].ships[opponentDefense - 1].shipSpaces--;
			
			// Code to run if player sinks ship
			if (player[opponent].ships[opponentDefense - 1].shipSpaces == 0)
			{
				player[opponent].shipsLeft--;
				System.out.println("You sunk the " + player[opponent].ships[opponentDefense - 1].shipName + "!");
			}
			
			player[turn].offenseGrid[targetX][targetY] = 7;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			player[opponent].ships[opponentDefense - 1].shipSpaces--;
		} else {
			System.out.println("Miss.");
			player[turn].offenseGrid[targetX][targetY] = 6;
		}			
	}
	
}

