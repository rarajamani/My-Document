package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TestCase2 
{
	TestCase1 tc1;
	CommonMethods common = new CommonMethods();

	public void forceLogin() throws BiffException, IOException, RowsExceededException, WriteException
	{
		TestCase1 tc1 = new TestCase1();
		tc1.forceLogin();
		
	}
	
	public void logOut()
	{
		try 
		{
			common.logOut();
			System.out.println("Test Case 2 executed successfully");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Test Case 2 executed Failed");
			e.printStackTrace();
		}
	}
}
