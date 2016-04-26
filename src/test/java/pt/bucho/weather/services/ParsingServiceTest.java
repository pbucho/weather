package pt.bucho.weather.services;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.services.ParsingService;
import pt.bucho.weather.state.WeatherState;

/**
 * Asserts that a IPMA forecast page is properly parsed
 * @author Pedro Bucho
 *
 */
public class ParsingServiceTest {

	private ParsingService parsingService;
	
	private int expectedMax = 24;
	private int expectedMin = 13;
	
	private WeatherState expectedWS = WeatherState.CEU_POUCO_NUBLADO;
	
	@Before
	public void setUp() throws Exception {
		parsingService = new ParsingService("src/test/resources/test1.html");
	}

	@Test(expected = IOException.class)
	public void noFileTest() throws IOException {
		new ParsingService("dummy");
	}
	
	@Test
	public void temperatureTest() {
		int actualMax = parsingService.getMaxTemperature();
		int actualMin = parsingService.getMinTemperature();
		assertEquals(expectedMax, actualMax);
		assertEquals(expectedMin, actualMin);
	}
	
	@Test
	public void weatherStateTest() {
		WeatherState actualWS = parsingService.getWeatherState();
		assertEquals(expectedWS, actualWS);
	}

}
