package employee.utlities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils
{
	public static String ename()
	{
		String genratedstring=RandomStringUtils.randomAlphabetic(1);
		return("lohi"+genratedstring);
	}
	
	public static String esal()
	{
		String genratedstring=RandomStringUtils.randomNumeric(5);
		return(genratedstring);
	}
	
	public static String eage()
	{
		String genratedstring=RandomStringUtils.randomNumeric(2);
		return(genratedstring);
	}

}
