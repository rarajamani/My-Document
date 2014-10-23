package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class TestCase3NG 
{
  
TestCase1NG tc1;
CommonMethods common = new CommonMethods();
public static String execution_status=null;

@Test
public void forceLogin(String userName,String password) throws BiffException, IOException, RowsExceededException, WriteException
{

	try 
	{
		tc1 = new TestCase1NG();
		tc1.forceLogin(userName,password);
		common.takeSnapShot(common.driver,"TC3_LoginPage");
		execution_status="Successfully";
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		execution_status="Failed";
	}
}

public void createCampaigns()
{
	try 
	{
		common = new CommonMethods();
		common.implicitWait();
		common.clickLink("Campaigns");
		common.clickLink("Create New View");
		common.setValueByID("fname","Settelement");
		common.setValueBySelect("fcol1", "Campaign Name");
		common.setValueBySelect("fcol2", "Campaign ID");
		common.setValueBySelect("fcol3", "Start Date");
		common.setValueBySelect("fcol4", "Start Date");
		common.setValueBySelect("fcol5", "Active");
		common.setValueByName("save");
		common.takeSnapShot(common.driver,"TC3_CampaignPage");
		execution_status="Successfully";
	} 
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Test Case 3 executed Failed");
		execution_status="Failed";
	}
	
}

public void logOut() throws RowsExceededException, BiffException, WriteException, IOException
{
	common = new CommonMethods();
	TestCase1NG tc1 = new TestCase1NG();
	
	try 
	{
		common.implicitWait();
		common.takeSnapShot(common.driver,"TC3_Logout");
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
