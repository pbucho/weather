package pt.bucho.weather.persistence;

import org.hibernate.cfg.Configuration;

public interface HibernateConfigurationFactory {

	public Configuration getConfiguration();
	
}
