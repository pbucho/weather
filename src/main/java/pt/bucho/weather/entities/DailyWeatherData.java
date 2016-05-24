package pt.bucho.weather.entities;

import javax.persistence.Entity;

import org.joda.time.DateTime;

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

	public Long getSunriseTimeLong() {
		return sunriseTime;
	}
	
	public DateTime getSunriseTime() {
		return new DateTime(sunriseTime);
	}

	public void setSunriseTime(Long sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public Long getSunsetTimeLong() {
		return sunsetTime;
	}
	
	public DateTime getSunsetTime() {
		return new DateTime(sunsetTime);
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

	public Long getTemperatureMinTimeLong() {
		return temperatureMinTime;
	}
	
	public DateTime getTemperatureMinTime() {
		return new DateTime(temperatureMinTime);
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

	public Long getTemperatureMaxTimeLong() {
		return temperatureMaxTime;
	}
	
	public DateTime getTemperatureMaxTime() {
		return new DateTime(temperatureMaxTime);
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

	public Long getApparentTemperatureMinTimeLong() {
		return apparentTemperatureMinTime;
	}
	
	public DateTime getApparentTemperatureMinTime() {
		return new DateTime(apparentTemperatureMinTime);
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

	public Long getApparentTemperatureMaxTimeLong() {
		return apparentTemperatureMaxTime;
	}
	
	public DateTime getApparentTemperatureMaxTime() {
		return new DateTime(apparentTemperatureMaxTime);
	}

	public void setApparentTemperatureMaxTime(Long apparentTemperatureMaxTime) {
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

}
