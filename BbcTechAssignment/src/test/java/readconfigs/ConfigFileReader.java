package readconfigs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	Properties prop;
	public final String filePath = "/Users/pallavisadhu/Desktop/BbcAssignment/BbcTechAssignment/src/test/java/ConfigFiles/Config.properties";
	
	public ConfigFileReader() throws IOException {
		File f = new File(filePath);
		FileInputStream fin = new FileInputStream(f);
		prop = new Properties();
		prop.load(fin);
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}

}
