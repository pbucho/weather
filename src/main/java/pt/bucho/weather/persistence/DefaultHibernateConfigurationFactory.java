package pt.bucho.weather.persistence;

import org.hibernate.cfg.Configuration;

public class DefaultHibernateConfigurationFactory implements HibernateConfigurationFactory {

	public Configuration getConfiguration() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		return cfg;
	}


}
