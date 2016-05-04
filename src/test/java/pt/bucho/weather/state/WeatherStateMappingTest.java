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
		assertEquals(WeatherState.CEU_LIMPO, mapping.getState("CÉU LIMPO"));
	}
	
	@Test
	public void ceuPoucoNublado() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CEU_POUCO_NUBLADO, mapping.getState("CÉU POUCO NUBLADO"));
	}
	
	@Test
	public void periodosCeuMtNublado() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CEU_MT_NUBLADO, mapping.getState("PERÍODOS DE CÉU MUITO NUBLADO"));
	}
	
	@Test
	public void aguaceirosFracos() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS_FRACOS, mapping.getState("AGUACEIROS FRACOS"));
	}
	
	@Test
	public void aguaceiros() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS, mapping.getState("AGUACEIROS"));
	}
	
	@Test
	public void aguaceirosFortes() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS_FORTES, mapping.getState("AGUACEIROS FORTES"));
	}
	
	@Test
	public void muitoNublado() throws UnknownWeatherStateException{
		assertEquals(WeatherState.MUITO_NUBLADO, mapping.getState("MUITO NUBLADO"));
	}
	
	@Test
	public void nevoeiro() throws UnknownWeatherStateException{
		assertEquals(WeatherState.NEVOEIRO, mapping.getState("NEVOEIRO"));
	}
	
	@Test
	public void ceuNubladoNuvensAltas() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CEU_NUBLADO_NUVENS_ALTAS, mapping.getState("CÉU NUBLADO POR NUVENS ALTAS"));
	}
	
	@Test
	public void neblina() throws UnknownWeatherStateException{
		assertEquals(WeatherState.NEBLINA, mapping.getState("NEBLINA"));
	}
	
	@Test
	public void periodosChuva() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CHUVA, mapping.getState("PERÍODOS DE CHUVA"));
	}
	
	@Test
	public void chuva() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVA, mapping.getState("CHUVA"));
	}
	
	@Test
	public void periodosChuvaFraca() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CHUVA_FRACA, mapping.getState("PERÍODOS DE CHUVA FRACA"));
	}
	
	@Test
	public void chuvaForte() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVA_FORTE, mapping.getState("CHUVA FORTE"));
	}
	
	@Test
	public void periodosChuvaForte() throws UnknownWeatherStateException{
		assertEquals(WeatherState.PERIODOS_CHUVA_FORTE, mapping.getState("PERÍODOS DE CHUVA FORTE"));
	}
	
	@Test
	public void chuvisco() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVISCO, mapping.getState("CHUVISCO"));
	}
	
	@Test
	public void chuvaFraca() throws UnknownWeatherStateException{
		assertEquals(WeatherState.CHUVA_FRACA, mapping.getState("CHUVA FRACA"));
	}
	
	@Test
	public void neve() throws UnknownWeatherStateException{
		assertEquals(WeatherState.NEVE, mapping.getState("NEVE"));
	}
	
	@Test
	public void trovoada() throws UnknownWeatherStateException{
		assertEquals(WeatherState.TROVOADA, mapping.getState("TROVOADA"));
	}
	
	@Test
	public void granizo() throws UnknownWeatherStateException{
		assertEquals(WeatherState.GRANIZO, mapping.getState("GRANIZO"));
	}
	
	@Test
	public void aguaceirosETrovoada() throws UnknownWeatherStateException{
		assertEquals(WeatherState.AGUACEIROS_E_TROVOADA, mapping.getState("AGUACEIROS E TROVOADA"));
	}
	
	@Test
	public void geada() throws UnknownWeatherStateException{
		assertEquals(WeatherState.GEADA, mapping.getState("GEADA"));
	}
	
	@Test(expected = UnknownWeatherStateException.class)
	public void noState() throws UnknownWeatherStateException{
		mapping.getState("dummy");
	}

}
