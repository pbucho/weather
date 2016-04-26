package pt.bucho.weather.state;

public enum WeatherWarning {

	NO_INFO, GREEN, YELLOW, ORANGE, RED;
	
	public String getValue() {
		return this.toString();
	}
	
}
