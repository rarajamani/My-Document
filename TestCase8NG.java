package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TestCase8NG 
{
	TestCase1NG tc1;
	TestCase4NG tc4;
	TestCase6NG tc6;
	public static CommonMethods common; 
	public static String execution_status=null;
	
@Test
public void forceLogin(String userName,String password) throws BiffException, IOException, RowsExceededException, WriteException
{
	try 
	{
		tc1 = new TestCase1NG();
		common = new CommonMethods();
		tc1.forceLogin(userName,password);
		common.takeSnapShot(common.driver,"TC8_LoginPage");
		execution_status="Successfully";
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		execution_status="Failed";
	}
}

public void deleteCampaign()
{
	try
	{
		tc6 = new TestCase6NG();
		tc6.createNewCampaign();
		common = new CommonMethods();
		common.takeSnapShot(common.driver,"TC8_CreateCampaign");
		common.implicitWait();
		common.setValueByName("del");
		Alert alert = common.driver.switchTo().alert();
		common.takeSnapShot(common.driver,"TC8_DeleteCampaign");
		System.out.println("Alert text " + alert.getText());
		alert.accept();
		execution_status="Successfully";
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		execution_status="Failed";
		
	}
}

public void logOut()
{
	  try 
	  	{
	  		tc4 = new TestCase4NG();
	  		common = new CommonMethods();
	  		common.takeSnapShot(common.driver,"TC8_LogOut");
	  		tc4.logOut();
	  		execution_status="Successfully";
	  	} 
	  	catch (Exception e) 
	  	{
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		execution_status="Failed";
	  	} 	
}


}
