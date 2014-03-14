package com.ny6design.web.email;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * used to manager email configuration
 * 
 * @author kxu
 * 
 */
public class EmailPropertiesFactory {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	Properties config = null;

	public EmailPropertiesFactory(String emailProperty) {
		config = new Properties();
		try {
			config.load(this.getClass().getClassLoader()
					.getResourceAsStream(emailProperty));
		} catch (IOException e) {
			log.error("Can't load Email Notification configuration!" + e);
		}
	}

	@SuppressWarnings("rawtypes")
	public String getValue(String key) {
		for (Entry entry : config.entrySet()) {
			String _key = entry.getKey().toString();
			if (_key.equalsIgnoreCase(key)) {
				return entry.getValue().toString();
			}
		}
		log.warn("Can't get email configuration, key is " + key);
		return null;
	}

}
