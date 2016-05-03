package pt.bucho.weather.entities;

import java.util.Map;

import org.joda.time.DateTime;

public class WeatherPage {
	
	private Map<DateTime, WeatherForecast> forecastMap;
	
	public WeatherPage(Map<DateTime, WeatherForecast> forecastMap) {
		checkMapArgument(forecastMap);
		this.forecastMap = forecastMap;
	}
	
	public Map<DateTime, WeatherForecast> getForecastMap() {
		return forecastMap;
	}

	public void setForecastMap(Map<DateTime, WeatherForecast> forecastMap) {
		checkMapArgument(forecastMap);
		this.forecastMap = forecastMap;
	}

	private static void checkMapArgument(Map<DateTime, WeatherForecast> forecastMap) {
		if(forecastMap.size() != 10){
			throw new IllegalArgumentException("Forecast map must contain exactly 10 items");
		}
	}

}
