package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.entities.DailyWeatherData;
import pt.bucho.weather.entities.HourlyWeatherData;
import pt.bucho.weather.entities.JSONFileParsingService;
import pt.bucho.weather.entities.Request;
import pt.bucho.weather.entities.WeatherData;

public class JSONFileParsingServiceTest {

	private JSONParsingService parsingService;
	private Request expectedRequest;
	private Request actualRequest;
	
	@Before
	public void setUp() {
		expectedRequest = new Request();
		expectedRequest.setLatitude(38.425f);
		expectedRequest.setLongitude(-9.822f);
		expectedRequest.setTimezone(DateTimeZone.forID("Europe/Lisbon"));
		expectedRequest.setOffset(1);
		
		WeatherData currently = new WeatherData();
		currently.setTime(new DateTime(1463310000000L));
		currently.setSummary("Ligeiramente Nublado");
		currently.setIcon("partly-cloudy-day");
		currently.setPrecipIntensity(0);
		currently.setPrecipProbability(0);
		currently.setTemperature(15.51f);
		currently.setApparentTemperature(15.51f);
		currently.setDewPoint(12.45f);
		currently.setHumidity(0.81f);
		currently.setWindSpeed(7.45f);
		currently.setWindBearing(0);
		currently.setCloudCover(0.4f);
		currently.setPressure(1023.68f);
		currently.setOzone(347.55f);
		expectedRequest.setCurrently(currently);
		
		HourlyWeatherData hourly = new HourlyWeatherData();
		
		WeatherData hour0 = new WeatherData();
		hour0.setTime(new DateTime(1463266800000L));
		hour0.setSummary("Limpo");
		hour0.setIcon("clear-night");
		hour0.setPrecipIntensity(0);
		hour0.setPrecipProbability(0);
		hour0.setTemperature(14.93f);
		hour0.setApparentTemperature(14.93f);
		hour0.setDewPoint(11.97f);
		hour0.setHumidity(0.82f);
		hour0.setWindSpeed(7.4f);
		hour0.setWindBearing(350f);
		hour0.setCloudCover(0);
		hour0.setPressure(1024.19f);
		hour0.setOzone(352.38f);
		hourly.setData(0, hour0);
		
		WeatherData hour1 = new WeatherData();
		hour1.setTime(new DateTime(1463270400000L));
		hour1.setSummary("Limpo");
		hour1.setIcon("clear-night");
		hour1.setPrecipType("rain");
		hour1.setTemperature(14.86f);
		hour1.setApparentTemperature(14.86f);
		hour1.setDewPoint(11.97f);
		hour1.setHumidity(0.83f);
		hour1.setWindSpeed(7.53f);
		hour1.setWindBearing(352f);
		hour1.setPressure(1024.32f);
		hour1.setOzone(351.52f);
		hourly.setData(1, hour1);
		
		WeatherData hour2 = new WeatherData();
		hour2.setTime(new DateTime(1463274000000L));
		hour2.setSummary("Limpo");
		hour2.setIcon("clear-night");
		hour2.setPrecipIntensity(0);
		hour2.setPrecipProbability(0);
		hour2.setTemperature(14.81f);
		hour2.setApparentTemperature(14.81f);
		hour2.setDewPoint(11.99f);
		hour2.setHumidity(0.83f);
		hour2.setWindSpeed(7.58f);
		hour2.setWindBearing(355f);
		hour2.setCloudCover(0.19f);
		hour2.setPressure(1024.11f);
		hour2.setOzone(351.51f);
		hourly.setData(2, hour2);
		
		WeatherData hour3 = new WeatherData();
		hour3.setTime(new DateTime(1463277600000L));
		hour3.setSummary("Limpo");
		hour3.setIcon("clear-night");
		hour3.setPrecipIntensity(0);
		hour3.setPrecipProbability(0);
		hour3.setTemperature(14.76f);
		hour3.setApparentTemperature(14.76f);
		hour3.setDewPoint(12.01f);
		hour3.setHumidity(0.84f);
		hour3.setWindSpeed(7.6f);
		hour3.setWindBearing(358f);
		hour3.setCloudCover(0.19f);
		hour3.setPressure(1023.78f);
		hour3.setOzone(351.86f);
		hourly.setData(3, hour3);
		
		expectedRequest.setHourly(hourly);
		
		DailyWeatherData dailyData = new DailyWeatherData();
		dailyData.setTime(new DateTime(1463266800000L));
		dailyData.setSummary("Ligeiramente nublado até tarde e vento fraco começa durante a noite");
		dailyData.setIcon("wind");
		dailyData.setSunriseTime(new DateTime(1463290141000L));
		dailyData.setSunsetTime(new DateTime(1463341502000L));
		dailyData.setMoonPhase(0.3f);
		dailyData.setPrecipIntensity(0);
		dailyData.setPrecipIntensityMax(0);
		dailyData.setPrecipProbability(0);
		dailyData.setTemperatureMin(14.69f);
		dailyData.setTemperatureMinTime(new DateTime(1463288400000L));
		dailyData.setTemperatureMax(15.81f);
		dailyData.setTemperatureMaxTime(new DateTime(1463335200000L));
		dailyData.setApparentTemperatureMin(14.69f);
		dailyData.setApparentTemperatureMinTime(new DateTime(1463288400000L));
		dailyData.setApparentTemperatureMax(15.81f);
		dailyData.setApparentTemperatureMaxTime(new DateTime(1463335200000L));
		dailyData.setDewPoint(12.28f);
		dailyData.setHumidity(0.82f);
		dailyData.setWindSpeed(8.01f);
		dailyData.setWindBearing(356f);
		dailyData.setCloudCover(0.21f);
		dailyData.setPressure(1023.4f);
		dailyData.setOzone(349.4f);
		expectedRequest.setDaily(dailyData);
		
	}
	
	@Test
	public void happyPath() {
		parsingService = new JSONFileParsingService("src/test/resources/example1.json");
		parsingService.parse();
		
		assertEquals(expectedRequest, actualRequest);
	}
	
}