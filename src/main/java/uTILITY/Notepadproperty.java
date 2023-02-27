package uTILITY;

import java.io.FileInputStream;
import java.util.Properties;

public class Notepadproperty {
public String readDATAFROMProperty(String key) throws Throwable {
	FileInputStream fileInputStream = new FileInputStream("./DATA/Login.properties");
	Properties prop = new Properties();
	prop.load(fileInputStream);
	return prop.getProperty(key);
}
}
