import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class hangman {

	public static void main(String[] args) {
		
		GameSetup game = new GameSetup();
		game.life = 10;
		game.rightLetters = 0;
		game.SetArray();
		
		try{
			
			FileReader inputText = new FileReader("dictionary.txt");
			BufferedReader reader = new BufferedReader(inputText);
			String line = null;
			while((line = reader.readLine()) != null){
				
				game.wordBank.add(line);
				
			}
			reader.close();
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
		game.setWord();
		
		while (game.life > 0 && game.rightLetters < game.chosenWordLength){
			game.printHangman(game.life);
			game.printChosen(game.rightLetters);
			game.printLives(game.life);
			game.printLetters();
			game.chooseLetter();
		}
			
			game.endScreen();
			
	}

}