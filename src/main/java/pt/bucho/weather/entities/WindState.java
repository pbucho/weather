package pt.bucho.weather.entities;

import pt.bucho.weather.state.Direction;
import pt.bucho.weather.state.WindIntensity;

public class WindState {
	
	private WindIntensity intensity;
	private Direction direction;
	
	public WindState(WindIntensity intensity, Direction direction) {
		this.intensity = intensity;
		this.direction = direction;
	}

	public WindIntensity getIntensity() {
		return intensity;
	}

	public void setIntensity(WindIntensity intensity) {
		this.intensity = intensity;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
