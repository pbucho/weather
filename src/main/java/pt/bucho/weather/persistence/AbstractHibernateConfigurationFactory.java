package pt.bucho.weather.persistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.cfg.Configuration;

@SuppressWarnings("rawtypes")
public abstract class AbstractHibernateConfigurationFactory implements HibernateConfigurationFactory{

	private Set<Class> classes;
	private Map<String, String> properties;

	public AbstractHibernateConfigurationFactory() {
		classes = new HashSet<Class>();
		properties = new HashMap<String, String>();
	}

	public void addClass(Class clazz) {
		classes.add(clazz);
	}

	public void addProperty(String name, String value) {
		properties.put(name, value);
	}

	public Configuration getConfiguration() {
		Configuration cfg = new Configuration();

		for (Class clazz : classes) {
			cfg.addClass(clazz);
		}

		Iterator<Entry<String, String>> i = properties.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, String> entry = i.next();
			cfg.setProperty(entry.getKey(), entry.getValue());
		}

		return cfg;
	}

}
