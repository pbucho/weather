package pt.bucho.weather.entities;

import org.joda.time.DateTimeZone;

public class Report {

	private double latitude;
	private double longitude;
	private DateTimeZone timezone;
	private long offset;
	private WeatherData currently;
	private HourlyWeatherData hourly;
	private DailyWeatherData daily;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public DateTimeZone getTimezone() {
		return timezone;
	}

	public void setTimezone(DateTimeZone timezone) {
		this.timezone = timezone;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public WeatherData getCurrently() {
		return currently;
	}

	public void setCurrently(WeatherData currently) {
		this.currently = currently;
	}

	public HourlyWeatherData getHourly() {
		return hourly;
	}

	public void setHourly(HourlyWeatherData hourly) {
		this.hourly = hourly;
	}

	public DailyWeatherData getDaily() {
		return daily;
	}

	public void setDaily(DailyWeatherData daily) {
		this.daily = daily;
	}

}
