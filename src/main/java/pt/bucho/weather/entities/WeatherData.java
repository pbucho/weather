package pt.bucho.weather.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "weather_data")
public class WeatherData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int id;
	protected DateTime time;
	protected String summary;
	protected String icon;
	protected String precipType;
	protected Double precipIntensity;
	protected Double precipProbability;
	protected Double temperature;
	protected Double apparentTemperature;
	protected Double dewPoint;
	protected Double humidity;
	protected Double windSpeed;
	protected Double windBearing;
	protected Double cloudCover;
	protected Double pressure;
	protected Double ozone;

	public DateTime getTime() {
		return time;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
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

	public Double getPrecipIntensity() {
		return precipIntensity;
	}

	public void setPrecipIntensity(Double precipIntensity) {
		this.precipIntensity = precipIntensity;
	}

	public Double getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(Double precipProbability) {
		this.precipProbability = precipProbability;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(Double apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}

	public Double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(Double dewPoint) {
		this.dewPoint = dewPoint;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getWindBearing() {
		return windBearing;
	}

	public void setWindBearing(Double windBearing) {
		this.windBearing = windBearing;
	}

	public Double getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(Double cloudCover) {
		this.cloudCover = cloudCover;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getOzone() {
		return ozone;
	}

	public void setOzone(Double ozone) {
		this.ozone = ozone;
	}

}
