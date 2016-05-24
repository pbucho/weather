package pt.bucho.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

import pt.bucho.weather.entities.DailyWeatherData;
import pt.bucho.weather.entities.HourlyWeatherData;
import pt.bucho.weather.entities.Report;
import pt.bucho.weather.entities.WeatherData;

public class AbstractTest {
	
	protected static final Logger log = LogManager.getRootLogger();

	protected static Report expectedReport;
	protected static Report actualReport;
	
	@BeforeClass
	public static void setUpBeforeAll() {
		expectedReport = new Report();
		expectedReport.setTimezone("Europe/Lisbon");
		expectedReport.setTimezoneOffset(1);
		
		WeatherData currently = new WeatherData();
		currently.setTime(1463310000000L);
		currently.setSummary("Ligeiramente Nublado");
		currently.setIcon("partly-cloudy-day");
		currently.setPrecipIntensity(0d);
		currently.setPrecipProbability(0d);
		currently.setTemperature(15.51d);
		currently.setApparentTemperature(15.51d);
		currently.setDewPoint(12.35d);
		currently.setHumidity(0.81d);
		currently.setWindSpeed(7.45d);
		currently.setWindBearing(0d);
		currently.setCloudCover(0.4d);
		currently.setPressure(1023.68d);
		currently.setOzone(347.55d);
		expectedReport.setCurrently(currently);
		
		HourlyWeatherData hourly = new HourlyWeatherData();
		hourly.setSummary("Ligeiramente nublado começa esta manhã, continua até à tarde, e vento fraco começa durante a noite.");
		hourly.setIcon("wind");
		
		WeatherData hour0 = new WeatherData();
		hour0.setTime(1463266800000L);
		hour0.setSummary("Limpo");
		hour0.setIcon("clear-night");
		hour0.setPrecipIntensity(0d);
		hour0.setPrecipProbability(0d);
		hour0.setTemperature(14.93d);
		hour0.setApparentTemperature(14.93d);
		hour0.setDewPoint(11.97d);
		hour0.setHumidity(0.82d);
		hour0.setWindSpeed(7.4d);
		hour0.setWindBearing(350d);
		hour0.setCloudCover(0d);
		hour0.setPressure(1024.19d);
		hour0.setOzone(352.38d);
		hourly.setData(0, hour0);
		
		WeatherData hour1 = new WeatherData();
		hour1.setTime(1463270400000L);
		hour1.setSummary("Limpo");
		hour1.setIcon("clear-night");
		hour1.setPrecipType("rain");
		hour1.setTemperature(14.86d);
		hour1.setApparentTemperature(14.86d);
		hour1.setDewPoint(11.97d);
		hour1.setHumidity(0.83d);
		hour1.setWindSpeed(7.53d);
		hour1.setWindBearing(352d);
		hour1.setPressure(1024.32d);
		hour1.setOzone(351.52d);
		hourly.setData(1, hour1);
		
		WeatherData hour2 = new WeatherData();
		hour2.setTime(1463274000000L);
		hour2.setSummary("Limpo");
		hour2.setIcon("clear-night");
		hour2.setPrecipIntensity(0d);
		hour2.setPrecipProbability(0d);
		hour2.setTemperature(14.81d);
		hour2.setApparentTemperature(14.81d);
		hour2.setDewPoint(11.99d);
		hour2.setHumidity(0.83d);
		hour2.setWindSpeed(7.58d);
		hour2.setWindBearing(355d);
		hour2.setCloudCover(0.19d);
		hour2.setPressure(1024.11d);
		hour2.setOzone(351.51d);
		hourly.setData(2, hour2);
		
		WeatherData hour3 = new WeatherData();
		hour3.setTime(1463277600000L);
		hour3.setSummary("Limpo");
		hour3.setIcon("clear-night");
		hour3.setPrecipIntensity(0d);
		hour3.setPrecipProbability(0d);
		hour3.setTemperature(14.76d);
		hour3.setApparentTemperature(14.76d);
		hour3.setDewPoint(12.01d);
		hour3.setHumidity(0.84d);
		hour3.setWindSpeed(7.6d);
		hour3.setWindBearing(358d);
		hour3.setCloudCover(0.19d);
		hour3.setPressure(1023.78d);
		hour3.setOzone(351.86d);
		hourly.setData(3, hour3);
		
		WeatherData hour4 = new WeatherData();
		hour4.setTime(1463281200000L);
		hour4.setSummary("Limpo");
		hour4.setIcon("clear-night");
		hour4.setPrecipIntensity(0d);
		hour4.setPrecipProbability(0d);
		hour4.setTemperature(14.71d);
		hour4.setApparentTemperature(14.71d);
		hour4.setDewPoint(12.01d);
		hour4.setHumidity(0.84d);
		hour4.setWindSpeed(7.63d);
		hour4.setWindBearing(359d);
		hour4.setCloudCover(0.19d);
		hour4.setPressure(1023.51d);
		hour4.setOzone(352.24d);
		hourly.setData(4, hour4);
		
		WeatherData hour5 = new WeatherData();
		hour5.setTime(1463284800000L);
		hour5.setSummary("Ligeiramente Nublado");
		hour5.setIcon("partly-cloudy-night");
		hour5.setPrecipIntensity(0d);
		hour5.setPrecipProbability(0d);
		hour5.setTemperature(14.69d);
		hour5.setApparentTemperature(14.69d);
		hour5.setDewPoint(11.97d);
		hour5.setHumidity(0.84d);
		hour5.setWindSpeed(7.64d);
		hour5.setWindBearing(0d);
		hour5.setCloudCover(0.26d);
		hour5.setPressure(1023.43d);
		hour5.setOzone(352.41d);
		hourly.setData(5, hour5);
		
		WeatherData hour6 = new WeatherData();
		hour6.setTime(1463288400000L);
		hour6.setSummary("Ligeiramente Nublado");
		hour6.setIcon("partly-cloudy-night");
		hour6.setPrecipIntensity(0d);
		hour6.setPrecipProbability(0d);
		hour6.setTemperature(14.69d);
		hour6.setApparentTemperature(14.69d);
		hour6.setDewPoint(11.91d);
		hour6.setHumidity(0.83d);
		hour6.setWindSpeed(7.63d);
		hour6.setWindBearing(0d);
		hour6.setCloudCover(0.33d);
		hour6.setPressure(1023.43d);
		hour6.setOzone(352.6d);
		hourly.setData(6, hour6);
		
		WeatherData hour7 = new WeatherData();
		hour7.setTime(1463292000000L);
		hour7.setSummary("Ligeiramente Nublado");
		hour7.setIcon("partly-cloudy-day");
		hour7.setPrecipIntensity(0d);
		hour7.setPrecipProbability(0d);
		hour7.setTemperature(14.71d);
		hour7.setApparentTemperature(14.71d);
		hour7.setDewPoint(11.88d);
		hour7.setHumidity(0.83d);
		hour7.setWindSpeed(7.64d);
		hour7.setWindBearing(1d);
		hour7.setCloudCover(0.4d);
		hour7.setPressure(1023.44d);
		hour7.setOzone(353.09d);
		hourly.setData(7, hour7);
		
		WeatherData hour8 = new WeatherData();
		hour8.setTime(1463295600000L);
		hour8.setSummary("Ligeiramente Nublado");
		hour8.setIcon("partly-cloudy-day");
		hour8.setPrecipIntensity(0d);
		hour8.setPrecipProbability(0d);
		hour8.setTemperature(14.78d);
		hour8.setApparentTemperature(14.78d);
		hour8.setDewPoint(11.9d);
		hour8.setHumidity(0.83d);
		hour8.setWindSpeed(7.69d);
		hour8.setWindBearing(1d);
		hour8.setCloudCover(0.47d);
		hour8.setPressure(1023.42d);
		hour8.setOzone(354.71d);
		hourly.setData(8, hour8);
		
		WeatherData hour9 = new WeatherData();
		hour9.setTime(1463299200000L);
		hour9.setSummary("Ligeiramente Nublado");
		hour9.setIcon("partly-cloudy-day");
		hour9.setPrecipIntensity(0d);
		hour9.setPrecipProbability(0d);
		hour9.setTemperature(14.93d);
		hour9.setApparentTemperature(14.93d);
		hour9.setDewPoint(11.99d);
		hour9.setHumidity(0.83d);
		hour9.setWindSpeed(7.76d);
		hour9.setWindBearing(3d);
		hour9.setCloudCover(0.53d);
		hour9.setPressure(1023.41d);
		hour9.setOzone(356.64d);
		hourly.setData(9, hour9);
		
		WeatherData hour10 = new WeatherData();
		hour10.setTime(1463302800000L);
		hour10.setSummary("Ligeiramente Nublado");
		hour10.setIcon("partly-cloudy-day");
		hour10.setPrecipIntensity(0d);
		hour10.setPrecipProbability(0d);
		hour10.setTemperature(15.11d);
		hour10.setApparentTemperature(15.11d);
		hour10.setDewPoint(12.1d);
		hour10.setHumidity(0.82d);
		hour10.setWindSpeed(7.76d);
		hour10.setWindBearing(3d);
		hour10.setCloudCover(0.55d);
		hour10.setPressure(1023.43d);
		hour10.setOzone(356.71d);
		hourly.setData(10, hour10);
		
		WeatherData hour11 = new WeatherData();
		hour11.setTime(1463306400000L);
		hour11.setSummary("Ligeiramente Nublado");
		hour11.setIcon("partly-cloudy-day");
		hour11.setPrecipIntensity(0d);
		hour11.setPrecipProbability(0d);
		hour11.setTemperature(15.31d);
		hour11.setApparentTemperature(15.31d);
		hour11.setDewPoint(12.23d);
		hour11.setHumidity(0.82d);
		hour11.setWindSpeed(7.62d);
		hour11.setWindBearing(2d);
		hour11.setCloudCover(0.5d);
		hour11.setPressure(1023.55d);
		hour11.setOzone(353.06d);
		hourly.setData(11, hour11);
		
		WeatherData hour12 = new WeatherData();
		hour12.setTime(1463310000000L);
		hour12.setSummary("Ligeiramente Nublado");
		hour12.setIcon("partly-cloudy-day");
		hour12.setPrecipIntensity(0d);
		hour12.setPrecipProbability(0d);
		hour12.setTemperature(15.51d);
		hour12.setApparentTemperature(15.51d);
		hour12.setDewPoint(12.35d);
		hour12.setHumidity(0.81d);
		hour12.setWindSpeed(7.45d);
		hour12.setWindBearing(0d);
		hour12.setCloudCover(0.4d);
		hour12.setPressure(1023.68d);
		hour12.setOzone(347.55d);
		hourly.setData(12, hour12);
		
		WeatherData hour13 = new WeatherData();
		hour13.setTime(1463313600000L);
		hour13.setSummary("Ligeiramente Nublado");
		hour13.setIcon("partly-cloudy-day");
		hour13.setPrecipIntensity(0d);
		hour13.setPrecipProbability(0d);
		hour13.setTemperature(15.64d);
		hour13.setApparentTemperature(15.64d);
		hour13.setDewPoint(12.43d);
		hour13.setHumidity(0.81d);
		hour13.setWindSpeed(7.41d);
		hour13.setWindBearing(357d);
		hour13.setCloudCover(0.31d);
		hour13.setPressure(1023.69d);
		hour13.setOzone(343.58d);
		hourly.setData(13, hour13);
		
		WeatherData hour14 = new WeatherData();
		hour14.setTime(1463317200000L);
		hour14.setSummary("Limpo");
		hour14.setIcon("clear-day");
		hour14.setPrecipIntensity(0d);
		hour14.setPrecipProbability(0d);
		hour14.setTemperature(15.67d);
		hour14.setApparentTemperature(15.67d);
		hour14.setDewPoint(12.44d);
		hour14.setHumidity(0.81d);
		hour14.setWindSpeed(7.61d);
		hour14.setWindBearing(355d);
		hour14.setCloudCover(0.22d);
		hour14.setPressure(1023.57d);
		hour14.setOzone(342.77d);
		hourly.setData(14, hour14);
		
		WeatherData hour15 = new WeatherData();
		hour15.setTime(1463320800000L);
		hour15.setSummary("Limpo");
		hour15.setIcon("clear-day");
		hour15.setPrecipIntensity(0d);
		hour15.setPrecipProbability(0d);
		hour15.setTemperature(15.64d);
		hour15.setApparentTemperature(15.64d);
		hour15.setDewPoint(12.41d);
		hour15.setHumidity(0.81d);
		hour15.setWindSpeed(7.95d);
		hour15.setWindBearing(353d);
		hour15.setCloudCover(0.12d);
		hour15.setPressure(1023.3d);
		hour15.setOzone(343.5d);
		hourly.setData(15, hour15);
		
		WeatherData hour16 = new WeatherData();
		hour16.setTime(1463324400000L);
		hour16.setSummary("Limpo");
		hour16.setIcon("clear-day");
		hour16.setPrecipIntensity(0d);
		hour16.setPrecipProbability(0d);
		hour16.setTemperature(15.63d);
		hour16.setApparentTemperature(15.63d);
		hour16.setDewPoint(12.4d);
		hour16.setHumidity(0.81d);
		hour16.setWindSpeed(8.3d);
		hour16.setWindBearing(352d);
		hour16.setCloudCover(0.05d);
		hour16.setPressure(1023.02d);
		hour16.setOzone(344.31d);
		hourly.setData(16, hour16);
		
		WeatherData hour17 = new WeatherData();
		hour17.setTime(1463328000000L);
		hour17.setSummary("Limpo");
		hour17.setIcon("clear-day");
		hour17.setPrecipIntensity(0d);
		hour17.setPrecipProbability(0d);
		hour17.setTemperature(15.68d);
		hour17.setApparentTemperature(15.68d);
		hour17.setDewPoint(12.46d);
		hour17.setHumidity(0.81d);
		hour17.setWindSpeed(8.61d);
		hour17.setWindBearing(351d);
		hour17.setCloudCover(0.02d);
		hour17.setPressure(1022.77d);
		hour17.setOzone(344.72d);
		hourly.setData(17, hour17);
		
		WeatherData hour18 = new WeatherData();
		hour18.setTime(1463331600000L);
		hour18.setSummary("Vento Fraco");
		hour18.setIcon("wind");
		hour18.setPrecipIntensity(0d);
		hour18.setPrecipProbability(0d);
		hour18.setTemperature(15.77d);
		hour18.setApparentTemperature(15.77d);
		hour18.setDewPoint(12.56d);
		hour18.setHumidity(0.81d);
		hour18.setWindSpeed(8.88d);
		hour18.setWindBearing(351d);
		hour18.setCloudCover(0.02d);
		hour18.setPressure(1022.56d);
		hour18.setOzone(345.22d);
		hourly.setData(18, hour18);
		
		WeatherData hour19 = new WeatherData();
		hour19.setTime(1463335200000L);
		hour19.setSummary("Vento Fraco");
		hour19.setIcon("wind");
		hour19.setPrecipIntensity(0d);
		hour19.setPrecipProbability(0d);
		hour19.setTemperature(15.81d);
		hour19.setApparentTemperature(15.81d);
		hour19.setDewPoint(12.63d);
		hour19.setHumidity(0.81d);
		hour19.setWindSpeed(9.06d);
		hour19.setWindBearing(352d);
		hour19.setCloudCover(0.02d);
		hour19.setPressure(1022.49d);
		hour19.setOzone(345.76d);
		hourly.setData(19, hour19);
		
		WeatherData hour20 = new WeatherData();
		hour20.setTime(1463338800000L);
		hour20.setSummary("Vento Fraco");
		hour20.setIcon("wind");
		hour20.setPrecipIntensity(0d);
		hour20.setPrecipProbability(0d);
		hour20.setTemperature(15.76d);
		hour20.setApparentTemperature(15.76d);
		hour20.setDewPoint(12.7d);
		hour20.setHumidity(0.82d);
		hour20.setWindSpeed(9.11d);
		hour20.setWindBearing(353d);
		hour20.setCloudCover(0.02d);
		hour20.setPressure(1022.66d);
		hour20.setOzone(346.33d);
		hourly.setData(20, hour20);
		
		WeatherData hour21 = new WeatherData();
		hour21.setTime(1463342400000L);
		hour21.setSummary("Vento Fraco");
		hour21.setIcon("wind");
		hour21.setPrecipIntensity(0d);
		hour21.setPrecipProbability(0d);
		hour21.setTemperature(15.64d);
		hour21.setApparentTemperature(15.64d);
		hour21.setDewPoint(12.72d);
		hour21.setHumidity(0.83d);
		hour21.setWindSpeed(9.08d);
		hour21.setWindBearing(355d);
		hour21.setCloudCover(0.01d);
		hour21.setPressure(1022.99d);
		hour21.setOzone(346.94d);
		hourly.setData(21, hour21);
		
		WeatherData hour22 = new WeatherData();
		hour22.setTime(1463346000000L);
		hour22.setSummary("Vento Fraco");
		hour22.setIcon("wind");
		hour22.setPrecipIntensity(0d);
		hour22.setPrecipProbability(0d);
		hour22.setTemperature(15.58d);
		hour22.setApparentTemperature(15.58d);
		hour22.setDewPoint(12.79d);
		hour22.setHumidity(0.83d);
		hour22.setWindSpeed(8.98d);
		hour22.setWindBearing(356d);
		hour22.setCloudCover(0d);
		hour22.setPressure(1023.31d);
		hour22.setOzone(347.62d);
		hourly.setData(22, hour22);
		
		WeatherData hour23 = new WeatherData();
		hour23.setTime(1463349600000L);
		hour23.setSummary("Vento Fraco");
		hour23.setIcon("wind");
		hour23.setPrecipIntensity(0d);
		hour23.setPrecipProbability(0d);
		hour23.setTemperature(15.58d);
		hour23.setApparentTemperature(15.58d);
		hour23.setDewPoint(12.91d);
		hour23.setHumidity(0.84d);
		hour23.setWindSpeed(8.75d);
		hour23.setWindBearing(356d);
		hour23.setCloudCover(0d);
		hour23.setPressure(1023.58d);
		hour23.setOzone(348.6d);
		hourly.setData(23, hour23);
		
		expectedReport.setHourly(hourly);
		
		DailyWeatherData dailyData = new DailyWeatherData();
		dailyData.setTime(1463266800000L);
		dailyData.setSummary("Ligeiramente nublado até tarde e vento fraco começa durante a noite.");
		dailyData.setIcon("wind");
		dailyData.setSunriseTime(1463290141000L);
		dailyData.setSunsetTime(1463341502000L);
		dailyData.setMoonPhase(0.3d);
		dailyData.setPrecipIntensity(0d);
		dailyData.setPrecipIntensityMax(0d);
		dailyData.setPrecipProbability(0d);
		dailyData.setTemperatureMin(14.69d);
		dailyData.setTemperatureMinTime(1463288400000L);
		dailyData.setTemperatureMax(15.81d);
		dailyData.setTemperatureMaxTime(1463335200000L);
		dailyData.setApparentTemperatureMin(14.69d);
		dailyData.setApparentTemperatureMinTime(1463288400000L);
		dailyData.setApparentTemperatureMax(15.81d);
		dailyData.setApparentTemperatureMaxTime(1463335200000L);
		dailyData.setDewPoint(12.28d);
		dailyData.setHumidity(0.82d);
		dailyData.setWindSpeed(8.01d);
		dailyData.setWindBearing(356d);
		dailyData.setCloudCover(0.21d);
		dailyData.setPressure(1023.4d);
		dailyData.setOzone(349.4d);
		expectedReport.setDaily(dailyData);
	}
	
