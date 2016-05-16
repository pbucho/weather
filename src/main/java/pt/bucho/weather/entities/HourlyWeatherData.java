package pt.bucho.weather.entities;

public class HourlyWeatherData {

	private WeatherData[] hourly;

	public HourlyWeatherData() {
		hourly = new WeatherData[24];
		for (int i = 0; i < hourly.length; i++) {
			hourly[i] = new WeatherData();
		}
	}

	public WeatherData[] getHourly() {
		return hourly;
	}

	public void setHourly(WeatherData[] hourly) {
		this.hourly = hourly;
	}
	
	public void setData(int time, WeatherData weatherData) {
		if(time < 0 || time > 23){
			throw new java.lang.IllegalArgumentException("Time must be between 0 and 23");
		}
		hourly[time] = weatherData;
	}
	
	public WeatherData getData(int time) {
		if(time < 0 || time > 23){
			throw new java.lang.IllegalArgumentException("Time must be between 0 and 23");
		}
		return hourly[time];
	}

}
