package com.crm.vtiger.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

public class ExcelUtility {
/*
 * author @ Joy
 */
/**
 * 
 * @param sheetName	
 * @param rownum
 * @param cellnum
 * @return
 * @throws IOException 
 * @throws InvalidFormatException 
 * @throws EncryptedDocumentException 
 * @throws Throwable
 */
public String getExcelData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
{ 
	FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	
	return cell.getStringCellValue();
	
}

/**
* This method return all the data in the sheet 
* @param sheetName
*@return
 * @throws IOException 
 * @throws InvalidFormatException 
 * @throws EncryptedDocumentException 
 * @throws Throwable
*/
public Object[][] getExcelData(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
{
	FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetName);
	int lastRow = sheet.getLastRowNum();
	int lastCell = sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			
			
		}
	}
	return data;
	
	
}
/**
 * This method used to write data inside the excel sheet
 * @param sheetName
 * @param rownum
 * @param colnum
 * @param value
 * @throws IOException 
 * @throws InvalidFormatException 
 * @throws EncryptedDocumentException 
 * @throws Throwable
 */ 
public  void writeExcelData(String sheetName,int rownum,int cellnum,String value) throws EncryptedDocumentException, InvalidFormatException, IOException
{
	FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
	Workbook workbook = WorkbookFactory.create(file);
	workbook.createSheet(sheetName).createRow(rownum).createCell(cellnum).setCellValue(value);
	FileOutputStream writeFile = new FileOutputStream(IPathConstant.EXCELPATH);
	workbook.write(writeFile);
}
 
}
