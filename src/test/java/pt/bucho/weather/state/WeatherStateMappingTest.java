package pt.bucho.weather.state;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import pt.bucho.weather.exceptions.UnknownWeatherStateException;

public class WeatherStateMappingTest {
	
	private static WeatherStateMapping mapping;
	
	@BeforeClass
	public static void setUp() {
		mapping = WeatherStateMapping.getInstance();
	}

	@Test
	public void ceuLimpo() throws UnknownWeatherStateException {
		assertEquals(WeatherState.CEU_LIMPO, mapping.getState("Céu limpo"));
	}
	
	@Test
	public void ceuPoucoNublado() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CEU_POUCO_NUBLADO, mapping.getState("Céu pouco nublado"));
	}
	
	@Test
	public void periodosCeuMtNublado() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CEU_MT_NUBLADO, mapping.getState("Períodos de Céu muito nublado"));
	}
	
	@Test
	public void aguaceirosFracos() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS_FRACOS, mapping.getState("Aguaceiros Fracos"));
	}
	
	@Test
	public void aguaceiros() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS, mapping.getState("Aguaceiros"));
	}
	
	@Test
	public void aguaceirosFortes() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS_FORTES, mapping.getState("Aguaceiros Fortes"));
	}
	
	@Test
	public void muitoNublado() throws UnknownWeatherStateException{
		assertEquals(WeatherState.MUITO_NUBLADO, mapping.getState("Muito nublado"));
	}
	
	@Test
	public void nevoeiro() throws UnknownWeatherStateException{
		assertEquals(WeatherState.NEVOEIRO, mapping.getState("Nevoeiro"));
	}
	
	@Test
	public void ceuNubladoNuvensAltas() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CEU_NUBLADO_NUVENS_ALTAS, mapping.getState("Céu nublado por nuvens altas"));
	}
	
	@Test
	public void neblina() throws UnknownWeatherStateException{
		assertEquals(WeatherState.NEBLINA, mapping.getState("Neblina"));
	}
	
	@Test
	public void periodosChuva() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CHUVA, mapping.getState("Períodos de chuva"));
	}
	
	@Test
	public void chuva() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVA, mapping.getState("Chuva"));
	}
	
	@Test
	public void periodosChuvaFraca() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CHUVA_FRACA, mapping.getState("Períodos de chuva fraca"));
	}
	
	@Test
	public void chuvaForte() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVA_FORTE, mapping.getState("Chuva forte"));
	}
	
	@Test
	public void periodosChuvaForte() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CHUVA_FORTE, mapping.getState("Períodos de chuva forte"));
	}
	
	@Test
	public void chuvisco() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVISCO, mapping.getState("Chuvisco"));
	}
	
	@Test
	public void chuvaFraca() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVA_FRACA, mapping.getState("Chuva fraca"));
	}
	
	@Test
	public void neve() throws UnknownWeatherStateException{
		assertEquals(WeatherState.NEVE, mapping.getState("Neve"));
	}
	
	@Test
	public void trovoada() throws UnknownWeatherStateException{
		assertEquals(WeatherState.TROVOADA, mapping.getState("Trovoada"));
	}
	
	@Test
	public void granizo() throws UnknownWeatherStateException{
		assertEquals(WeatherState.GRANIZO, mapping.getState("Granizo"));
	}
	
	@Test
	public void aguaceirosETrovoada() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS_E_TROVOADA, mapping.getState("Aguaceiros e trovoada"));
	}
	
	@Test
	public void geada() throws UnknownWeatherStateException{
		assertEquals(WeatherState.GEADA, mapping.getState("Geada"));
	}
	
	@Test(expected = UnknownWeatherStateException.class)
	public void noState() throws UnknownWeatherStateException{
		mapping.getState("dummy");
	}

}
