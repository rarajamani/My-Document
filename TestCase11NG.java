package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TestCase11NG
{
	TestCase1NG tc1;
	TestCase4NG tc4;
	CommonMethods common = new CommonMethods();
	public static String execution_status=null;
	
	public void forceLogin(String userName,String password) throws BiffException, IOException, RowsExceededException, WriteException
	{
		try 
		{
			tc1 = new TestCase1NG();
			common = new CommonMethods();
			tc1.forceLogin(userName,password);
			common.takeSnapShot(common.driver,"TC11_LoginPage");
			execution_status="Successfully";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			execution_status="Failed";
		}
	}

	public void cancelCampaign()
	{
		try 
		{
			common = new CommonMethods();
			common.implicitWait();
			common.clickLink("Campaigns");
			common.clickLink("Create New View");
			common.setValueByID("fname","Settlement Finsys");
			common.setValueBySelect("fcol1", "Campaign Name");
			common.setValueBySelect("fcol2", "Campaign ID");
			common.setValueBySelect("fcol3", "Start Date");
			common.setValueBySelect("fcol4", "Start Date");
			common.setValueBySelect("fcol5", "Active");
			common.setValueByName("cancel");
			common.implicitWait();
			common.takeSnapShot(common.driver,"TC11_CancelViewPage");
			System.out.println("Cancel view Successfully");
			execution_status="Successfully";
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Test Case 11 executed Failed");
			execution_status="Failed";
		}
		
	}
	
	public void logOut()
	{
		  try 
		  	{
		  		tc4 = new TestCase4NG();
		  		common = new CommonMethods();
		  		common.takeSnapShot(common.driver,"TC11_LogOut");
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
