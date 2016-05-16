package pt.bucho.weather.entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pt.bucho.weather.services.JSONParsingService;

public class JSONFileParsingService implements JSONParsingService {

	private String path;

	public JSONFileParsingService(String filePath) {
		this.path = filePath;
	}

	public void parse() {
		Request request = new Request();
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(path));
			request.setLatitude((Float) json.get("latitude"));
			request.setLongitude((Float) json.get("longitude"));
			request.setTimezone(DateTimeZone.forID((String) json.get("timezone")));
			request.setOffset((Integer) json.get("offset"));
			JSONObject currently = (JSONObject) ((JSONArray) json.get("currently")).get(0);
			JSONArray hourly = (JSONArray) json.get("hourly");
			JSONArray daily = (JSONArray) json.get("daily");

			WeatherData currentlyData = new WeatherData();
			currentlyData.setTime(new DateTime(Long.parseLong(((String) currently.get("time")) + "000")));
			currentlyData.setSummary((String) currently.get("summary"));
			currentlyData.setIcon((String) currently.get("icon"));
			currentlyData.setPrecipIntensity((Float) currently.get("precipIntensity"));
			currentlyData.setPrecipProbability((Float) currently.get("precipProbability"));
			currentlyData.setTemperature((Float) currently.get("temperature"));
			currentlyData.setApparentTemperature((Float) currently.get("apparentTemperature"));
			currentlyData.setDewPoint((Float) currently.get("dewPoint"));
			currentlyData.setHumidity((Float) currently.get("humidity"));
			currentlyData.setWindSpeed((Float) currently.get("windSpeed"));
			currentlyData.setWindBearing((Float) currently.get("windBearing"));
			currentlyData.setCloudCover((Float) currently.get("cloudCover"));
			currentlyData.setPressure((Float) currently.get("pressure"));
			currentlyData.setOzone((Float) currently.get("ozone"));
			request.setCurrently(currentlyData);

			HourlyWeatherData hourlyData = new HourlyWeatherData();
			for (int i = 0; i < hourly.size(); i++) {
				JSONObject obj = (JSONObject) hourly.get(i);
				WeatherData thisHour = new WeatherData();
				thisHour.setTime(new DateTime(Long.parseLong(((String) obj.get("time")) + "000")));
				thisHour.setSummary((String) obj.get("summary"));
				thisHour.setIcon((String) obj.get("icon"));
				thisHour.setPrecipIntensity((Float) obj.get("precipIntensity"));
				thisHour.setPrecipProbability((Float) obj.get("precipProbability"));
				thisHour.setTemperature((Float) obj.get("temperature"));
				thisHour.setApparentTemperature((Float) obj.get("apparentTemperature"));
				thisHour.setDewPoint((Float) obj.get("dewPoint"));
				thisHour.setHumidity((Float) obj.get("humidity"));
				thisHour.setWindSpeed((Float) obj.get("windSpeed"));
				thisHour.setWindBearing((Float) obj.get("windBearing"));
				thisHour.setCloudCover((Float) obj.get("cloudCover"));
				thisHour.setPressure((Float) obj.get("pressure"));
				thisHour.setOzone((Float) obj.get("ozone"));
				hourlyData.setData(i, thisHour);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
