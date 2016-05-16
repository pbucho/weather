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
		currently.setPrecipIntensity(0d);
		currently.setPrecipProbability(0d);
		currently.setTemperature(15.51d);
		currently.setApparentTemperature(15.51d);
		currently.setDewPoint(12.45d);
		currently.setHumidity(0.81d);
		currently.setWindSpeed(7.45d);
		currently.setWindBearing(0d);
		currently.setCloudCover(0.4d);
		currently.setPressure(1023.68d);
		currently.setOzone(347.55d);
		expectedRequest.setCurrently(currently);
		
		HourlyWeatherData hourly = new HourlyWeatherData();
		hourly.setSummary("Ligeiramente nublado começa esta manhã, continua até à tarde, e vento fraco começa durante a noite.");
		hourly.setIcon("wind");
		
		WeatherData hour0 = new WeatherData();
		hour0.setTime(new DateTime(1463266800000L));
		hour0.setSummary("Limpo");
		hour0.setIcon("clear-night");
		hour0.setPrecipIntensity(0d);
		hour0.setPrecipProbability(0d);
		hour0.setTemperature(14.93d);
		hour0.setApparentTemperature(14.93d);
		hour0.setDewPoint(11.97d);
		hour0.setHumidity(0.82d);
		hour0.setWindSpeed(7.4d);
		hour0.setWindBearing(350d);
		hour0.setCloudCover(0d);
		hour0.setPressure(1024.19d);
		hour0.setOzone(352.38d);
		hourly.setData(0, hour0);
		
		WeatherData hour1 = new WeatherData();
		hour1.setTime(new DateTime(1463270400000L));
		hour1.setSummary("Limpo");
		hour1.setIcon("clear-night");
		hour1.setPrecipType("rain");
		hour1.setTemperature(14.86d);
		hour1.setApparentTemperature(14.86d);
		hour1.setDewPoint(11.97d);
		hour1.setHumidity(0.83d);
		hour1.setWindSpeed(7.53d);
		hour1.setWindBearing(352d);
		hour1.setPressure(1024.32d);
		hour1.setOzone(351.52d);
		hourly.setData(1, hour1);
		
		WeatherData hour2 = new WeatherData();
		hour2.setTime(new DateTime(1463274000000L));
		hour2.setSummary("Limpo");
		hour2.setIcon("clear-night");
		hour2.setPrecipIntensity(0d);
		hour2.setPrecipProbability(0d);
		hour2.setTemperature(14.81d);
		hour2.setApparentTemperature(14.81d);
		hour2.setDewPoint(11.99d);
		hour2.setHumidity(0.83d);
		hour2.setWindSpeed(7.58d);
		hour2.setWindBearing(355d);
		hour2.setCloudCover(0.19d);
		hour2.setPressure(1024.11d);
		hour2.setOzone(351.51d);
		hourly.setData(2, hour2);
		
		WeatherData hour3 = new WeatherData();
		hour3.setTime(new DateTime(1463277600000L));
		hour3.setSummary("Limpo");
		hour3.setIcon("clear-night");
		hour3.setPrecipIntensity(0d);
		hour3.setPrecipProbability(0d);
		hour3.setTemperature(14.76d);
		hour3.setApparentTemperature(14.76d);
		hour3.setDewPoint(12.01d);
		hour3.setHumidity(0.84d);
		hour3.setWindSpeed(7.6d);
		hour3.setWindBearing(358d);
		hour3.setCloudCover(0.19d);
		hour3.setPressure(1023.78d);
		hour3.setOzone(351.86d);
		hourly.setData(3, hour3);
		
		expectedRequest.setHourly(hourly);
		
		DailyWeatherData dailyData = new DailyWeatherData();
		dailyData.setTime(new DateTime(1463266800000L));
		dailyData.setSummary("Ligeiramente nublado até tarde e vento fraco começa durante a noite");
		dailyData.setIcon("wind");
		dailyData.setSunriseTime(new DateTime(1463290141000L));
		dailyData.setSunsetTime(new DateTime(1463341502000L));
		dailyData.setMoonPhase(0.3f);
		dailyData.setPrecipIntensity(0d);
		dailyData.setPrecipIntensityMax(0);
		dailyData.setPrecipProbability(0d);
		dailyData.setTemperatureMin(14.69f);
		dailyData.setTemperatureMinTime(new DateTime(1463288400000L));
		dailyData.setTemperatureMax(15.81f);
		dailyData.setTemperatureMaxTime(new DateTime(1463335200000L));
		dailyData.setApparentTemperatureMin(14.69f);
		dailyData.setApparentTemperatureMinTime(new DateTime(1463288400000L));
		dailyData.setApparentTemperatureMax(15.81f);
		dailyData.setApparentTemperatureMaxTime(new DateTime(1463335200000L));
		dailyData.setDewPoint(12.28d);
		dailyData.setHumidity(0.82d);
		dailyData.setWindSpeed(8.01d);
		dailyData.setWindBearing(356d);
		dailyData.setCloudCover(0.21d);
		dailyData.setPressure(1023.4d);
		dailyData.setOzone(349.4d);
		expectedRequest.setDaily(dailyData);
		
	}
	
	@Test
	public void happyPath() {
		parsingService = new JSONFileParsingService("src/test/resources/example1.json");
		parsingService.parse();
		actualRequest = parsingService.getResult();
		
		assertEquals(expectedRequest, actualRequest);
	}
	
}
