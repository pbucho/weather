package pt.bucho.weather.entities;

import org.joda.time.DateTimeZone;

public class Request {

	private float latitude;
	private float longitude;
	private DateTimeZone timezone;
	private int offset;
	private WeatherData currently;
	private HourlyWeatherData hourly;
	private DailyWeatherData daily;

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public DateTimeZone getTimezone() {
		return timezone;
	}

	public void setTimezone(DateTimeZone timezone) {
		this.timezone = timezone;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
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

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Request)) {
			return false;
		}
		Request oth = (Request) other;
		if (latitude != oth.latitude) {
			return false;
		}
		if (longitude != oth.longitude) {
			return false;
		}
		if (!timezone.equals(oth.timezone)) {
			return false;
		}
		if (offset != oth.offset) {
			return false;
		}
		if (!currently.equals(oth.currently)) {
			return false;
		}
		if (!hourly.equals(oth.hourly)) {
			return false;
		}
		return daily.equals(oth.daily);
	}

}
