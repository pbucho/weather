package pt.bucho.weather.entities;

import org.joda.time.DateTime;

public class WeatherData {

	protected DateTime time;
	protected String summary;
	protected String icon;
	protected String precipType;
	protected float precipIntensity;
	protected float precipProbability;
	protected float temperature;
	protected float apparentTemperature;
	protected float dewPoint;
	protected float humidity;
	protected float windSpeed;
	protected float windBearing;
	protected float cloudCover;
	protected float pressure;
	protected float ozone;

	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
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

	public String getPrecipType() {
		return precipType;
	}

	public void setPrecipType(String precipType) {
		this.precipType = precipType;
	}

	public float getPrecipIntensity() {
		return precipIntensity;
	}

	public void setPrecipIntensity(float precipIntensity) {
		this.precipIntensity = precipIntensity;
	}

	public float getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(float precipProbability) {
		this.precipProbability = precipProbability;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(float apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}

	public float getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(float dewPoint) {
		this.dewPoint = dewPoint;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public float getWindBearing() {
		return windBearing;
	}

	public void setWindBearing(float windBearing) {
		this.windBearing = windBearing;
	}

	public float getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(float cloudCover) {
		this.cloudCover = cloudCover;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getOzone() {
		return ozone;
	}

	public void setOzone(float ozone) {
		this.ozone = ozone;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WeatherData)) {
			return false;
		}
		WeatherData oth = (WeatherData) other;
		if (!time.equals(oth.time)) {
			return false;
		}
		if (!summary.equals(oth.summary)) {
			return false;
		}
		if (!icon.equals(oth.icon)) {
			return false;
		}
		if (!precipType.equals(oth.precipType)) {
			return false;
		}
		if (precipIntensity != oth.precipIntensity) {
			return false;
		}
		if (precipProbability != oth.precipProbability) {
			return false;
		}
		if (temperature != oth.temperature) {
			return false;
		}
		if (apparentTemperature != oth.apparentTemperature) {
			return false;
		}
		if (dewPoint != oth.dewPoint) {
			return false;
		}
		if (humidity != oth.humidity) {
			return false;
		}
		if (windSpeed != oth.windSpeed) {
			return false;
		}
		if (windBearing != oth.windBearing) {
			return false;
		}
		if (cloudCover != oth.cloudCover) {
			return false;
		}
		return ozone == oth.ozone;
	}

}
