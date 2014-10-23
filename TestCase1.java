package com.script.selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TestCase1
{
	 CommonMethods common = new CommonMethods();
	 public static ExcelMethods excel;
	 public static WebDriver driver;
	 
	 public static String execution_status=null;
	 	  
	public void registrationPage() throws RowsExceededException, WriteException, IOException, BiffException
	{

		try 
		{
			common = new CommonMethods();
			common.launchURL("http://developer.force.com/");
			common.clickLink("JOOIN NOW");	
			common.setValueByID("first_name","Ravikumar");		
			common.setValueByID("last_name","Rajamani");
			common.setValueByID("email", "ravixkumar@gmail.com");
			common.setValueBySelect("job_role","IT Manager/Executive");	
			common.setValueByID("company","Cognizant");
			common.setValueBySelect("country","India");		
			common.setValueByID("postal_code","600100");
			common.setValueByID("username","ravixkumar@gmail.com");
			common.setValueByClick("eula");
			common.setValueByClick("submit_btn");
			common.implicitWait();
			common.close(); 
			
		    System.out.println("Registration Done successfully");
			//excel.writeExcel("M 1.1","Registration Page", "Successfully");
		    execution_status="Successfully";
		    
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 System.out.println("Registration Failed");
			 execution_status="Failed";
			//excel.writeExcel("M 1.1","Registration Page", "Failed");
		}
	}	
	
	public void openingEmail() throws RowsExceededException, BiffException, WriteException, IOException
	{
		try 
		{
			common.launchURL("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2&emr=1");
			common.setValueByID("Email","ravixkumar@gmail.com");
			common.setValueByID("Passwd", "S@ranya13");
			common.setValueByClick("signIn");
			common.implicitWait();
			common.setXpath("//div [@class='y6']/span[contains(.,'Salesforce.com login confirmation')]");
			common.implicitWait();
			common.setXpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a");
			common.setValueByClick("gb_71");
			common.close();
			execution_status="Successfully";
			System.out.println("Mail open and close successfully");
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mail event Failed ");
			execution_status="Failed";
		}
	}
	
	public void forceLogin() throws BiffException, IOException, RowsExceededException, WriteException
	{

		try
		{
			common.launchURL("http://developer.force.com/");
			common.clickLink("DE LOGIN");	
			common.login("ravixkumar@gmail.com", "R@v1kumar");
			System.out.println("Login Successfully");
			execution_status="Successfully";
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Login Failed");
			execution_status="Failed";
			e.printStackTrace();
		}
		

	}
	
	public void logOut() throws RowsExceededException, BiffException, WriteException, IOException
	{
		try
		{
			common.setValueByClick("userNavLabel");
			common.implicitWait();
			common.clickLink("Logout");
			System.out.println("Log out Successfully");
			common.implicitWait();
			common.close();
			execution_status="Successfully";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			execution_status="Failed";
			System.out.println("Log out Failed");
		}
		
	}
}
