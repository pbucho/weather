package pt.bucho.weather.exceptions;

public class WeatherException extends Exception {
	
	public WeatherException() {
		super();
	}
	
	public WeatherException(String reason) {
		super(reason);
	}

}
