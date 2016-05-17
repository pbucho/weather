package pt.bucho.weather.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LocalJSONFactory implements JSONParserFactory {

	private String path;
	
	public LocalJSONFactory(String path) {
		this.path = path;
	}
	
	public JSONObject getRoot() throws FileNotFoundException, IOException, ParseException {
		return (JSONObject) new JSONParser().parse(new FileReader(path));
	}

}
