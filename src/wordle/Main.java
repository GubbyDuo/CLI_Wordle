package wordle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		System.out.println("Welcome to Wordle.");
		System.out.println("You know the gist");
		System.out.println("A \u001B[32mgreen\u001b[0m letter indicates the correct character in the correct position");
		System.out.println("A \u001B[33myellow\u001b[0m letter indicates the correct character in the wrong position");
		System.out.println("A \u001b[1;31mred\u001b[0m letter indicates an incorrect character");
		ArrayList<String> guessArr = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String chosenWord = StartGame.getWord();
		int guessCounter = 0;
		
		
		while(guessCounter < 6) {
			System.out.println("Enter Word: ");
			String myGuess = s.nextLine();
			if(myGuess.length() == 5) {
				if(myGuess.equals(chosenWord)) {
					EndGame.winGame(chosenWord, guessCounter);
					break;
				} else {
					String result = GuessUtils.incorrectGuess(chosenWord, myGuess);
					System.out.println(result);
					guessArr.add(result);
				}
				guessCounter++;
				if(guessCounter < 6) {
					System.out.println(String.format("You have %s guess(es) left", 6 - guessCounter));					
				}else {
					EndGame.loseGame(chosenWord);
				}
			}else if(myGuess.length() != 5) {
				System.out.println("Invalid string! Please make sure your entered word is 6 characters long");				
			}
		}
		s.close();
		
		
	}
}
