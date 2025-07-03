package dataProvider;

import java.io.*;
import java.util.Properties;


public class ConfigFileReader {

	Properties prop;


	/**
	 * This method is used to load the properties from config.properties file
	 *
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/java/configs/Configuration.properties");
			prop.load(ip);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
//
//
//
//	public String getApplicationUrl() {
//		String url = properties.getProperty("DEMO_URL");
//		if (url != null) return url;
//		else throw new RuntimeException("url not specified in the Configuration.properties file.");
//	}
//
//	public String getUsername() {
//		String url = properties.getProperty("username");
//		if (url != null) return url;
//		else throw new RuntimeException("url not specified in the Configuration.properties file.");
//	}



