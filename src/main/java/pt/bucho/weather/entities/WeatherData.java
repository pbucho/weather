package pt.bucho.weather.entities;

import org.joda.time.DateTime;

public class WeatherData {

	protected DateTime time;
	protected String summary;
	protected String icon;
	protected String precipType;
	protected double precipIntensity;
	protected double precipProbability;
	protected double temperature;
	protected double apparentTemperature;
	protected double dewPoint;
	protected double humidity;
	protected double windSpeed;
	protected double windBearing;
	protected double cloudCover;
	protected double pressure;
	protected double ozone;

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

	public double getPrecipIntensity() {
		return precipIntensity;
	}

	public void setPrecipIntensity(double precipIntensity) {
		this.precipIntensity = precipIntensity;
	}

	public double getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(double precipProbability) {
		this.precipProbability = precipProbability;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(double apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}

	public double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(double dewPoint) {
		this.dewPoint = dewPoint;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindBearing() {
		return windBearing;
	}

	public void setWindBearing(double windBearing) {
		this.windBearing = windBearing;
	}

	public double getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(double cloudCover) {
		this.cloudCover = cloudCover;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getOzone() {
		return ozone;
	}

	public void setOzone(double ozone) {
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
