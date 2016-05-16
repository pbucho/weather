package pt.bucho.weather.services;

import pt.bucho.weather.entities.Request;

public interface JSONParsingService {

	public void parse();
	public Request getResult();
	
}
