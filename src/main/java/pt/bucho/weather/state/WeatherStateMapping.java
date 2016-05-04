package pt.bucho.weather.state;

import java.util.HashMap;
import java.util.Map;

import pt.bucho.weather.exceptions.UnknownWeatherStateException;

public class WeatherStateMapping {

	private static WeatherStateMapping instance;
	
	private Map<String, WeatherState> mapping;
	
	private WeatherStateMapping() {
		mapping = new HashMap<String, WeatherState>();
		
		mapping.put("CÉU LIMPO", WeatherState.CEU_LIMPO);
		mapping.put("CÉU POUCO NUBLADO", WeatherState.CEU_POUCO_NUBLADO);
		mapping.put("PERÍODOS DE CÉU MUITO NUBLADO", WeatherState.PERIODOS_CEU_MT_NUBLADO);
		mapping.put("AGUACEIROS FRACOS", WeatherState.AGUACEIROS_FRACOS);
		mapping.put("AGUACEIROS", WeatherState.AGUACEIROS);
		mapping.put("AGUACEIROS FORTES", WeatherState.AGUACEIROS_FORTES);
		mapping.put("MUITO NUBLADO", WeatherState.MUITO_NUBLADO);
		mapping.put("NEVOEIRO", WeatherState.NEVOEIRO);
		mapping.put("CÉU NUBLADO POR NUVENS ALTAS", WeatherState.CEU_NUBLADO_NUVENS_ALTAS);
		mapping.put("NEBLINA", WeatherState.NEBLINA);
		mapping.put("PERÍODOS DE CHUVA", WeatherState.PERIODOS_CHUVA);
		mapping.put("CHUVA", WeatherState.CHUVA);
		mapping.put("PERÍODOS DE CHUVA FRACA", WeatherState.PERIODOS_CHUVA_FRACA);
		mapping.put("CHUVA FORTE", WeatherState.CHUVA_FORTE);
		mapping.put("PERÍODOS DE CHUVA FORTE", WeatherState.PERIODOS_CHUVA_FORTE);
		mapping.put("CHUVISCO", WeatherState.CHUVISCO);
		mapping.put("CHUVA FRACA", WeatherState.CHUVA_FRACA);
		mapping.put("NEVE", WeatherState.NEVE);
		mapping.put("TROVOADA", WeatherState.TROVOADA);
		mapping.put("GRANIZO", WeatherState.GRANIZO);
		mapping.put("AGUACEIROS E TROVOADA", WeatherState.AGUACEIROS_E_TROVOADA);
		mapping.put("GEADA", WeatherState.GEADA);
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
