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
	//#	Function boolean setExcelFile(String sPath, String Sheetname)
	//#	Purpose:	set the file path and to open the Excel file. 
    //# Purpose:    working with other Excel functions to handle datadriven framework
	//# Parameters: sPath, sheetname  (pass the sPath and sheetname to this method
	//#	Return : true/false
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
    
  //##############################################################################################################################
  //#	Function String getCellData(int RowNum, int Colnum)
  //#	Purpose:	read data from specified cell of an Excel file. 
  //# Purpose:    working with other Excel functions to handle datadriven framework
  //# Parameters: RowNum, ColNum
  //#	Return : String data
  //#	Author: Frank
  //#	Created:	March 14, 2018
  //# Last modified: 
  //# How to test it
  //##############################################################################################################################
    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	String sFunction="|Class Utils.ExcelUtils | Method getCellData |";
    	boolean bRtn=false;
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			if (Constant.bDebugMode) {
				System.out.println("Cell Data is----"+CellData+"----");
				Log.info("Cell Data is----"+CellData+"----");
				System.out.println("Function---"+sFunction+"--- gets succeed");
				Log.info("Function---"+sFunction+"--- gets succeed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			
			return CellData;
        }catch (Exception e){
        	if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets Failed");
				Log.info("Function---"+sFunction+"--- gets Failed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
    	    Log.error(sFunction+"Exception desc : "+e.getMessage());
        	throw (e);
        
           
        }
    }
    //This method is to write in the Excel cell, Row num and Col num are the parameters
    
  //##############################################################################################################################
  //#	Function Boolean setCellData(int RowNum, int Colnum)
  //#	Purpose:	write data from specified cell of an Excel file. 
  //# Purpose:    working with other Excel functions to handle datadriven framework
  //# Parameters: RowNum, ColNum
  //#	Return : true/false
  //#	Author: Frank
  //#	Created:	March 14, 2018
  //# Last modified: 
  //# How to test it
  //##############################################################################################################################
  @SuppressWarnings("static-access")
  public static boolean setCellData(String sFile, String Result,  int RowNum, int ColNum) throws Exception    {
	  String sFunction="|Class Utils.ExcelUtils | Method setCellData |";
	  if (Constant.bDebugMode) {
		  System.out.println("Function---"+sFunction+"--- gets Started");
	  }
	  Log.info("Function---"+sFunction+"--- gets Started");	
	  boolean bRtn=false;
	  boolean bExiste=false;
	  try{
		  //Excel is 0 based instead of 1
		  Row  = ExcelWSheet.getRow(RowNum);
		  if (Row==null) {
			  //This statement fix create a new line
			  Row=ExcelWSheet.createRow(RowNum);
		  }
		  Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
		  if (Cell == null) {
			  Cell = Row.createCell(ColNum);
			  //Cell=ExcelWSheet.getRow(RowNum).createCell(ColNum);
			  Cell.setCellValue(Result);
          } 
		  else {
                Cell.setCellValue(Result);
          }
		  // Constant variables Test Data path and Test Data file name
          //FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
          
		  bExiste=FileSystems.isFileExists(sFile);
		  if (!bExiste) {
			  if (Constant.bDebugMode) {
					System.out.println("The file--- "+sFile+"--- NOT Existed");
					Log.info("The file--- "+sFile+"--- NOT Existed");
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
		  }
		  else {
			  FileOutputStream fileOut = new FileOutputStream(sFile);
			  ExcelWBook.write(fileOut);
			  fileOut.flush();
			  fileOut.close();
			  if (Constant.bDebugMode) {
					System.out.println("Function---"+sFunction+"--- gets succeed");
					Log.info("Function---"+sFunction+"--- gets succeed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
			  bRtn=true;
		  }
          return bRtn;
	  }catch(Exception e){
		  if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets Failed");
				Log.info("Function---"+sFunction+"--- gets Failed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			Log.error(sFunction+"Exception desc : "+e.getMessage());
			throw (e);
      }
    }
  
//##############################################################################################################################
//#	Function int getRowContains (String sTestCaseName, int Colnum)
//#	Purpose:	return the first line contains a specific String. 
//# Purpose:    working with other Excel functions to handle datadriven framework
//# Parameters: sTestCase, RowStart, ColNum
//#	Return : RowNum
//#	Author: Frank
//#	Created:	March 15, 2018
//# Last modified: 
//# How to test it
//##############################################################################################################################

public static int getRowContains(String sTestCaseName, int iRowStart, int colNum) throws Exception{
	String sFunction="|Class Utils.ExcelUtils | Method getRowContains |";
	if (Constant.bDebugMode) {
		System.out.println("Function---"+sFunction+"--- gets Started");
	}
	Log.info("Function---"+sFunction+"--- gets Started");
	int i;
	boolean bFound=false;
	try {
		int rowCount = ExcelUtils.getRowUsed();
		if (iRowStart>rowCount-1) {  //Reason is Excel is 0 based.
			 if (Constant.bDebugMode) {
					System.out.println("The specified start row --- "+String.valueOf(iRowStart+1)+"--- is greater than Used Row--"+String.valueOf(rowCount));
					Log.info("The specified start row --- "+String.valueOf(iRowStart+1)+"--- is greater than Used Row--"+String.valueOf(rowCount));
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
			i=-1;
		}
		else {
			for ( i=iRowStart ; i<rowCount; i++){
				if (Constant.bDebugMode) {
					int iTotalRow=rowCount;
					System.out.println("Total Row Count is----"+String.valueOf(iTotalRow));
					Log.info("Total Row Count is----"+String.valueOf(iTotalRow));
				}
				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
					bFound=true;
					if (Constant.bDebugMode) {
						System.out.println("Found----"+sTestCaseName+"----on row----"+i);
						Log.info("Found----"+sTestCaseName+"----on row----"+i);
						System.out.println("Function---"+sFunction+"--- gets succeed");
						Log.info("Function---"+sFunction+"--- gets succeed");
						System.out.println("Function---"+sFunction+"--- gets completed");
					}
					Log.info("Function---"+sFunction+"--- gets completed");
					break;
				}
				
					
			}
			
			if ((!bFound) && (i>rowCount)) {
				if (Constant.bDebugMode) {
					System.out.println("Failed to find----"+sTestCaseName);
					Log.info("Failed to find----"+sTestCaseName);
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
					Log.info("Function---"+sFunction+"--- gets completed");
					i=-1;
				}
				
			}
			
		}
		return i;
	}catch (Exception e){
		 if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets Failed");
				Log.info("Function---"+sFunction+"--- gets Failed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			Log.error(sFunction+"Exception desc : "+e.getMessage());
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
