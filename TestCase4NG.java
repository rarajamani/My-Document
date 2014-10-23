package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class TestCase4NG 
{
	TestCase1NG tc1;
	TestCase3NG tc3;
	public static CommonMethods common;
	public static String execution_status=null;
	
  @Test
  public void EditCampaign(String userName,String password) throws RowsExceededException, BiffException, WriteException, IOException
  {
	  try
	  {
		  tc1 = new TestCase1NG();
		  tc1.forceLogin(userName,password);
		  common = new CommonMethods();
		  common.takeSnapShot(common.driver,"TC4_LoginPage");
		  common.implicitWait();
		  common.clickLink("Campaigns");
		  common.setValueBySelectName("fcf","Finops RTB");
		  //common.implicitWait();
		  common.takeSnapShot(common.driver,"TC4_EditPage");
		  common.clickLink("Edit");
		  common.setValueByClick("fscope0");
		  common.setValueBySelect("fcol1", "Parent Campaign ID");
		  common.setValueBySelect("fcol2", "Status");
		  common.setValueBySelect("fcol3", "Expected Revenue");
		  common.setValueBySelect("fcol4", "Type");
		  common.setValueBySelect("fcol5", "Campaign Name");
		  common.setValueBySelect("colselector_select_0","Total Leads");
		  common.setXpath("//*[@id=\"colselector_select_0_right\"]/img");
		  common.setValueBySelect("colselector_select_0","Num Total Opportunities");
		  common.setXpath("//*[@id=\"colselector_select_0_right\"]/img");
		  common.setValueByName("save");
		  execution_status="Successfully";
	} 
	  catch (Exception e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 execution_status="Failed";
	 }
  }	
	  public void logOut() throws RowsExceededException, BiffException, WriteException, IOException
	  {
	  	try 
	  	{
	  		tc1 = new TestCase1NG();
	  		common = new CommonMethods();
	  		common.takeSnapShot(common.driver,"TC4_LogOut");
	  		tc1.logOut();
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
  

