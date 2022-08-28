package wordle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiUtils {
	public static ArrayList<String> getDictionaryDefiniton(String word) throws IOException, InterruptedException, ParseException {
		ArrayList<String> definitionList = new ArrayList<String>();
		JSONParser jp = new JSONParser();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create(String.format("https://api.dictionaryapi.dev/api/v2/entries/en/%s", word)))
				.header("accept", "application/json")
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		JSONArray result = (JSONArray) jp.parse(response.body());
		JSONObject resultObj = (JSONObject) result.get(0);
		JSONArray meanings = (JSONArray) resultObj.get("meanings");
		JSONObject meaningsObj = (JSONObject) meanings.get(0);
		JSONArray definitions = (JSONArray) meaningsObj.get("definitions");
		
		
		for(int i = 0; i < 3; i++) {
			JSONObject definitionNo = (JSONObject) definitions.get(i);
			String definition = (String) definitionNo.get("definition");
			definitionList.add(definition);
		}
		return definitionList;

		
	}
}
