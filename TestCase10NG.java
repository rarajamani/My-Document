package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCase10NG
{
	public static CommonMethods common; 
	public static String execution_status=null;
	TestCase1NG tc1;
	TestCase4NG tc4;
	
	@Test(dependsOnMethods ="registrationPage")
	 public void openingEmail(String userName,String password) throws RowsExceededException, BiffException, WriteException, IOException
		{
		    common = new CommonMethods();	
		    TestCase10NG tc10 = new TestCase10NG();
			try 
			{
				common.launchURL("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2&emr=1");
				common.setValueByID("Email",userName);
				common.setValueByID("Passwd",password);
				common.setValueByClick("signIn");
				common.implicitWait();
				common.setXpath("//div [@class='y6']/span[contains(.,'Salesforce.com - Reset Forgotten Password')]");
				common.implicitWait();
				common.setXpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a");
				common.setValueByClick("gb_71");
				common.close(); 
				execution_status="Successfully";
				System.out.println("Mail open and close successfully");
				//AssertJUnit.assertEquals("Sign out",mail_status); 
			}  
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Mail event Failed ");
				execution_status="Failed";
			}
		}
	
	public void resetPassword()
	{
		try 
		{
			common = new CommonMethods();
			common.launchURL("https://ap1.salesforce.com/secur/forgotpassword.jsp?r=_nuwYfsMei9snez4fgdf_sUyfdrATMimaY0bemc_APQavbyFue8NE29T1eHtTyGHRMMnTZhGFt1gUmMFOYjbig%3D%3D&display=page");
			common.setValueByID("answer","ponneri");
			common.setValueByName("continue");
			common.implicitWait();
			common.setValueByID("p5","R@v1kumar14*");
			common.setValueByID("p6","R@v1kumar14*");
			common.setValueByName("save");
			common.takeSnapShot(common.driver,"TC10_ResetPage");
			execution_status="Successfully";
			System.out.println("Reset Password Event Successfully executed");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Reset Password Event Failed ");
			execution_status="Failed";
		}
	}
	
	  public void logOut()
	  {
		  try 
		  	{
		  		tc4 = new TestCase4NG();
		  		common = new CommonMethods();
		  		common.takeSnapShot(common.driver,"TC10_LogOut");
		  		tc4.logOut();
		  		System.out.println("Successfully");
		  		execution_status="Successfully";
		  		
		  	} 
		  	catch (Exception e) 
		  	{
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
		  		System.out.println("Log out Failed ");
		  		execution_status="Failed";
		  	} 	
	  }
}
