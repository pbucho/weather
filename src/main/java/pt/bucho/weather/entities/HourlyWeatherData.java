package pt.bucho.weather.entities;

public class HourlyWeatherData {

	private WeatherData[] hourly;
	private String summary;
	private String icon;

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
		if (time < 0 || time > 23) {
			throw new java.lang.IllegalArgumentException(
					"Time must be between 0 and 23");
		}
		hourly[time] = weatherData;
	}

	public WeatherData getData(int time) {
		if (time < 0 || time > 23) {
			throw new java.lang.IllegalArgumentException(
					"Time must be between 0 and 23");
		}
		return hourly[time];
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
	
	@Override
	public boolean equals(Object other) {
		if(this == other){
			return true;
		}
		if(!(other instanceof HourlyWeatherData)){
			return false;
		}
		HourlyWeatherData oth = (HourlyWeatherData) other;
		if(!summary.equals(oth.summary)){
			return false;
		}
		if(!icon.equals(oth.icon)){
			return false;
		}
		if(hourly.length != oth.hourly.length){
			return false;
		}
		for(int i = 0; i < hourly.length; i++){
			if(!hourly[i].equals(oth.hourly[i])){
				return false;
			}
		}
		return true;
	}

}
