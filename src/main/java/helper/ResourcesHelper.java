package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourcesHelper {
	public static String getResourcePath(String resource)
	{
		String path= BaseResourcePath()+resource;
		//System.out.println(path);
		return path;
	}

	public static String BaseResourcePath()
	{
		String path = System.getProperty("user.dir");
		//System.out.println(path);
		return path;
	}
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException
	{
		return new FileInputStream(ResourcesHelper.getResourcePath(path));
	}
	
}
