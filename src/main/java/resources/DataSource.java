package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DataSource {
	public static Properties property;
	static FileInputStream fis;
	private String url;
	
	public String getUrl()
	{
		return url;
	}
	public long getImpliciwait()
	{
		return Integer.parseInt(property.getProperty("implicitwait"));
	}
	public static long getExpliciwait()
	{
		return Integer.parseInt(property.getProperty("explicitwait"));
	}
	public long getPageLoadTime()
	{
		return Integer.parseInt(property.getProperty("pageloadtime"));
	}
	
	public void setUrl(String url)
	{
		this.url=url;
	}
	static{
		property=new Properties();
		File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
		try {
			fis=new FileInputStream(f);
			property.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
