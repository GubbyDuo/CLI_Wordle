package wordle;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StartGame {
	public static String getWord() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader fr = new FileReader("word-list.json");
		JSONArray wordList = (JSONArray) parser.parse(fr);
		return wordList.get((int) (Math.random() * (wordList.size()))).toString();
	}
}
