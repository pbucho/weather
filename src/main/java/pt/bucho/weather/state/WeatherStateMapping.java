package pt.bucho.weather.state;

import java.util.HashMap;
import java.util.Map;

import pt.bucho.weather.exceptions.UnknownWeatherStateException;

public class WeatherStateMapping {

	private static WeatherStateMapping instance;
	
	private Map<String, WeatherState> mapping;
	
	private WeatherStateMapping() {
		mapping = new HashMap<String, WeatherState>();
		
		mapping.put("Céu limpo", WeatherState.CEU_LIMPO);
		mapping.put("Céu pouco nublado", WeatherState.CEU_POUCO_NUBLADO);
		mapping.put("Períodos de Céu muito nublado", WeatherState.PERIODOS_CEU_MT_NUBLADO);
		mapping.put("Aguaceiros Fracos", WeatherState.AGUACEIROS_FRACOS);
		mapping.put("Aguaceiros", WeatherState.AGUACEIROS);
		mapping.put("Aguaceiros Fortes", WeatherState.AGUACEIROS_FORTES);
		mapping.put("Muito nublado", WeatherState.MUITO_NUBLADO);
		mapping.put("Nevoeiro", WeatherState.NEVOEIRO);
		mapping.put("Céu nublado por nuvens altas", WeatherState.CEU_NUBLADO_NUVENS_ALTAS);
		mapping.put("Neblina", WeatherState.NEBLINA);
		mapping.put("Períodos de chuva", WeatherState.PERIODOS_CHUVA);
		mapping.put("Chuva", WeatherState.CHUVA);
		mapping.put("Períodos de chuva fraca", WeatherState.PERIODOS_CHUVA_FRACA);
		mapping.put("Chuva forte", WeatherState.CHUVA_FORTE);
		mapping.put("Períodos de chuva forte", WeatherState.PERIODOS_CHUVA_FORTE);
		mapping.put("Chuvisco", WeatherState.CHUVISCO);
		mapping.put("Chuva fraca", WeatherState.CHUVA_FRACA);
		mapping.put("Neve", WeatherState.NEVE);
		mapping.put("Trovoada", WeatherState.TROVOADA);
		mapping.put("Granizo", WeatherState.GRANIZO);
		mapping.put("Aguaceiros e trovoada", WeatherState.AGUACEIROS_E_TROVOADA);
		mapping.put("Geada", WeatherState.GEADA);
	}
	
	public static WeatherStateMapping getInstance() {
		if(instance == null){
			instance = new WeatherStateMapping();
		}
		return instance;
	}
	
	public WeatherState getState(String state) throws UnknownWeatherStateException {
		WeatherState indendedState = mapping.get(state);
		if(indendedState == null){
			throw new UnknownWeatherStateException("Unknown weather state: " + state);
		}
		return indendedState;
	}
	
}
