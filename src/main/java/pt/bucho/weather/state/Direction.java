package pt.bucho.weather.state;

public enum Direction {

	NORTH, SOUTH, EAST, WEST, NORTHEAST, NORTHWEST, SOUTEAST,
	SOUTHWEST, VARIABLE_DIRECTION;
	
	public String getValue() {
		return this.toString();
	}
	
}
