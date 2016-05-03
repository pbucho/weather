package pt.bucho.weather.exceptions;

public class UnknownWeatherStateException extends WeatherException {
	
	public UnknownWeatherStateException() {
		super();
	}
	
	public UnknownWeatherStateException(String reason) {
		super(reason);
	}

}
