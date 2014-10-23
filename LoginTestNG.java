package com.script.selenium;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestNG 
{
  
	
@BeforeTest
public void skipTestCase()
{
	if(!isLoogedIn())
	{
		throw new SkipException("Test Case 2 was skiiped due to login failure");
	}
	
}
	
@Test
public void testExecution()
{
   System.out.println("Login Test Case");
}

public boolean isLoogedIn()
{
	return false;
}
    
}
