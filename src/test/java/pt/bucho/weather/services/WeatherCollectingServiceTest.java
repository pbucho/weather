package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.utilities.geopt.District;
import pt.bucho.weather.AbstractTest;
import pt.bucho.weather.entities.WeatherForecast;
import pt.bucho.weather.state.WeatherState;

public class WeatherCollectingServiceTest extends AbstractTest {

	private ParsingService parsingService;
	
	private DateTime expectedDate;
	
	@Before
	public void setUp() throws Exception {
		parsingService = new ParsingService("src/test/resources/test1.html");
		
		expectedDate = DateTime.parse("2016-04-25");
	}

	@Test
	public void happyPath() {
		WeatherForecast actualForecast = parsingService.getForecast();
		
		assertEquals(District.LISBOA, actualForecast.getForecastDistrict());
		assertEquals(24, actualForecast.getMaximumTemperature());
		assertEquals(13, actualForecast.getMinumumTemperature());
		assertEquals(WeatherState.CEU_POUCO_NUBLADO, actualForecast.getWeatherState());
		
		assertDate(actualForecast);
	}
	
	private void assertDate(WeatherForecast actualForecast) {
		DateTime actualDate = actualForecast.getForecastDate();
		assertEquals(expectedDate.getYear(), actualDate.getYear());
		assertEquals(expectedDate.getMonthOfYear(), actualDate.getMonthOfYear());
		assertEquals(expectedDate.getDayOfMonth(), actualDate.getDayOfMonth());
	}

}
