package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class CommonDataFile {

	/**
	 * This method is used to read data from external resources from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertiesData(String key) throws Throwable {
		// step1:- get the file path connection
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData2pm.properties");

		// step2:- load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- read key value
		String value = pro.getProperty(key);
		return value;
	}
	

}
