package com.script.selenium;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase6NG 
{

	TestCase1NG tc1;
	TestCase4NG tc4;
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
		common.takeSnapShot(common.driver,"TC6_LoginPage");
		execution_status="Successfully";
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		execution_status="Failed";
	}
}

public void createNewCampaign()
{
	 System.out.println("Test Case 6 Creating New Campaign");
	try 
	{
		common = new CommonMethods();
		common.clickLink("Campaigns");
		common.setValueByClick("createNewButton");
		common.driver.findElement(By.linkText("Campaign")).click();
		common.implicitWait();
		common.driver.findElement(By.id("cpn1")).clear();
		common.setValueByID("cpn1", "Reconciliation QA");
		common.setValueByClick("cpn16");
		common.setValueByID("cpn2","Webinar");
		common.setValueBySelect("cpn3","In Progress");
		common.driver.findElement(By.id("cpn5")).clear();
		common.setXpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[6]/td[2]/span/span/a");
		common.driver.findElement(By.id("cpn6")).clear();
		common.setXpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[7]/td[2]/span/span/a");
		common.setValueByID("cpn8", "100");
		common.setValueByID("cpn9", "50");
		common.setValueByID("cpn10", "70");
		common.implicitWait();
		common.driver.findElement(By.id("cpn11")).clear();
		common.setValueByID("cpn11", "1.1");
		common.setValueByID("cpn13", "500");
		//common.setXpath("//*[@id=\"Parent_lkwgt\"]/img");
		//common.driver.switchTo().frame(common.driver.findElement(By.className("searchFrame")));
		//common.clickLink("GC Product Webinar - Jan 7, 2002");	
		common.driver.findElement(By.id("Parent")).clear();
		common.setValueByID("Parent","GC Product Webinar - Jan 7, 2002");
		common.setValueByID("cpn4", "Finops is Reconciliation between paypal site transaction and vendor site transaction."); 
		common.setValueByName("save");
		common.implicitWait(); 
		common.takeSnapShot(common.driver,"TC6_CreateCampaign");
		execution_status="Successfully"; 
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		common.implicitWait();
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
	  		common.takeSnapShot(common.driver,"TC6_LogOut");
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
