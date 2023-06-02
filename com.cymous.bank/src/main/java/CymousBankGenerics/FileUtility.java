package CymousBankGenerics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String get_Property_Value(String Key) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(PathConstants.propertypath);
		Properties properties=new Properties();
		properties.load(fileInputStream);
		String value=properties.getProperty(Key);
		return value;
	}

}
