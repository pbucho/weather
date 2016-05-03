package pt.bucho.weather.state;

public enum WindIntensity {
	
	VARIABLE_WIND, WEAK, MODERATE, STRONG, VERY_STRONG;
	
	public String getValue() {
		return this.toString();
	}

}
