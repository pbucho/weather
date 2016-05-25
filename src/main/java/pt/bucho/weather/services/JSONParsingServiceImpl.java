package pt.bucho.weather.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pt.bucho.weather.entities.DailyWeatherData;
import pt.bucho.weather.entities.HourlyWeatherData;
import pt.bucho.weather.entities.Report;
import pt.bucho.weather.entities.WeatherData;

public class JSONParsingServiceImpl implements JSONParsingService {

	private JSONParserFactory parserFactory;
	private DistrictMappingService mappingService = DistrictMappingService.getInstance();
	
	private Report report;

	public JSONParsingServiceImpl(JSONParserFactory parserFactory) {
		this.parserFactory = parserFactory;
	}
	
	public void parse() {
		report = new Report();
		try {
			JSONObject json = parserFactory.getRoot();
			Double latitude = (Double) json.get("latitude");
			Double longitude = (Double) json.get("longitude");
			report.setDistrict(mappingService.getDistrictByCoordinates(latitude, longitude));
			report.setTimezone((String) json.get("timezone"));
			report.setTimezoneOffset((Long) json.get("offset"));
			JSONObject currently = (JSONObject) json.get("currently");
			JSONObject hourly = (JSONObject) json.get("hourly");
			JSONObject daily = (JSONObject) json.get("daily");

			WeatherData currentlyData = new WeatherData();
			currentlyData.setTime((Long) currently.get("time") * 1000);
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
			report.setCurrently(currentlyData);

			HourlyWeatherData hourlyData = new HourlyWeatherData();
			hourlyData.setSummary(String.valueOf(hourly.get("summary")));
			hourlyData.setIcon(String.valueOf(hourly.get("icon")));
			JSONArray hourlyArray = (JSONArray) hourly.get("data");
			for (int i = 0; i < hourlyArray.size(); i++) {
				JSONObject obj = (JSONObject) hourlyArray.get(i);
				WeatherData thisHour = new WeatherData();
				thisHour.setTime(parseLong(obj.get("time")) * 1000);
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
			report.setHourly(hourlyData);
			
			daily = (JSONObject) ((JSONArray) daily.get("data")).get(0);
			DailyWeatherData dailyData = new DailyWeatherData();
			dailyData.setTime(parseTimestamp(daily.get("time")));
			dailyData.setSummary(String.valueOf(daily.get("summary")));
			dailyData.setIcon(String.valueOf(daily.get("icon")));
			dailyData.setSunriseTime(parseTimestamp(daily.get("sunriseTime")));
			dailyData.setSunsetTime(parseTimestamp(daily.get("sunsetTime")));
			dailyData.setMoonPhase(parseDouble(daily.get("moonPhase")));
			dailyData.setPrecipIntensity(parseDouble(daily.get("precipIntensity")));
			dailyData.setPrecipIntensityMax(parseDouble(daily.get("precipIntensityMax")));
			dailyData.setPrecipProbability(parseDouble(daily.get("precipProbability")));
			dailyData.setTemperatureMin(parseDouble(daily.get("temperatureMin")));
			dailyData.setTemperatureMinTime(parseTimestamp(daily.get("temperatureMinTime")));
			dailyData.setTemperatureMax(parseDouble(daily.get("temperatureMax")));
			dailyData.setTemperatureMaxTime(parseTimestamp(daily.get("temperatureMaxTime")));
			dailyData.setApparentTemperatureMin(parseDouble(daily.get("apparentTemperatureMin")));
			dailyData.setApparentTemperatureMinTime(parseTimestamp(daily.get("apparentTemperatureMinTime")));
			dailyData.setApparentTemperatureMax(parseDouble(daily.get("apparentTemperatureMax")));
			dailyData.setApparentTemperatureMaxTime(parseTimestamp(daily.get("apparentTemperatureMaxTime")));
			dailyData.setDewPoint(parseDouble(daily.get("dewPoint")));
			dailyData.setHumidity(parseDouble(daily.get("humidity")));
			dailyData.setWindSpeed(parseDouble(daily.get("windSpeed")));
			dailyData.setWindBearing(parseDouble(daily.get("windBearing")));
			dailyData.setCloudCover(parseDouble(daily.get("cloudCover")));
			dailyData.setPressure(parseDouble(daily.get("pressure")));
			dailyData.setOzone(parseDouble(daily.get("ozone")));
			report.setDaily(dailyData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Report getReport() {
		return report;
	}
	
	private static Double parseDouble(Object element) {
		if(element instanceof Double){
			return (Double) element;
		}else{
			String elem = String.valueOf(element);
			if(elem.equals("null"))
				return null;
			else
				return Double.parseDouble(elem);
		}
	}
	
	private static Long parseLong(Object element) {
		if(element instanceof Long) {
			return (Long) element;
		}else{
			String elem = String.valueOf(element);
			if(elem.equals("null"))
				return null;
			else
				return Long.parseLong(elem);
		}
	}
	
	private static Long parseTimestamp(Object element) {
		Long parsedLong = parseLong(element);
		if(parsedLong == null)
			return null;
		else
			return parsedLong * 1000;
	}
	
}
