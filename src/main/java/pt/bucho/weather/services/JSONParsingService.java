package pt.bucho.weather.services;

import pt.bucho.weather.entities.Report;

public interface JSONParsingService {

	public void parse();
	public Report getResult();
	
}
