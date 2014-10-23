package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

import com.script.selenium.CommonMethods;
import com.script.selenium.TestCase1;

public class TestCase2NG 
{
	
TestCase1NG tc1;
CommonMethods common = new CommonMethods();
public static String execution_status=null;
  
@Test
	public void forceLogin(String userName,String password) throws BiffException, IOException, RowsExceededException, WriteException
	{
		try 
		{
			TestCase1NG tc1 = new TestCase1NG();
			tc1.forceLogin(userName,password);
			common.takeSnapShot(common.driver,"TC2_LoginPage");
			execution_status="Successfully";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			
			System.out.println("Test Case 2 Login Failed");
			e.printStackTrace();
			execution_status="Failed";
		}
		
	}
	
	public void logOut()
	{
		try 
		{
			common.logOut();
			common.takeSnapShot(common.driver,"TC2_LogoutPage");
			System.out.println("Test Case 2 executed successfully");
			execution_status="Successfully";
			common.implicitWait();
			common.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Test Case 2 executed Failed");
			e.printStackTrace();
			execution_status="Failed";
		}
	}
}
