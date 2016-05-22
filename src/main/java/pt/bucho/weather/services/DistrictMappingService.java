package pt.bucho.weather.services;

import java.util.HashMap;
import java.util.Map;

import pt.bucho.utilities.geopt.District;

public class DistrictMappingService {
	
	private static DistrictMappingService service;
	
	private static Map<District, Double> latitude;
	private static Map<District, Double> longitude;

	private DistrictMappingService() {
	}
	
	public static DistrictMappingService getInstance() {
		if(service == null){
			initializeService();
		}
		return service;
	}
	
	public Double getLatitude(District district) {
		return latitude.get(district);
	}

	public Double getLongitude(District district) {
		return longitude.get(district);
	}
	
	private static void initializeService() {
		service = new DistrictMappingService();
		
		latitude = new HashMap<District, Double>();
		longitude = new HashMap<District, Double>();
		
		latitude.put(District.LISBOA, 38.42d);
		longitude.put(District.LISBOA, -9.8d);
		
		latitude.put(District.AVEIRO, 40.37d);
		longitude.put(District.AVEIRO, -8.38d);
		
		latitude.put(District.BEJA, 38.01d);
		longitude.put(District.BEJA, -7.52d);

		latitude.put(District.BRAGA, 41.32d);
		longitude.put(District.BRAGA, -8.25d);
		
		latitude.put(District.BRAGANCA, 41.48d);
		longitude.put(District.BRAGANCA, -6.45d);
		
		latitude.put(District.CASTELO_BRANCO, 39.50d);
		longitude.put(District.CASTELO_BRANCO, -7.28d);

		latitude.put(District.COIMBRA, 40.15d);
		longitude.put(District.COIMBRA, -8.27d);

		latitude.put(District.EVORA, 38.34d);
		longitude.put(District.EVORA, -7.54d);

		latitude.put(District.FARO, 37.02d);
		longitude.put(District.FARO, -7.55d);
		
		latitude.put(District.GUARDA, 40.32d);
		longitude.put(District.GUARDA, -7.20d);

		latitude.put(District.LEIRIA, 39.45d);
		longitude.put(District.LEIRIA, -8.48d);
		
		latitude.put(District.PORTALEGRE, 39.19d);
		longitude.put(District.PORTALEGRE, -7.25d);

		latitude.put(District.PORTO, 41.94d);
		longitude.put(District.PORTO, -8.37d);

		latitude.put(District.SANTAREM, 39.14d);
		longitude.put(District.SANTAREM, -8.41d);

		latitude.put(District.SETUBAL, 38.31d);
		longitude.put(District.SETUBAL, -8.53d);
		
		latitude.put(District.VIANA_DO_CASTELO, 41.42d);
		longitude.put(District.VIANA_DO_CASTELO, -8.50d);
		
		latitude.put(District.VILA_REAL, 41.17d);
		longitude.put(District.VILA_REAL, -7.55d);

		latitude.put(District.VISEU, 40.40d);
		longitude.put(District.VISEU, -7.55d);
		
		latitude.put(District.MADEIRA_AR, 32.39d);
		longitude.put(District.MADEIRA_AR, -16.54d);
		
		latitude.put(District.AZORES_AR, 40.37d);
		longitude.put(District.AZORES_AR, -8.38d);
		
	}

}