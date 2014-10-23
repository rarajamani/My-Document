package com.script.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingAssertion

{
  
@Test
public void usingAssertion() 
{

	String actual_title = "Google";
	String expected_tile = "Google+";
	
	System.out.println("Before Assertion");
	try
	{
	Assert.assertEquals(actual_title, expected_tile);
	}
	catch(Throwable t)
	{
	   System.out.println("Test Case Failed");
	}
}
}
