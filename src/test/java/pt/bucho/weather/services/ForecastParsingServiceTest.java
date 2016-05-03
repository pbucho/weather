package pt.bucho.weather.services;

import static org.junit.Assert.fail;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.entities.WindState;
import pt.bucho.weather.state.UVIndex;
import pt.bucho.weather.state.WeatherState;
import pt.bucho.weather.state.WeatherWarning;

public class ForecastParsingServiceTest {

	private ForecastCollectingService fcService;
	
	private DateTime expectedDate;
	private int expectedMinimum;
	private int expectedMaximum;
	private WeatherState expectedWState;
	private int expectedPrecipitationProb;
	private WindState expectedWindState;
	private UVIndex expectedUVIndex;
	private WeatherWarning expectedWeatherWarning;
	
	@Before
	public void setUp() {
		
		expectedMinimum = 13;
		expectedMaximum = 24;
		
	}
	
	@Test
	public void happyPath() {
		fcService = new ForecastCollectingService();
	}

}
