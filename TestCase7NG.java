package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

import com.script.selenium.CommonMethods;
import com.script.selenium.TestCase1NG;
import com.script.selenium.TestCase4NG;

public class TestCase7NG 
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
		common.takeSnapShot(common.driver,"TC7_LoginPage");
		execution_status="Successfully";
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		execution_status="Failed";
	}
}
	
public void editCampaign()
{
	try
	{
		tc6 = new TestCase6NG();
		tc6.createNewCampaign();
		common = new CommonMethods();
		common.setValueByName("edit");
		common.setValueByID("cpn2","Public realtions");
		common.setValueBySelect("cpn3","Completed");
		common.setValueByID("cpn8", "90");
		common.setValueByID("cpn9", "55");
		common.setValueByID("cpn10", "65");
		common.setValueByName("save");
		common.implicitWait();
		common.takeSnapShot(common.driver,"TC7_EditCampaign");
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
	  		common.takeSnapShot(common.driver,"TC7_LogOut");
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
