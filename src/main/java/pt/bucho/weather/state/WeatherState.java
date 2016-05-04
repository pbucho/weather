package pt.bucho.weather.state;

public enum WeatherState {
	
	CEU_LIMPO ("Céu limpo"),
	CEU_POUCO_NUBLADO ("CÉU POUCO NUBLADO"),
	PERIODOS_CEU_MT_NUBLADO ("Céu com períodos de muito nublado"),
	AGUACEIROS_FRACOS ("Aguaceiros Fracos"),
	AGUACEIROS ("Aguaceiros"),
	AGUACEIROS_FORTES ("Aguaceiros Fortes"),
	MUITO_NUBLADO ("Muito nublado"),
	NEVOEIRO ("Nevoeiro"),
	CEU_NUBLADO_NUVENS_ALTAS ("Céu nublado por nuvens altas"),
	NEBLINA ("Neblina"),
	PERIODOS_CHUVA ("Períodos de chuva"),
	CHUVA ("Chuva"),
	PERIODOS_CHUVA_FRACA ("Períodos de chuva fraca"),
	CHUVA_FORTE ("Chuva forte"),
	PERIODOS_CHUVA_FORTE ("Períodos de chuva forte"),
	CHUVISCO ("Chuvisco"),
	CHUVA_FRACA ("Chuva fraca"),
	NEVE ("Neve"),
	TROVOADA ("Trovoada"),
	GRANIZO ("Granizo"),
	AGUACEIROS_E_TROVOADA ("Aguaceiros e trovoada"),
	GEADA ("Geada");
	
	public final String state; 
	
	private WeatherState(String state) {
		this.state = state;
	}

	public String getValue() {
		return this.toString();
	}
	
}
