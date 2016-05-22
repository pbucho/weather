package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.utilities.geopt.District;

public class DistrictMappingServiceTest {

	private DistrictMappingService mappingService;

	@Before
	public void setUp() {
		mappingService = DistrictMappingService.getInstance();
	}

	@Test
	public void lisboa() {
		assertEquals(38.42d, mappingService.getLatitude(District.LISBOA), 0.001d);
		assertEquals(-9.8d, mappingService.getLongitude(District.LISBOA), 0.001d);
	}

	@Test
	public void aveiro() {
		assertEquals(40.37d, mappingService.getLatitude(District.AVEIRO), 0.001d);
		assertEquals(-8.38d, mappingService.getLongitude(District.AVEIRO), 0.001d);
	}

	@Test
	public void beja() {
		assertEquals(38.01d, mappingService.getLatitude(District.BEJA), 0.001d);
		assertEquals(-7.52d, mappingService.getLongitude(District.BEJA), 0.001d);
	}

	@Test
	public void braga() {
		assertEquals(41.32d, mappingService.getLatitude(District.BRAGA), 0.001d);
		assertEquals(-8.25d, mappingService.getLongitude(District.BRAGA), 0.001d);
	}

	@Test
	public void braganca() {
		assertEquals(41.48d, mappingService.getLatitude(District.BRAGANCA), 0.001d);
		assertEquals(-6.45d, mappingService.getLongitude(District.BRAGANCA), 0.001d);
	}

	@Test
	public void casteloBranco() {
		assertEquals(39.50d, mappingService.getLatitude(District.CASTELO_BRANCO), 0.001d);
		assertEquals(-7.28d, mappingService.getLongitude(District.CASTELO_BRANCO), 0.001d);
	}

	@Test
	public void coimbra() {
		assertEquals(40.15d, mappingService.getLatitude(District.COIMBRA), 0.001d);
		assertEquals(-8.27d, mappingService.getLongitude(District.COIMBRA), 0.001d);
	}

	@Test
	public void evora() {
		assertEquals(38.34d, mappingService.getLatitude(District.EVORA), 0.001d);
		assertEquals(-7.54d, mappingService.getLongitude(District.EVORA), 0.001d);
	}

	@Test
	public void faro() {
		assertEquals(37.02d, mappingService.getLatitude(District.FARO), 0.001d);
		assertEquals(-7.55d, mappingService.getLongitude(District.FARO), 0.001d);
	}

	@Test
	public void guarda() {
		assertEquals(40.32d, mappingService.getLatitude(District.GUARDA), 0.001d);
		assertEquals(-7.20d, mappingService.getLongitude(District.GUARDA), 0.001d);
	}

	@Test
	public void leiria() {
		assertEquals(39.45d, mappingService.getLatitude(District.LEIRIA), 0.001d);
		assertEquals(-8.48d, mappingService.getLongitude(District.LEIRIA), 0.001d);
	}

	@Test
	public void portalegre() {
		assertEquals(39.19d, mappingService.getLatitude(District.PORTALEGRE), 0.001d);
		assertEquals(-7.25d, mappingService.getLongitude(District.PORTALEGRE), 0.001d);
	}

	@Test
	public void porto() {
		assertEquals(41.94d, mappingService.getLatitude(District.PORTO), 0.001d);
		assertEquals(-8.37d, mappingService.getLongitude(District.PORTO), 0.001d);
	}

	@Test
	public void santarem() {
		assertEquals(39.14d, mappingService.getLatitude(District.SANTAREM), 0.001d);
		assertEquals(-8.41d, mappingService.getLongitude(District.SANTAREM), 0.001d);
	}

	@Test
	public void setubal() {
		assertEquals(38.31d, mappingService.getLatitude(District.SETUBAL), 0.001d);
		assertEquals(-8.53d, mappingService.getLongitude(District.SETUBAL), 0.001d);
	}

	@Test
	public void vianaDoCastelo() {
		assertEquals(41.42d, mappingService.getLatitude(District.VIANA_DO_CASTELO), 0.001d);
		assertEquals(-8.50d, mappingService.getLongitude(District.VIANA_DO_CASTELO), 0.001d);
	}

	@Test
	public void vilaReal() {
		assertEquals(41.17d, mappingService.getLatitude(District.VILA_REAL), 0.001d);
		assertEquals(-7.55d, mappingService.getLongitude(District.VILA_REAL), 0.001d);
	}

	@Test
	public void viseu() {
		assertEquals(40.40d, mappingService.getLatitude(District.VISEU), 0.001d);
		assertEquals(-7.55d, mappingService.getLongitude(District.VISEU), 0.001d);
	}

	@Test
	public void madeira() {
		assertEquals(32.39d, mappingService.getLatitude(District.MADEIRA_AR), 0.001d);
		assertEquals(-16.54d, mappingService.getLongitude(District.MADEIRA_AR), 0.001d);
	}

	@Test
	public void acores() {
		assertEquals(40.37d, mappingService.getLatitude(District.AZORES_AR), 0.001d);
		assertEquals(-8.38d, mappingService.getLongitude(District.AZORES_AR), 0.001d);
	}

}
