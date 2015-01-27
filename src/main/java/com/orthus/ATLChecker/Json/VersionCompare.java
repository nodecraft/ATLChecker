package com.orthus.ATLChecker.Json;
import com.orthus.ATLChecker.ATLChecker;


public class VersionCompare {
	
	public static Boolean Test;

	public static Boolean main(String str1, String str2 )
	{
		Test = (str1.equals(str2));
		return Test;
	}
}
