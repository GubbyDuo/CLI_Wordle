package wordle;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class EndGame {

	public static void winGame(String word, int guessCount) throws IOException, InterruptedException, ParseException {
		System.out.println("You won!!");
		System.out.println(String.format("You correctly guessed: %s", word));
		endGameProcedure(word);
		//emoji copy to clipboard.
	}
	
	public static void loseGame(String word) throws IOException, InterruptedException, ParseException {
		System.out.println("You have lost the game!");
		System.out.println(String.format("The correct word was %s", word));
		endGameProcedure(word);
	}
	
	public static void endGameProcedure(String word) throws IOException, InterruptedException, ParseException {
		ArrayList<String> meaningArr = ApiUtils.getDictionaryDefiniton(word);
		for(int i = 0; i < meaningArr.size(); i++) {
			System.out.println(String.format("Dictionary definition %d: %s", i+1, meaningArr.get(i)));
		}
	}
}
