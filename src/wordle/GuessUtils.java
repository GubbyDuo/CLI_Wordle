package wordle;

import java.util.ArrayList;

public class GuessUtils {
	
	
	public static String incorrectGuess(String chosen, String guess) {
		ArrayList<String> responseList = new ArrayList<String>(5);
		for(int i = 0; i < chosen.length(); i++) {
			String guessChar = Character.toString(guess.charAt(i));
			String chosenChar = Character.toString(chosen.charAt(i));
			if(guessChar.equals(chosenChar)) {
				responseList.add(String.format("\u001B[32m%s\u001b[0m", guessChar));
			}else if(chosen.indexOf(guessChar) != -1){
				responseList.add(String.format("\u001B[33m%s\u001b[0m", guessChar));
			}else {
				responseList.add(String.format("\u001b[1;31m%s\u001b[0m", guessChar));
			}
		}
		return String.join("", responseList);
	}
}
