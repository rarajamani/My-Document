package com.script.selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TestScenario1
{
	TestCase1NG tc1;
	TestCase4NG tc4;
	CommonMethods common = new CommonMethods();
	public static String execution_status=null;
	public String large_string=null; 
	public ArrayList<String> arrayList = new ArrayList<String>();
	
	public static void main(String[] args) throws RowsExceededException, BiffException, WriteException, IOException
	{
		TestScenario1 tc_1 = new TestScenario1();
		tc_1.forceLogin("ravixkumar@gmail.com","R@v1kumar14*");
		tc_1.newOpportunities();
		//tc_1.logOut();
	}
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
	
	public void searchOpportunities()
	{
		try 
		{
			common = new CommonMethods();
			common.clickLink("Opportunities");
			common.setValueByName("go");
			common.implicitWait();
			WebElement table = common.driver.findElement(By.xpath("//*[@id='contentWrapper']/div[2]/table"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("The number of rows in the table are: "+rows.size());
			for (int i = 1 ;i<=rows.size()-1; i++)
			{
				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				arrayList.add(cells.get(3).getText());
				System.out.println("From Table 4 " + cells.get(4).getText() + "String Length is" + cells.get(4).getText().length());
			}
			large_string = Collections.max(arrayList);
			System.out.println("Highest values " + large_string);	
			common.implicitWait();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		}
	}
	
	public void newOpportunities()
	{
		common = new CommonMethods();
		common.clickLink("Opportunities");
		common.setValueByClick("createNewButton");
		common.driver.findElement(By.linkText("Opportunity")).click();
		common.implicitWait();
		common.driver.findElement(By.id("opp3")).clear();
		common.setValueByID("opp3", "Testing");
		common.setXpath("//*[@id=\"opp4_lkwgt\"]/img");
		common.implicitWait();
		common.driver.switchTo().frame(common.driver.findElement(By.id("searchFrame")));
		common.setValueByName("new");
		common.setValueByID("2","Finops QA");
		common.setValueByID("street", "Jacksonvillie");
		common.setValueByID("city","Chennai");
		common.setValueByID("state","TamilNadu");
		common.setValueByID("zip","601204");
		common.setValueByID("country","India");
		common.setValueByID("10","9600083881");
		common.setValueByID("11","9663233232");
		common.setValueByID("12","Google");
		common.setValueByName("save");
		common.driver.switchTo().defaultContent();
		common.setValueBySelectName("opp5", "New Customer");
		common.setValueBySelectName("opp6", "Other");
		common.setValueByID("00N90000008KqGl","24817668435");
		common.setValueByID("00N90000008KqGi","68435");
		common.setValueByID("00N90000008KqGm","4785142");
		common.setValueByID("opp14","Finops is reconciliation team of PayPal");
		common.setValueByID("opp7", "500");
		common.setXpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a");
		common.setValueByID("opp10","No updates");
		common.setValueBySelectName("opp11","Prospecting");
		common.setValueBySelectName("opp12","15");
		common.setXpath("//*[@id=\"opp17_lkwgt\"]/img");
		common.setValueByID("opp17","Reconciliation QA");
		common.setValueByID("00N90000008KqGk","Amazon");
		common.setValueBySelect("00N90000008KqGj","Completed");
		common.setValueByClick("Save");
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