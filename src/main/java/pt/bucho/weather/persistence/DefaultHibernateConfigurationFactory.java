package pt.bucho.weather.persistence;

import pt.bucho.weather.entities.DailyWeatherData;
import pt.bucho.weather.entities.HourlyWeatherData;
import pt.bucho.weather.entities.Report;
import pt.bucho.weather.entities.WeatherData;

public class DefaultHibernateConfigurationFactory extends AbstractHibernateConfigurationFactory {

	public DefaultHibernateConfigurationFactory() {
		super();
		
		super.addClass(DailyWeatherData.class);
		super.addClass(HourlyWeatherData.class);
		super.addClass(Report.class);
		super.addClass(WeatherData.class);
		
		super.addProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
		super.addProperty("connection.driver_class", "org.postgresql.Driver");
		super.addProperty("connection.url", "jdbc:psql://localhost/weather");
		super.addProperty("connection.username", "testUser");
		super.addProperty("connection.password", "testUser");
		super.addProperty("connection.autocommit", "true");
		super.addProperty("hbm2ddl.auto", "create");
		super.addProperty("show_sql", "false");
	}

}
