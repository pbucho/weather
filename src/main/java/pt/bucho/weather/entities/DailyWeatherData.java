package pt.bucho.weather.entities;

import javax.persistence.Entity;

@Entity
public class DailyWeatherData extends WeatherData {

	private Long sunriseTime;
	private Long sunsetTime;
	private Double moonPhase;
	private Double precipIntensityMax;
	private Double temperatureMin;
	private Long temperatureMinTime;
	private Double temperatureMax;
	private Long temperatureMaxTime;
	private Double apparentTemperatureMin;
	private Long apparentTemperatureMinTime;
	private Double apparentTemperatureMax;
	private Long apparentTemperatureMaxTime;

	public Long getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(Long sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public Long getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(Long sunsetTime) {
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

	public Long getTemperatureMinTime() {
		return temperatureMinTime;
	}

	public void setTemperatureMinTime(Long temperatureMinTime) {
		this.temperatureMinTime = temperatureMinTime;
	}

	public Double getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(Double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public Long getTemperatureMaxTime() {
		return temperatureMaxTime;
	}

	public void setTemperatureMaxTime(Long temperatureMaxTime) {
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public Double getApparentTemperatureMin() {
		return apparentTemperatureMin;
	}

	public void setApparentTemperatureMin(Double apparentTemperatureMin) {
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public Long getApparentTemperatureMinTime() {
		return apparentTemperatureMinTime;
	}

	public void setApparentTemperatureMinTime(Long apparentTemperatureMinTime) {
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public Double getApparentTemperatureMax() {
		return apparentTemperatureMax;
	}

	public void setApparentTemperatureMax(Double apparentTemperatureMax) {
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public Long getApparentTemperatureMaxTime() {
		return apparentTemperatureMaxTime;
	}

	public void setApparentTemperatureMaxTime(Long apparentTemperatureMaxTime) {
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

}
