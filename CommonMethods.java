package com.script.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods
{

	public static WebDriver driver;
	
	public CommonMethods()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rarajamani\\workspace\\Selenium\\lib\\chromedriver.exe");
		 
	}
	
	
	public void launchURL(String url)
	{
		try 
		{
			driver =  new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}	
	}
	
	public void clickLink(String link)
	{
		try 
		{
			driver.findElement(By.linkText(link)).click();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}
		
	}
	
	public void setValueByID(String object,String setValue)
	{
		try
		{
			driver.findElement(By.id(object)).sendKeys(setValue);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}
	}
	
	public void setValueBySelect(String object,String setValue)
	{
		try 
		{
			new Select(driver.findElement(By.id(object))).selectByVisibleText(setValue);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Element Not Found");
			//e.printStackTrace();
		}
		
	}
	
	public void setValueBySelectName(String object,String setValue)
	{
		try 
		{
			new Select(driver.findElement(By.name(object))).selectByVisibleText(setValue);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Element Not Found");
			e.printStackTrace();
		}
		
	}
	
	public void setValueByClick(String object)
	{
		try 
		{
			driver.findElement(By.id(object)).click();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Element Not Found");
			e.printStackTrace();
		}		
	}
	
	public void setValueByName(String object)
	{
		try
		{
			driver.findElement(By.name(object)).click();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}
	}
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void setXpath(String xPath)
	{
		try 
		{
			driver.findElement(By.xpath(xPath)).click();
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}
	}
	
	public void setXpathValue(String xPath,String setValue)
	{
		driver.findElement(By.xpath(xPath)).sendKeys(setValue);
	}
	
	public String gettXpath(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).getText();
				
	}
	
	
	public String getClick(String url)
	{
		return driver.findElement(By.linkText(url)).getText();
				
	}
	
	
	public  void login(String userName, String passWord)
	{
		try 
		{
			setValueByID("username",userName);
			setValueByID("password",passWord);
			setXpath("//*[@id=\"Login\"]/span");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}
		
	}
	
	public void takeSnapShot(WebDriver driver,String snapShot)
	{
			try 
			{
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("C:\\Users\\rarajamani\\RaviBackUp\\Selenium\\"+snapShot+".jpg"));
			} 
			catch (WebDriverException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
	}
	
	public void logOut()
	{
		try 
		{
			setValueByClick("userNavLabel");
			implicitWait();
			clickLink("Logout");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element Not Found");
		}
	}
	
	public void close()
	{
		driver.close();
	}
}
