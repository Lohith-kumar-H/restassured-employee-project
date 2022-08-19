package employee.utlities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils
{
	public static String fname()
	{
		String genratedstring=RandomStringUtils.randomAlphabetic(1);
		return("lohi"+genratedstring);
	}
	
	public static String  lname()
	{
		String genratedstring=RandomStringUtils.randomAlphabetic(5);
		return(genratedstring);
	}
	
	public static String sid()
	{
		String genratedstring=RandomStringUtils.randomNumeric(2);
		return(genratedstring);
	}

}
