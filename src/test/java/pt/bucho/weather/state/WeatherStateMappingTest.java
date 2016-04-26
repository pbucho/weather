package pt.bucho.weather.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherStateMappingTest {
	
	private static WeatherStateMapping mapping;
	
	@BeforeClass
	public static void setUp() {
		mapping = WeatherStateMapping.getInstance();
	}

	@Test
	public void ceuLimpo() {
		assertEquals(WeatherState.CEU_LIMPO, mapping.getState("Céu limpo"));
	}
	
	@Test
	public void ceuPoucoNublado(){
		assertEquals(WeatherState.CEU_POUCO_NUBLADO, mapping.getState("Céu pouco nublado"));
	}
	
	@Test
	public void periodosCeuMtNublado(){
		assertEquals(WeatherState.PERIODOS_CEU_MT_NUBLADO, mapping.getState("Períodos de Céu muito nublado"));
	}
	
	@Test
	public void aguaceirosFracos(){
		assertEquals(WeatherState.AGUACEIROS_FRACOS, mapping.getState("Aguaceiros Fracos"));
	}
	
	@Test
	public void aguaceiros(){
		assertEquals(WeatherState.AGUACEIROS, mapping.getState("Aguaceiros"));
	}
	
	@Test
	public void aguaceirosFortes(){
		assertEquals(WeatherState.AGUACEIROS_FORTES, mapping.getState("Aguaceiros Fortes"));
	}
	
	@Test
	public void muitoNublado(){
		assertEquals(WeatherState.MUITO_NUBLADO, mapping.getState("Muito nublado"));
	}
	
	@Test
	public void nevoeiro(){
		assertEquals(WeatherState.NEVOEIRO, mapping.getState("Nevoeiro"));
	}
	
	@Test
	public void ceuNubladoNuvensAltas(){
		assertEquals(WeatherState.CEU_NUBLADO_NUVENS_ALTAS, mapping.getState("Céu nublado por nuvens altas"));
	}
	
	@Test
	public void neblina(){
		assertEquals(WeatherState.NEBLINA, mapping.getState("Neblina"));
	}
	
	@Test
	public void periodosChuva(){
		assertEquals(WeatherState.PERIODOS_CHUVA, mapping.getState("Períodos de chuva"));
	}
	
	@Test
	public void chuva(){
		assertEquals(WeatherState.CHUVA, mapping.getState("Chuva"));
	}
	
	@Test
	public void periodosChuvaFraca(){
		assertEquals(WeatherState.PERIODOS_CHUVA_FRACA, mapping.getState("Períodos de chuva fraca"));
	}
	
	@Test
	public void chuvaForte(){
		assertEquals(WeatherState.CHUVA_FORTE, mapping.getState("Chuva forte"));
	}
	
	@Test
	public void periodosChuvaForte(){
		assertEquals(WeatherState.PERIODOS_CHUVA_FORTE, mapping.getState("Períodos de chuva forte"));
	}
	
	@Test
	public void chuvisco(){
		assertEquals(WeatherState.CHUVISCO, mapping.getState("Chuvisco"));
	}
	
	@Test
	public void chuvaFraca(){
		assertEquals(WeatherState.CHUVA_FRACA, mapping.getState("Chuva fraca"));
	}
	
	@Test
	public void neve(){
		assertEquals(WeatherState.NEVE, mapping.getState("Neve"));
	}
	
	@Test
	public void trovoada(){
		assertEquals(WeatherState.TROVOADA, mapping.getState("Trovoada"));
	}
	
	@Test
	public void granizo(){
		assertEquals(WeatherState.GRANIZO, mapping.getState("Granizo"));
	}
	
	@Test
	public void aguaceirosETrovoada(){
		assertEquals(WeatherState.AGUACEIROS_E_TROVOADA, mapping.getState("Aguaceiros e trovoada"));
	}
	
	@Test
	public void geada(){
		assertEquals(WeatherState.GEADA, mapping.getState("Geada"));
	}
	
	@Test
	public void noState(){
		assertNull(mapping.getState("dummy"));
	}

}
