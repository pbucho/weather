package pt.bucho.weather.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pt.bucho.utilities.geopt.District;

@Entity
@Table(name = "report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private District district;
	private String timezone;
	private long timezoneOffset;
	@OneToOne(targetEntity = WeatherData.class)
	private WeatherData currently;
	@OneToOne(targetEntity = HourlyWeatherData.class)
	private HourlyWeatherData hourly;
	@OneToOne(targetEntity = DailyWeatherData.class)
	private DailyWeatherData daily;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public District getDistrict() {
		return district;
	}
	
	public void setDistrict(District district) {
		this.district = district;
	}
	
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public long getTimezoneOffset() {
		return timezoneOffset;
	}

	public void setTimezoneOffset(long offset) {
		this.timezoneOffset = offset;
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
