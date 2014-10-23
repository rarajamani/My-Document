package com.script.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample 
{

	
@BeforeMethod()
public void openBrowser()
{
	System.out.println("Opening Browser - Before Method");
}
@BeforeTest
public void openConnection()
{
	System.out.println("Opening DB connection - Before Test");
}

@Test
public void testCase1() 
{
	  System.out.println("Am Test Case 1 - Test 1");
}
  
@Test void testCase2()
{	  
	 System.out.println("Am Test Case 2 - Test 1");
}

@AfterTest
public void closeConnection()
{
System.out.println("Close DB connection - After Test");	
}

@AfterMethod
public void closeBrowser()
{
	System.out.println("Close Browser - After Method");
}

}
