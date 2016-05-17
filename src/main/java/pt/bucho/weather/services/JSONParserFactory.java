package pt.bucho.weather.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public interface JSONParserFactory {
	
	public JSONObject getRoot() throws FileNotFoundException, IOException, ParseException;

}