	protected void assertions() {
		assertEquals(expectedReport.getDistrict(), actualReport.getDistrict());
		assertEquals(expectedReport.getTimezone(), actualReport.getTimezone());
		assertEquals(expectedReport.getTimezoneOffset(), actualReport.getTimezoneOffset());
		
		assertWeatherData(expectedReport.getCurrently(), actualReport.getCurrently());
		
		HourlyWeatherData expectedHourlyData = expectedReport.getHourly();
		HourlyWeatherData actualHourlyData = actualReport.getHourly();
		
		assertEquals(expectedHourlyData.getSummary(), actualHourlyData.getSummary());
		assertEquals(expectedHourlyData.getIcon(), actualHourlyData.getIcon());
		assertHourlyWeatherData(expectedHourlyData, actualHourlyData);
		
		DailyWeatherData expectedDailyData = expectedReport.getDaily();
		DailyWeatherData actualDailyData = actualReport.getDaily();
		
		assertEquals(expectedDailyData.getTime(), actualDailyData.getTime());
		assertEquals(expectedDailyData.getSummary(), actualDailyData.getSummary());
		assertEquals(expectedDailyData.getIcon(), actualDailyData.getIcon());
		assertEquals(expectedDailyData.getSunriseTime(), actualDailyData.getSunriseTime());
		assertEquals(expectedDailyData.getSunsetTime(), actualDailyData.getSunsetTime());
		assertDouble(expectedDailyData.getMoonPhase(), actualDailyData.getMoonPhase(), 0.09d);
		assertDouble(expectedDailyData.getPrecipIntensity(), actualDailyData.getPrecipIntensity(), 0.09d);
		assertDouble(expectedDailyData.getPrecipIntensityMax(), actualDailyData.getPrecipIntensityMax(), 0.09d);
		assertDouble(expectedDailyData.getPrecipProbability(), actualDailyData.getPrecipProbability(), 0.09d);
		assertDouble(expectedDailyData.getTemperatureMin(), actualDailyData.getTemperatureMin(), 0.09d);
		assertEquals(expectedDailyData.getTemperatureMinTime(), actualDailyData.getTemperatureMinTime());
		assertDouble(expectedDailyData.getApparentTemperatureMin(), actualDailyData.getApparentTemperatureMin(), 0.09d);
		assertEquals(expectedDailyData.getApparentTemperatureMinTime(), actualDailyData.getApparentTemperatureMinTime());
		assertDouble(expectedDailyData.getApparentTemperatureMax(), actualDailyData.getApparentTemperatureMax(), 0.09d);
		assertEquals(expectedDailyData.getApparentTemperatureMaxTime(), actualDailyData.getApparentTemperatureMaxTime());
		assertDouble(expectedDailyData.getDewPoint(), actualDailyData.getDewPoint(), 0.09d);
		assertEquals(expectedDailyData.getHumidity(), actualDailyData.getHumidity());
		assertDouble(expectedDailyData.getWindSpeed(), actualDailyData.getWindSpeed(), 0.09d);
		assertDouble(expectedDailyData.getWindBearing(), actualDailyData.getWindBearing(), 0.09d);
		assertDouble(expectedDailyData.getCloudCover(), actualDailyData.getCloudCover(), 0.09d);
		assertDouble(expectedDailyData.getPressure(), actualDailyData.getPressure(), 0.09d);
		assertDouble(expectedDailyData.getOzone(), actualDailyData.getOzone(), 0.09d);
	}
	
