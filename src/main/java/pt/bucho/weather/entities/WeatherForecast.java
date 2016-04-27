package pt.bucho.weather.entities;

import org.joda.time.DateTime;

import pt.bucho.weather.state.WeatherState;

public class WeatherForecast {
	
	private int maxTemperature;
	private int minTemperature;
	private WeatherState weatherState;
	private DateTime forecastDate;
	
	public WeatherForecast(int maxTemperature, int minTemperature,
			WeatherState weatherState) {
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.weatherState = weatherState;
		
		this.forecastDate = new DateTime();
	}
	
	public WeatherForecast(int maxTemperature, int minTemperature,
			WeatherState weatherState, DateTime forecastDate) {
		this(maxTemperature, minTemperature, weatherState);
		this.forecastDate = forecastDate;
	}

	public int getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(int maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public int getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(int minTemperature) {
		this.minTemperature = minTemperature;
	}

	public WeatherState getWeatherState() {
		return weatherState;
	}

	public void setWeatherState(WeatherState weatherState) {
		this.weatherState = weatherState;
	}

	public DateTime getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(DateTime forecastDate) {
		this.forecastDate = forecastDate;
	}
	
}
