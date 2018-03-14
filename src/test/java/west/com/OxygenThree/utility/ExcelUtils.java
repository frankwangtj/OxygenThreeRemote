package west.com.OxygenThree.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
    
	//##############################################################################################################################
	//#	Function void setExcelFile(String sPath, String Sheetname)
	//#	Purpose:	set the file path and to open the Excel file. 
    //# Purpose:    working with other Excel functions to handle datadriven framework
	//# Parameters: sPath, sheetname  (pass the sPath and sheetname to this method
	//#	Return : void
	//#	Author: Frank
	//#	Created:	March 14, 2018
	//# Last modified: 
	//# How to test it
	//##############################################################################################################################
    public static boolean setExcelFile(String Path,String SheetName) throws Exception {
    	String sFunction="|Class Utils.ExcelUtils | Method setExcelFile |";
    	boolean bRtn=false;
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		try {
			//check if the file exists
			boolean bExiste;
			bExiste=FileSystems.isFileExists(Path);
			if (!bExiste) {
				if (Constant.bDebugMode) {
					System.out.println("The file--- "+Path+"--- NOT Existed");
					Log.info("The file--- "+Path+"--- NOT Existed");
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				
			}
			else {
				// Open the Excel file
				FileInputStream ExcelFile = new FileInputStream(Path);
				// Access the required test data sheet
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
    	    
				if (Constant.bDebugMode) {
					System.out.println("Excel sheet opened");
					Log.info("Excel sheet opened");
					System.out.println("Function---"+sFunction+"--- gets succeed");
					Log.info("Function---"+sFunction+"--- gets succeed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				bRtn=true;
			}
    	  
		} catch (Exception e){
				if (Constant.bDebugMode) {
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
        	    Log.error(sFunction+"Exception desc : "+e.getMessage());
        	    throw (e);
        }
		return bRtn;
    }
//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
public static String getCellData(int RowNum, int ColNum) throws Exception{
	String sFunction="Method getCellData";
	 Log.info(sFunction+" is started");
       try{
    	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
          String CellData = Cell.getStringCellValue();
          Log.info(sFunction+" is ended");
          return CellData;
          }catch (Exception e){
        	  Log.error("Class Utils.ExcelUtils |"+" "+sFunction+" "+"| Exception desc : "+e.getMessage());
              throw (e);
           
          }
}
//This method is to write in the Excel cell, Row num and Col num are the parameters
@SuppressWarnings("static-access")
public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception    {
       try{
          Row  = ExcelWSheet.getRow(RowNum);
        Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
        if (Cell == null) {
            Cell = Row.createCell(ColNum);
            Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
// Constant variables Test Data path and Test Data file name
              FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
              ExcelWBook.write(fileOut);
              fileOut.flush();
            fileOut.close();
            }catch(Exception e){
                throw (e);
        }
    }

public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
	int i;
	try {
		int rowCount = ExcelUtils.getRowUsed();
		for ( i=0 ; i<rowCount; i++){
			if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}
		return i;
			}catch (Exception e){
		Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
		throw(e);
		}
	}

public static int getRowUsed() throws Exception {
	try{
		int RowCount = ExcelWSheet.getLastRowNum();
		Log.info("Total number of Row used return as < " + RowCount + " >.");		
		return RowCount;
	}catch (Exception e){
		Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
		System.out.println(e.getMessage());
		throw (e);
	}

}

}
