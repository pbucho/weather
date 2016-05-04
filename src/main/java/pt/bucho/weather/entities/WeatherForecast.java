package pt.bucho.weather.entities;

import org.joda.time.DateTime;

import pt.bucho.utilities.geopt.District;
import pt.bucho.weather.state.UVIndex;
import pt.bucho.weather.state.WeatherState;
import pt.bucho.weather.state.WeatherWarning;

public class WeatherForecast {

	private final DateTime forecastDate;
	
	private District forecastDistrict;
	private int maximumTemperature;
	private int minumumTemperature;
	private WeatherState weatherState;
	private int precipitationProb;
	private WindState windState;
	private UVIndex uvIndex;
	private WeatherWarning weatherWarning;
	
	public WeatherForecast(DateTime forecastDate) {
		this.forecastDate = forecastDate;
	}
	
	public DateTime getForecastDate() {
		return forecastDate;
	}
	
	public District getForecastDistrict() {
		return forecastDistrict;
	}

	public void setForecastDistrict(District forecastDistrict) {
		this.forecastDistrict = forecastDistrict;
	}

	public int getMaximumTemperature() {
		return maximumTemperature;
	}
	
	public void setMaximumTemperature(int maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	
	public int getMinumumTemperature() {
		return minumumTemperature;
	}
	
	public void setMinumumTemperature(int minumumTemperature) {
		this.minumumTemperature = minumumTemperature;
	}
	
	public WeatherState getWeatherState() {
		return weatherState;
	}
	
	public void setWeatherState(WeatherState weatherState) {
		this.weatherState = weatherState;
	}
	
	public int getPrecipitationProb() {
		return precipitationProb;
	}
	
	public void setPrecipitationProb(int precipitationProb) {
		this.precipitationProb = precipitationProb;
	}
	
	public WindState getWindState() {
		return windState;
	}
	
	public void setWindState(WindState windState) {
		this.windState = windState;
	}
	
	public UVIndex getUvIndex() {
		return uvIndex;
	}
	
	public void setUvIndex(UVIndex uvIndex) {
		this.uvIndex = uvIndex;
	}
	
	public WeatherWarning getWeatherWarning() {
		return weatherWarning;
	}
	
	public void setWeatherWarning(WeatherWarning weatherWarning) {
		this.weatherWarning = weatherWarning;
	}
	
}
