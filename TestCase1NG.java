package com.script.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class TestCase1NG 
{

	 CommonMethods common = new CommonMethods();
	 public static String execution_status=null;
	 //public static WebDriver driver;
	 @Test	  
	public void registrationPage() throws RowsExceededException, WriteException, IOException, BiffException
	{

		try 
		{
			common = new CommonMethods();
			common.launchURL("http://developer.force.com/");
			common.clickLink("JOIN NOW");	
			common.takeSnapShot(common.driver,"TC1_HomePage");
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
	        common.takeSnapShot(common.driver,"TC1_Registration");
		    System.out.println("Registration Done successfully");
		    //String[] confirm_text = common.gettXpath("//*[@id=\"deorg-form-errors\"]/ul/li[2]").split(":"); 
		    //System.out.println("Output Text is " + common.gettXpath("//*[@id=\"deorg-form-errors\"]/ul/li[2]"));
		    common.close(); 
		    //AssertJUnit.assertEquals(" ravixkumar@gmail.com is already taken",confirm_text[1]);
		    execution_status="Successfully";
		    
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			 //e.printStackTrace();
			 System.out.println("Registration Failed");
			 execution_status="Failed";		
		}
	}	
	 
	 @Test(dependsOnMethods ="registrationPage")
	 public void openingEmail(String userName,String password) throws RowsExceededException, BiffException, WriteException, IOException
		{
		    common = new CommonMethods();
		    
			try 
			{
				common.launchURL("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2&emr=1");
				common.setValueByID("Email",userName);
				common.setValueByID("Passwd",password);
				common.setValueByClick("signIn");
				common.implicitWait();
				common.setXpath("//div [@class='y6']/span[contains(.,'Salesforce.com login confirmation')]");
				common.implicitWait();
			    common.setXpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a");			    
				common.setValueByClick("gb_71");
				common.close();
				common.takeSnapShot(common.driver,"TC1_MailPage");
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
	
	 @Test(dependsOnMethods ="openingEmail")
	 public void forceLogin(String userName,String password) throws BiffException, IOException, RowsExceededException, WriteException
		{
			try
			{
				common = new CommonMethods();
				common.launchURL("http://developer.force.com/");
				common.clickLink("DE LOGIN");	
				common.login(userName,password);
				common.takeSnapShot(common.driver,"TC1_LoginPage");
				System.out.println("Login Successfully");
				execution_status="Successfully";
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Login Failed");
				execution_status="Failed";
				//e.printStackTrace();
			}
			

		}
		
	 @Test(dependsOnMethods ="forceLogin")
		public void logOut() throws RowsExceededException, BiffException, WriteException, IOException
		{
			try
			{
				common = new CommonMethods();
				common.setValueByClick("userNavLabel");
				common.implicitWait();
				common.clickLink("Logout");
				common.takeSnapShot(common.driver,"TC1_LogOut");
				common.close();
				System.out.println("Log out Successfully");
				execution_status="Successfully";
				//AssertJUnit.assertEquals("Ravikumar Rajamani",log_out);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				execution_status="Failed";
				System.out.println("Log out Failed");
			}	
		}
}
