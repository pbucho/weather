package pt.bucho.weather.entities;

import org.joda.time.DateTime;

public class DailyWeatherData extends WeatherData {

	private DateTime sunriseTime;
	private DateTime sunsetTime;
	private float moonPhase;
	private float precipIntensityMax;
	private float temperatureMin;
	private DateTime temperatureMinTime;
	private float temperatureMax;
	private DateTime temperatureMaxTime;
	private float apparentTemperatureMin;
	private DateTime apparentTemperatureMinTime;
	private float apparentTemperatureMax;
	private DateTime apparentTemperatureMaxTime;

	public DateTime getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(DateTime sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public DateTime getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(DateTime sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	public float getMoonPhase() {
		return moonPhase;
	}

	public void setMoonPhase(float moonPhase) {
		this.moonPhase = moonPhase;
	}

	public float getPrecipIntensityMax() {
		return precipIntensityMax;
	}

	public void setPrecipIntensityMax(float precipIntensityMax) {
		this.precipIntensityMax = precipIntensityMax;
	}

	public float getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(float temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public DateTime getTemperatureMinTime() {
		return temperatureMinTime;
	}

	public void setTemperatureMinTime(DateTime temperatureMinTime) {
		this.temperatureMinTime = temperatureMinTime;
	}

	public float getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(float temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public DateTime getTemperatureMaxTime() {
		return temperatureMaxTime;
	}

	public void setTemperatureMaxTime(DateTime temperatureMaxTime) {
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public float getApparentTemperatureMin() {
		return apparentTemperatureMin;
	}

	public void setApparentTemperatureMin(float apparentTemperatureMin) {
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public DateTime getApparentTemperatureMinTime() {
		return apparentTemperatureMinTime;
	}

	public void setApparentTemperatureMinTime(DateTime apparentTemperatureMinTime) {
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public float getApparentTemperatureMax() {
		return apparentTemperatureMax;
	}

	public void setApparentTemperatureMax(float apparentTemperatureMax) {
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public DateTime getApparentTemperatureMaxTime() {
		return apparentTemperatureMaxTime;
	}

	public void setApparentTemperatureMaxTime(DateTime apparentTemperatureMaxTime) {
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

}
