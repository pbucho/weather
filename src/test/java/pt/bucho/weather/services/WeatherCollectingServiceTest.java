package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.utilities.geopt.District;
import pt.bucho.weather.AbstractTest;
import pt.bucho.weather.entities.WeatherForecast;
import pt.bucho.weather.state.WeatherState;

public class WeatherCollectingServiceTest extends AbstractTest {

	private ParsingService parsingService;
	private WeatherForecast expectedForecast;
	
	@Before
	public void setUp() throws Exception {
		parsingService = new ParsingService("src/test/resources/test1.html");
		
		expectedForecast.setForecastDistrict(District.LISBOA);
		expectedForecast.setMaximumTemperature(24);
		expectedForecast.setMinumumTemperature(13);
		expectedForecast.setWeatherState(WeatherState.CEU_POUCO_NUBLADO);
	}

	@Test
	public void happyPath() {
		WeatherForecast actualForecast = parsingService.getForecast();
		
		assertEquals(expectedForecast.getForecastDistrict(), actualForecast.getForecastDistrict());
		assertEquals(expectedForecast.getMaximumTemperature(), actualForecast.getMaximumTemperature());
		assertEquals(expectedForecast.getMinumumTemperature(), actualForecast.getMinumumTemperature());
		assertEquals(expectedForecast.getWeatherState(), actualForecast.getWeatherState());
	}

}
