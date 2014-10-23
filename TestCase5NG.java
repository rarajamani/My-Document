package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TestCase5NG 
{
	
  TestCase1NG tc1;
  TestCase4NG tc4;
  public static String execution_status=null;
  public static CommonMethods common;

  @Test
  public void forceLogin(String userName,String password) throws BiffException, IOException, RowsExceededException, WriteException
  {

  	try 
  	{
  		tc1 = new TestCase1NG();
  		common = new CommonMethods();
  		tc1.forceLogin(userName,password);
  		common.takeSnapShot(common.driver,"TC5_LoginPage");
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
		  common = new CommonMethods();
		  common.implicitWait();
		  common.clickLink("Campaigns");
		  common.setValueBySelectName("fcf","Finops RTB");
		  common.clickLink("Edit");
		  common.setValueByName("delID");
		  common.implicitWait();
		  Alert alert = common.driver.switchTo().alert();
		  alert.accept();
		  common.takeSnapShot(common.driver,"TC5_Delete");
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
	  		common.takeSnapShot(common.driver,"TC5_LogOut");
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
