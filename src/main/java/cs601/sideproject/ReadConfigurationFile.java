package cs601.sideproject;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
/**
 * 
 * @author dhartimadeka
 * ReadConfigurationFile - will read configuration.json file in 
 *
 */
public class ReadConfigurationFile 
{
	private Logger logger = LogManager.getLogger(ReadConfigurationFile.class);
	private ConfigurationBean configuration = new ConfigurationBean();
	private Gson gson = new Gson();
	/**
	 * readJsonFiles - read configuration json file and convert it into java objects.
	 * @param filename - name of file to read from
	 * @return
	 */
	public  ConfigurationBean readJsonFile(String filename)
	{
		//System.out.println(filename);
		if(filename != null)
		{
			try {
				JsonReader reader = new JsonReader(new FileReader(filename));
				configuration = gson.fromJson(reader, ConfigurationBean.class);
				logger.info("Read json files");
			} catch (FileNotFoundException e) 
			{
				logger.info("No file found");
				System.exit(0);
			}
		}
		return configuration;
	}
}