	protected void assertWeatherData(WeatherData expected, WeatherData actual) {
		assertEquals(expected.getTime(), actual.getTime());
		assertEquals(expected.getSummary(), actual.getSummary());
		assertEquals(expected.getIcon(), actual.getIcon());
		assertEquals(expected.getPrecipIntensity(), actual.getPrecipIntensity(), 0.09d);
		assertEquals(expected.getPrecipProbability(), actual.getPrecipIntensity(), 0.09d);
		assertEquals(expected.getTemperature(), actual.getTemperature(), 0.09d);
		assertEquals(expected.getApparentTemperature(), actual.getApparentTemperature(), 0.09d);
		assertEquals(expected.getDewPoint(), actual.getDewPoint(), 0.09d);
		assertEquals(expected.getHumidity(), actual.getHumidity(), 0.09d);
		assertEquals(expected.getWindSpeed(), actual.getWindSpeed(), 0.09d);
		assertEquals(expected.getWindBearing(), actual.getWindBearing(), 0.09d);
		assertEquals(expected.getCloudCover(), actual.getCloudCover(), 0.09d);
		assertEquals(expected.getPressure(), actual.getPressure(), 0.09d);
		assertEquals(expected.getOzone(), actual.getOzone(), 0.09d);
	}
	
	protected void assertHourlyWeatherData(HourlyWeatherData expected, HourlyWeatherData actual) {
		assertEquals(expected.getHourDataSize(), actual.getHourDataSize());
		for(int i = 0; i < expected.getHourDataSize(); i++) {
			WeatherData expectThis = expected.getData(i);
			WeatherData actualThis = actual.getData(i);
			
			assertEquals(expectThis.getTime(), actualThis.getTime());
			assertEquals(expectThis.getSummary(), actualThis.getSummary());
			assertString(expectThis.getIcon(), actualThis.getIcon());
			assertString(expectThis.getPrecipType(), actualThis.getPrecipType());
			assertDouble(expectThis.getPrecipIntensity(), actualThis.getPrecipIntensity(), 0.09d);
			assertDouble(expectThis.getPrecipProbability(), actualThis.getPrecipProbability(), 0.09d);
			assertDouble(expectThis.getTemperature(), actualThis.getTemperature(), 0.09d);
			assertDouble(expectThis.getApparentTemperature(), actualThis.getApparentTemperature(), 0.09d);
			assertDouble(expectThis.getDewPoint(), actualThis.getDewPoint(), 0.09d);
			assertDouble(expectThis.getHumidity(), actualThis.getHumidity(), 0.09d);
			assertDouble(expectThis.getWindSpeed(), actualThis.getWindSpeed(), 0.09d);
			assertDouble(expectThis.getWindBearing(), actualThis.getWindBearing(), 0.09d);
			assertDouble(expectThis.getCloudCover(), actualThis.getCloudCover(), 0.09d);
			assertDouble(expectThis.getPressure(), actualThis.getPressure(), 0.09d);
			assertDouble(expectThis.getOzone(), actualThis.getOzone(), 0.09d);
		}
		
	}
	
	protected void assertString(String expected, String actual) {
		if (expected == null) {
			if (actual == null || actual.equals("null")) {
				// ok
			} else {
				fail("String was not null");
			}
		} else {
			assertEquals(expected, actual);
		}
	}
	
	protected void assertDouble(Double expected, Double actual, double delta) {
		if (expected == null) {
			if (actual != null) {
				fail("Double was not null");
			} else {
				// ok
			}
		} else {
			assertEquals(expected, actual, delta);
		}
	}
	
}
