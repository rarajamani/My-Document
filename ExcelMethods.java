package com.script.selenium;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelMethods 
{
 
	Workbook write;
	WritableWorkbook workbook;
	WritableSheet sh;
	WritableFont font;
	WritableCellFormat wcf;
	public int row_count;
	
	Workbook rb;
	Sheet rsh;
	Workbook pb;
	Sheet psh;
	public static ExcelMethods excel;
	
	public ExcelMethods() throws BiffException, IOException, RowsExceededException, WriteException
	{		
		//Read File
		try {
			File read_file = new File("C:\\Users\\rarajamani\\RaviBackUp\\Selenium\\FrameWorkTestCases.xls");
			rb = Workbook.getWorkbook(read_file);
			rsh = rb.getSheet(0); 
			
			File credential_file = new File("C:\\Users\\rarajamani\\RaviBackUp\\Selenium\\Credential.xls");
			pb = Workbook.getWorkbook(credential_file);
			psh = pb.getSheet(0);
			
			//Write File
			write = Workbook.getWorkbook(new File("C:\\Users\\rarajamani\\RaviBackUp\\Selenium\\TCExecutionDeatails - Copy.xls")); 
			workbook = Workbook.createWorkbook(new File("C:\\Users\\rarajamani\\RaviBackUp\\Selenium\\TCExecutionDeatails - Copy.xls"),write);
			sh = workbook.getSheet("TEST_EXECUTION");
		} 
		catch (IndexOutOfBoundsException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File was open.Please close the file");
		}
			
	}
	
	
	public void addHeader() throws RowsExceededException, WriteException, IOException, BiffException
	{
		font = new WritableFont(WritableFont.TIMES);
		wcf = new WritableCellFormat(font);
		
		Label lb1 = new Label(0,0,"TEST_CASES",wcf);
		sh.addCell(lb1);
		
		Label lb2 = new Label(1,0,"DESCRIPTION",wcf);
		sh.addCell(lb2);
		
		Label lb3 = new Label(2,0,"EXECUTION_STATUS",wcf);
		sh.addCell(lb3);
		
		Label lb4 = new Label(3,0,"SNAPSHOT",wcf);
		sh.addCell(lb4);
		workbook.write(); 
		workbook.close();
	}
	

	public  void writeExcel(String test_case_id,String description,String status,String snapShot) throws IOException, RowsExceededException, WriteException, BiffException
	{
		row_count = sh.getRows();	
		Label tc_id = new Label(0,row_count,test_case_id);		
		sh.addCell(tc_id);
		
		Label desc = new Label(1,row_count,description);	
		sh.addCell(desc);
		
		Label stat = new Label(2,row_count,status);
		sh.addCell(stat);
		
		Formula snap = (new Formula(3,row_count,"HYPERLINK(\"C:\\Users\\rarajamani\\RaviBackUp\\Selenium\\"+snapShot+"\",\"View Snap\")"));
		sh.addCell(snap);
		
	}
	
	public String readExcel(int column,int row)
	{
		return psh.getCell(column,row).getContents();
	}
	
	public void closeExcel() throws WriteException, IOException
	{
		
		workbook.close();
	}
}
