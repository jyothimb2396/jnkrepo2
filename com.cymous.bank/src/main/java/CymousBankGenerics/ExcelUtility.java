package CymousBankGenerics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{

	/**
	 * This Method is used to Insert data the Excel file
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void insert_Data_Into_Excel(String SheetName,int RowNumber,int CellNumber, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.createRow(RowNumber);
		Cell cell = row.createCell(CellNumber);
		cell.setCellValue(value);
		FileOutputStream fileOutputStream = new FileOutputStream(PathConstants.excelfilepath);
		book.write(fileOutputStream);
		book.close();
	}
	
	/**
	 * This Method is used to get data from  Excel file
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String get_Data_From_Excel(String SheetName,int RowNumber,int CellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(RowNumber);
		Cell cell = row.getCell(CellNumber);
		String data =cell.toString();
		book.close();
		return data;
	}
	
	/**
	 * This Method is used to get count of Rows created in Excel file
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int get_Number_of_Rows_in_Excel_Sheet(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(SheetName);
		int row = sheet.getPhysicalNumberOfRows();
		book.close();
		return row;
	}
	
	/**
	 * This Method is used to get count of Cells created in Excel file
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int get_Number_of_Cells_in_Excel_Sheet(String SheetName,int RowNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(RowNumber);
		int cell=row.getPhysicalNumberOfCells();
		book.close();
		return cell;
	}
	
	/**
	 * Used for Fetch Data from Excel and Insert into DataProvider 
	 * @param Sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] insert_Data_Into_Dataprovider(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(Sheetname);
		int rowNumber=sheet.getPhysicalNumberOfRows();
		int cellNumber=sheet.getRow(0).getPhysicalNumberOfCells();
		Object [][] obj= new Object[rowNumber][cellNumber];
		for (int i = 0; i <rowNumber; i++) 
		{
			for (int j = 0; j <cellNumber; j++) 
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}
	
	public HashMap<String, String> insert_Data_Into_Hash_Map(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(Sheetname);
		int cellNumber=sheet.getRow(0).getPhysicalNumberOfCells();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <cellNumber; i++) 
		{
			String Key= sheet.getRow(0).getCell(i).toString();
			String Value= sheet.getRow(1).getCell(i).toString();
			map.put(Key, Value);
		}
		return map;
	}
	
	public String get_Perticular_Data_From_Excel(String SheetName,String Key) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(PathConstants.excelfilepath);
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(SheetName);
		int rowNumber = sheet.getPhysicalNumberOfRows();
		int cellNumber=sheet.getRow(0).getPhysicalNumberOfCells();
		String Data=null;
		for (int i = 0; i <rowNumber; i++) 
		{
			for (int j = 0; j < cellNumber; j++) 
			{
				String Verify=sheet.getRow(i).getCell(j).toString();
				if(Verify.contains(Key))
				{
					Data=sheet.getRow(i+1).getCell(j).toString();
				}
			}
		}
		return Data;
		
	}
	
	


}
