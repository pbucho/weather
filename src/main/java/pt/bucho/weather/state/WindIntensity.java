package pt.bucho.weather.state;

public enum WindIntensity {
	
	VARIABLE_WIND, WEST, WEAK, NORTHWEST, MODERATE, NORTH, STRONG, NORTHEAST,
	VERY_STRONG, EAST, SOUTH, SOUTHEAST, SOUTHWEST, VARIABLE_DIRECTION;
	
	public String getValue() {
		return this.toString();
	}

}
