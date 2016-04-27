package pt.bucho.weather.services;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.AbstractTest;
import pt.bucho.weather.entities.WeatherForecast;
import pt.bucho.weather.state.WeatherState;

public class WeatherCollectingServiceTest extends AbstractTest {

	private ParsingService parsingService;
	private WeatherForecast expectedForecast;
	private DateTime expectedDate;
	
	@Before
	public void setUp() throws Exception {
		parsingService = new ParsingService("src/test/resources/test1.html");
		
		expectedDate = new DateTime(2016, 4, 25, 0, 0);
		expectedForecast = new WeatherForecast(24, 13, WeatherState.CEU_POUCO_NUBLADO, expectedDate);
	}

	@Test
	public void happyPath() {
		WeatherForecast actualForecast = parsingService.getForecast();
		assertEquals(expectedForecast.getMaxTemperature(), actualForecast.getMaxTemperature());
		assertEquals(expectedForecast.getMinTemperature(), actualForecast.getMinTemperature());
		assertEquals(expectedForecast.getWeatherState(), actualForecast.getWeatherState());
		assertEquals(expectedForecast.getForecastDate(), actualForecast.getForecastDate());
	}

}
