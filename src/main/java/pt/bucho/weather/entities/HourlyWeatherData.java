package pt.bucho.weather.entities;

import java.util.ArrayList;
import java.util.List;

public class HourlyWeatherData {

	private List<WeatherData> hourly;
	private String summary;
	private String icon;

	public HourlyWeatherData() {
		hourly = new ArrayList<WeatherData>(24);
	}

	public List<WeatherData> getHourly() {
		return hourly;
	}

	public int getHourDataSize() {
		return hourly != null ? hourly.size() : 0;
	}

	public void setData(int time, WeatherData weatherData) {
		if (time < 0) {
			throw new java.lang.IllegalArgumentException("Time must greater or equal than 0");
		}
		hourly.add(time, weatherData);
	}

	public WeatherData getData(int time) {
		if (time < 0) {
			throw new java.lang.IllegalArgumentException("Time must greater or equal than 0");
		}
		return hourly.get(time);
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
