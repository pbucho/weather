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
	private Request request;

	public JSONFileParsingService(String filePath) {
		this.path = filePath;
	}

	public void parse() {
		request = new Request();
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(path));
			request.setLatitude((Double) json.get("latitude"));
			request.setLongitude((Double) json.get("longitude"));
			request.setTimezone(DateTimeZone.forID((String) json.get("timezone")));
			request.setOffset((Long) json.get("offset"));
			JSONObject currently = (JSONObject) json.get("currently");
			JSONObject hourly = (JSONObject) json.get("hourly");
			JSONObject daily = (JSONObject) json.get("daily");

			WeatherData currentlyData = new WeatherData();
			currentlyData.setTime(new DateTime((Long) currently.get("time") * 1000));
			currentlyData.setSummary(String.valueOf(currently.get("summary")));
			currentlyData.setIcon(String.valueOf(currently.get("icon")));
			currentlyData.setPrecipIntensity(parseDouble(currently.get("precipIntensity")));
			currentlyData.setPrecipProbability(parseDouble(currently.get("precipProbability")));
			currentlyData.setTemperature(parseDouble(currently.get("temperature")));
			currentlyData.setApparentTemperature(parseDouble(currently.get("apparentTemperature")));
			currentlyData.setDewPoint(parseDouble(currently.get("dewPoint")));
			currentlyData.setHumidity(parseDouble(currently.get("humidity")));
			currentlyData.setWindSpeed(parseDouble(currently.get("windSpeed")));
			currentlyData.setWindBearing(parseDouble(currently.get("windBearing")));
			currentlyData.setCloudCover(parseDouble(currently.get("cloudCover")));
			currentlyData.setPressure(parseDouble(currently.get("pressure")));
			currentlyData.setOzone(parseDouble(currently.get("ozone")));
			request.setCurrently(currentlyData);

			HourlyWeatherData hourlyData = new HourlyWeatherData();
			hourlyData.setSummary(String.valueOf(hourly.get("summary")));
			hourlyData.setIcon(String.valueOf(hourly.get("icon")));
			JSONArray hourlyArray = (JSONArray) hourly.get("data");
			for (int i = 0; i < hourlyArray.size(); i++) {
				JSONObject obj = (JSONObject) hourlyArray.get(i);
				WeatherData thisHour = new WeatherData();
				thisHour.setTime(new DateTime((Long) obj.get("time") * 1000));
				thisHour.setSummary(String.valueOf(obj.get("summary")));
				thisHour.setIcon(String.valueOf(obj.get("icon")));
				thisHour.setPrecipIntensity(parseDouble(obj.get("precipIntensity")));
				thisHour.setPrecipType(String.valueOf(obj.get("precipType")));
				thisHour.setPrecipProbability(parseDouble(obj.get("precipProbability")));
				thisHour.setTemperature(parseDouble(obj.get("temperature")));
				thisHour.setApparentTemperature(parseDouble(obj.get("apparentTemperature")));
				thisHour.setDewPoint(parseDouble(obj.get("dewPoint")));
				thisHour.setHumidity(parseDouble(obj.get("humidity")));
				thisHour.setWindSpeed(parseDouble(obj.get("windSpeed")));
				thisHour.setWindBearing(parseDouble(obj.get("windBearing")));
				thisHour.setCloudCover(parseDouble(obj.get("cloudCover")));
				thisHour.setPressure(parseDouble(obj.get("pressure")));
				thisHour.setOzone(parseDouble(obj.get("ozone")));
				hourlyData.setData(i, thisHour);
			}
			request.setHourly(hourlyData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Request getResult() {
		return request;
	}
	
	private static Double parseDouble(Object element) {
		if(element instanceof Double){
			return (Double) element;
		}else{
			String elem = String.valueOf(element);
			if(elem.equals("null")){
				return null;
			}else{
				return Double.parseDouble(elem);
			}
		}
	}

}
