package com.script.selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadMail 
{
  
	
@Test(dataProvider="getData")
public void sendingEmail(String email,String subject,String message) 
{
	System.out.println("Mail id ---" +email+ "Subject ---" +subject+ "Message ---"+message);
}
  
  @DataProvider
  public Object[][] getData()
  {
	  Object [][] data = new Object[2][3];
	  
	  //First Row
	  data[0][0]="ravi@gmail.com";
	  data[0][1]="hello";
	  data[0][2]="How R u man";
	  
	  data[1][0]="saran@gmail.com";
	  data[1][1]="Good Day";
	  data[1][2]="How s life dr";
	  
	  return data;
  }
  
}
