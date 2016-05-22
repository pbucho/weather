package pt.bucho.weather.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "daily_data")
public class DailyWeatherData extends WeatherData {

	private DateTime sunriseTime;
	private DateTime sunsetTime;
	private Double moonPhase;
	private Double precipIntensityMax;
	private Double temperatureMin;
	private DateTime temperatureMinTime;
	private Double temperatureMax;
	private DateTime temperatureMaxTime;
	private Double apparentTemperatureMin;
	private DateTime apparentTemperatureMinTime;
	private Double apparentTemperatureMax;
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

	public Double getMoonPhase() {
		return moonPhase;
	}

	public void setMoonPhase(Double moonPhase) {
		this.moonPhase = moonPhase;
	}

	public Double getPrecipIntensityMax() {
		return precipIntensityMax;
	}

	public void setPrecipIntensityMax(Double precipIntensityMax) {
		this.precipIntensityMax = precipIntensityMax;
	}

	public Double getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(Double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public DateTime getTemperatureMinTime() {
		return temperatureMinTime;
	}

	public void setTemperatureMinTime(DateTime temperatureMinTime) {
		this.temperatureMinTime = temperatureMinTime;
	}

	public Double getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(Double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public DateTime getTemperatureMaxTime() {
		return temperatureMaxTime;
	}

	public void setTemperatureMaxTime(DateTime temperatureMaxTime) {
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public Double getApparentTemperatureMin() {
		return apparentTemperatureMin;
	}

	public void setApparentTemperatureMin(Double apparentTemperatureMin) {
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public DateTime getApparentTemperatureMinTime() {
		return apparentTemperatureMinTime;
	}

	public void setApparentTemperatureMinTime(DateTime apparentTemperatureMinTime) {
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public Double getApparentTemperatureMax() {
		return apparentTemperatureMax;
	}

	public void setApparentTemperatureMax(Double apparentTemperatureMax) {
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public DateTime getApparentTemperatureMaxTime() {
		return apparentTemperatureMaxTime;
	}

	public void setApparentTemperatureMaxTime(DateTime apparentTemperatureMaxTime) {
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

}
