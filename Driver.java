package com.script.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Driver 
{

	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException
	{
	    ExcelMethods excel = new ExcelMethods();	   
		int row_count = excel.rsh.getRows();
		CommonMethods common = new CommonMethods();
		System.out.println("*************Developer Force***************** ");
		for(int i=1;i<excel.rsh.getRows();i++)
		{		
			if((excel.rsh.getCell(0, i).getContents().contains("M1")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				try 
				{
					TestCase1NG tc1 = new TestCase1NG();
					System.out.println("Test Case 1 Executing - DevloperForce - Registration");
					tc1.registrationPage();
					excel.writeExcel(excel.rsh.getCell(0,i).getContents(),"Developer Registration","Intailized","TC1_HomePage.jpg");
					excel.writeExcel("M 1.1","Developer Registration", tc1.execution_status,"TC1_Registration.jpg");
					tc1.openingEmail(excel.readExcel(0,2),excel.readExcel(1,2));
					excel.writeExcel("M 1.2","Opening Email", tc1.execution_status,"TC1_MailPage.jpg");
                    tc1.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
					excel.writeExcel("M 1.3","Force Login", tc1.execution_status,"");
					tc1.logOut();
					excel.writeExcel("M 1.4","Log Out", tc1.execution_status,"TC1_LogOut.jpg");
					System.out.println("Test Case 1 Executed - DevloperForce - Registration -" + tc1.execution_status);
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((excel.rsh.getCell(0, i).getContents().contains("M2")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				TestCase2NG tc2 = new TestCase2NG();
			    System.out.println("Test Case 2 - Force Login & Log Out Executing");
			    excel.writeExcel("M 2","Login into Force Developer", "Intailized","TC1_HomePage.jpg");
				tc2.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				excel.writeExcel("M 2.1","Force Login", tc2.execution_status,"TC2_LoginPage.jpg");
				tc2.logOut();  
				excel.writeExcel("M 2.2","Log Out", tc2.execution_status,"TC2_LogoutPage.jpg");
				System.out.println("Test Case 2 Executed - Force Login & Log Out - " + tc2.execution_status);
		     }
			else if((excel.rsh.getCell(0, i).getContents().contains("M3")) && (excel.rsh.getCell(2, i).getContents().equals("Yes")))
			{
				TestCase3NG tc3 = new TestCase3NG();
				System.out.println("Test Case 3 - Creating New View - Executing");
				excel.writeExcel("M 3","Create New View", "Intailized","TC1_HomePage.jpg");
				tc3.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				excel.writeExcel("M 3.1","Force Login", tc3.execution_status,"TC3_LoginPage.jpg");
				tc3.createCampaigns();
			    excel.writeExcel("M 3.2","Created View", tc3.execution_status,"TC3_CampaignPage.jpg");
				tc3.logOut();  
				excel.writeExcel("M 3.3","Log Out", tc3.execution_status,"TC3_Logout.jpg");
				System.out.println("Test Case 3 Executed - Creating New View -"  + tc3.execution_status);
		     }
			
			else if((excel.rsh.getCell(0, i).getContents().contains("M4")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 TestCase4NG tc4 = new TestCase4NG();
				 System.out.println("Test Case 4 Executing - Edit View");
				 excel.writeExcel("M 4","Edit View","Intailized","Welcome1.jpg");
				 tc4.EditCampaign(excel.readExcel(0,1),excel.readExcel(1,1));
				 excel.writeExcel("M 4.1","Force Login", tc4.execution_status,"TC4_LoginPage.jpg");
				 excel.writeExcel("M 4.2","View Edit", tc4.execution_status,"TC4_EditPage.jpg");
				 tc4.logOut();
				 excel.writeExcel("M 4.3","Log Out", tc4.execution_status,"TC4_LogOut.jpg");
				 System.out.println("Test Case 4 Executed - Edit View -" + tc4.execution_status);
			}
			else if((excel.rsh.getCell(0, i).getContents().contains("M5")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 TestCase5NG tc5 = new TestCase5NG();
				 System.out.println("Test Case 5 - Delete View Executing");
				 excel.writeExcel("M 5","Delete View","Intailized","Welcome1.jpg");
				 tc5.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				 excel.writeExcel("M 5.1","Force Login", tc5.execution_status,"TC5_LoginPage.jpg");
				 tc5.deleteCampaign();
				 excel.writeExcel("M 5.2","Delete View Edit", tc5.execution_status,"TC5_Delete.jpg");
				 tc5.logOut();
				 excel.writeExcel("M 5.3","Log Out", tc5.execution_status,"TC5_LogOut.jpg");  
				 System.out.println("Test Case 5 Executed - Delete View -" + tc5.execution_status);				 
			}
			else if((excel.rsh.getCell(0, i).getContents().contains("M6")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 System.out.println("Test Case 6 Executing - Create New Campaign");
				 TestCase6NG tc6 = new TestCase6NG();				 
			     excel.writeExcel("M 6","Create Campaign","Intailized","Welcome1.jpg");
				 tc6.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				 excel.writeExcel("M 6.1","Force Login", tc6.execution_status,"TC6_LoginPage.jpg");
				 tc6.createNewCampaign();
				 excel.writeExcel("M 6.2","New Campaign", tc6.execution_status,"TC6_CreateCampaign.jpg");	
				 tc6.logOut();
				 excel.writeExcel("M 6.3","Log Out", tc6.execution_status,"TC6_LogOut.jpg");	
				 System.out.println("Test Case 6 Executed - Create New Campaign - " + tc6.execution_status);
	        }
			else if((excel.rsh.getCell(0, i).getContents().contains("M7")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 System.out.println("Test Case 7 Executing - Edit Campaign");
				 TestCase7NG tc7 = new TestCase7NG();				 
			     excel.writeExcel("M 7","Create Campaign","Intailized","Welcome1.jpg");
				 tc7.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				 excel.writeExcel("M 7.1","Force Login", tc7.execution_status,"TC7_LoginPage.jpg");
				 tc7.editCampaign();
				 excel.writeExcel("M 7.2","New Campaign", tc7.execution_status,"TC7_CreateCampaign.jpg");
				 excel.writeExcel("M 7.3","Edit Campaign", tc7.execution_status,"TC7_EditCampaign.jpg");
				 tc7.logOut();
				 excel.writeExcel("M 7.4","Log Out", tc7.execution_status,"TC7_LogOut.jpg");	
				 System.out.println("Test Case 7 - Executed Edit Campaign -" + tc7.execution_status);
	        }
			else if((excel.rsh.getCell(0, i).getContents().contains("M8")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 System.out.println("Test Case 8 Executing - Delete Campaign");
				 TestCase8NG tc8 = new TestCase8NG();
				 TestCase6NG tc6 = new TestCase6NG();
			     excel.writeExcel("M 8","Create Campaign","Intailized","Welcome1.jpg");
				 tc8.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				 excel.writeExcel("M 8.1","Force Login", tc8.execution_status,"TC8_LoginPage.jpg");
				 tc8.deleteCampaign();
				 excel.writeExcel("M 8.2","New Campaign", tc6.execution_status,"TC8_CreateCampaign.jpg");
				 excel.writeExcel("M 8.3","Delete Campaign", tc8.execution_status,"TC8_DeleteCampaign.jpg");
				 tc8.logOut();
				 excel.writeExcel("M 8.4","Log Out", tc8.execution_status,"TC8_LogOut.jpg");
				 System.out.println("Test Case 8 Executed - Delete Campaign -" + tc8.execution_status);
	        }
			else if((excel.rsh.getCell(0, i).getContents().contains("M9")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 System.out.println("Test Case 9 - Clone Campaign Executing");
				 TestCase9NG tc9 = new TestCase9NG();
				 TestCase6NG tc6 = new TestCase6NG();
			     excel.writeExcel("M 9","Create Campaign","Intailized","Welcome1.jpg");
				 tc9.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				 excel.writeExcel("M 9.1","Force Login", tc9.execution_status,"TC9_LoginPage.jpg");
				 tc9.cloneCampaign();
				 excel.writeExcel("M 9.2","New Campaign", tc9.execution_status,"TC9_CreateCampaign.jpg");
				 excel.writeExcel("M 9.3","Clone Campaign", tc9.execution_status,"TC9_cloneCampaign.jpg");
				 tc9.logOut();
				 excel.writeExcel("M 9.4","Log Out", tc9.execution_status,"TC9_LogOut.jpg");
				 System.out.println("Test Case 9 Executed - Clone Campaign -" + tc9.execution_status);
	        }
			else if((excel.rsh.getCell(0, i).getContents().contains("M10")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 System.out.println("Test Case 10 - Forget Password- Executing");
				 TestCase10NG tc10 = new TestCase10NG();
				 tc10.openingEmail(excel.readExcel(0,2),excel.readExcel(1,2));
			     excel.writeExcel("M 10","Forget Password","Intailized","Welcome1.jpg");
				 excel.writeExcel("M 10.1","Opening Gmail", tc10.execution_status,"TC10_Gmail.jpg");
				 tc10.resetPassword();
				 excel.writeExcel("M 10.2","Opening Gmail", tc10.execution_status,"TC10_ResetPage.jpg");
				 tc10.logOut();
				 excel.writeExcel("M 10.3","Log Out", tc10.execution_status,"TC10_LogOut.jpg");
				 System.out.println("Test Case 10 Executed - Forget Password -" + tc10.execution_status);
	        }
			
			else if((excel.rsh.getCell(0, i).getContents().contains("M11")) && (excel.rsh.getCell(2, i).getContents().equals("No")))
			{
				 System.out.println("Test Case 11 - Cancel View Executing");
				 TestCase11NG tc11 = new TestCase11NG();
			     excel.writeExcel("M 11","Cancel New View","Intailized","Welcome1.jpg");
			     tc11.forceLogin(excel.readExcel(0,1),excel.readExcel(1,1));
				 tc11.cancelCampaign();
				 excel.writeExcel("M 11.1","New Cancelled", tc11.execution_status,"TC11_CancelViewPage.jpg");
				 tc11.logOut();
				 excel.writeExcel("M 11.2","Log Out", tc11.execution_status,"TC11_LogOut.jpg");
				 System.out.println("Test Case 11 Executed - Cancel New View -" + tc11.execution_status);
	        }
		}
	    excel.workbook.write();
  		excel.closeExcel();	
  		System.out.println("*************Execution End***************** ");
	}
}	
