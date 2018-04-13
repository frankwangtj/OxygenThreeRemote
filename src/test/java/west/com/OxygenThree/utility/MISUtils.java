package west.com.OxygenThree.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;




public class MISUtils {
	  private static XSSFSheet ExcelWSheet;
	  private static XSSFWorkbook ExcelWBook;
	  private static XSSFCell Cell;
	  private static XSSFRow Row;
	
	//##############################################################################################################################
	//#	Function boolean createMISTestResult()
	//#	Purpose:	Create an MIS test Result Excel file with specified format. 
	//# Purpose:    working with other Excel functions to handle datadriven framework
	//# Parameters: 
	//#	Return : true/false
	//#	Author: Frank
	//#	Created:	March 28, 2018
	//# Last modified: 
	//# How to test it
	//##############################################################################################################################
	public static boolean createMISTestResult() throws Exception {
		boolean bRtn=false;
		String sFunction="|Class MISUtils | Method createMISTestResult |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		 }
		 Log.info("Function---"+sFunction+"--- gets Started");
		 try{
			 //String sFolder;
			 //sFolder=Constant.Path_Config;
			 String sKey;
			 String sSection="PMIS_1_1_4_Single";
			 sKey="TestResultPath";
			 String sPath=System.getProperty("user.dir")+FileSystems.getConfigFromINI(sSection, sKey);
			 //String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\TestResult\\";
			 sKey="PrefixTestResult";
			 String sPrefix=FileSystems.getConfigFromINI(sSection, sKey); 
			 sKey="FileExtTestREsult";
			 String sExt=FileSystems.getConfigFromINI(sSection, sKey);
			 sKey="ResultTimeStampFormat";
			 String sTimeStamp=FileSystems.getConfigFromINI(sSection, sKey);
			 String sFullTimeStamp=timeUtils.getTimeString(sTimeStamp);
			 String sResultFileName=sPrefix +sFullTimeStamp+sExt;
			 String sFullPath=sPath+sResultFileName;
			 sKey="SheetNameOfTestREsult";
			 String sSheet=FileSystems.getConfigFromINI(sSection, sKey);
			 sKey="ResultFormat";
			 String sFormat=FileSystems.getConfigFromINI(sSection, sKey);
			 //String sFormat="Report Name|Test Result|Pass or Fail";
			 sKey="ResultFormatDelimiter";
			 String sDelimiter=FileSystems.getConfigFromINI(sSection, sKey);
			 //String sDelimiter="\\|";
			 bRtn=ExcelUtils.CreateAnExcel(sFullPath, sSheet, sFormat,sDelimiter);
			  
			 		  			  			  
			 if (Constant.bDebugMode) {
				 System.out.println("The return value is---- " + sResultFileName + "----");
				 Log.info("The return value is---- " + sResultFileName + "----");
				 System.out.println("Function---"+sFunction+"--- gets succeed");
				 Log.info("Function---"+sFunction+"--- gets succeed");
				 System.out.println("Function---"+sFunction+"--- gets completed");
			 }
			 Log.info("Function---"+sFunction+"--- gets completed");
			  
		  }catch (Exception e){
			  bRtn =false;
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
	
	
	//This method is to append a row in an Excel file based on given format-column headers, full file name, format, and arrayInfo are the parameters
    
	  //##############################################################################################################################
	  //#	Function Boolean appendRowData(String sFile, String sSheet, String sFormat, String arrInfo)
	  //#	Purpose:	write data from specified cell of an Excel file. 
	  //# 	Purpose:    	working with other Excel functions to write test result in framework
	  //# 	Parameters: 	sFile, sFormat, arrInfo
	  //#	Return : 	true/false
	  //#	Author: 	Frank
	  //#	Created:	April 05, 2018
	  //# Last modified: 
	  //# How to test it
	  //##############################################################################################################################
	  @SuppressWarnings("static-access")
	  public static boolean appendRowData(String sFile, String sSheet, String arrInfo) throws Exception {
		
		  

		  String sFunction="|Class Utils.ExcelUtils | Method appendRowData |";
		  if (Constant.bDebugMode) {
			  System.out.println("Function---"+sFunction+"--- gets Started");
		  }
		  Log.info("Function---"+sFunction+"--- gets Started");	
		  boolean bRtn=false;
		  boolean bExiste=false;
		  boolean bResult;
		  int iUsed;
		  
		  try {
			//Get how many rows have been used
			bResult=ExcelUtils.setExcelFile(sFile, sSheet);
			if (bResult) {
				iUsed=ExcelUtils.getRowUsed();
				System.out.println(String.valueOf(iUsed));
			   	if (Constant.bDebugMode) {
			   		System.out.println("The Excel has--- "+iUsed+"--- Rows Used");
					Log.info("The Excel has--- "+iUsed+"--- Rows Used");
				}

			   //Create a new row
			   			   	
			   //Row=ExcelWSheet.createRow(iUsed+1);
			   
			   //Split arrInfo
			   String sDelimiter="\\|";
			   String[] sResult = StringOp.getSplitStr(arrInfo, sDelimiter);
			   
			   //Add info based on given result
			   int iLength=sResult.length-1;
			  for (int i=0; i<iLength+1; i++) {
				  //Row.createCell(i).setCellValue(sResult[i]);
				  ExcelUtils.setCellData(sFile, sResult[i], iUsed, i);
			  }
			  
			  //FileOutputStream fileOut = new FileOutputStream(sFile);
			  //ExcelWBook.write(fileOut);
			  //fileOut.flush();
			  //fileOut.close();
			  
	    	  bRtn=true;
	    		
	    		
			 if (Constant.bDebugMode) {
						System.out.println("Function---"+sFunction+"--- gets succeed");
						Log.info("Function---"+sFunction+"--- gets succeed");
						System.out.println("Function---"+sFunction+"--- gets completed");
					}
		
			}
			else {
	 			if (Constant.bDebugMode) {
						System.out.println("The file--- "+sFile+"--- NOT Existed");
						Log.info("The file--- "+sFile+"--- NOT Existed");
						System.out.println("Function---"+sFunction+"--- gets Failed");
						Log.info("Function---"+sFunction+"--- gets Failed");
						System.out.println("Function---"+sFunction+"--- gets completed");
					}
					Log.info("Function---"+sFunction+"--- gets completed");
					bRtn=false;
			  }
				
			  return bRtn;
			  
		  }catch (Exception e) {
			  bRtn=false;
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
	//#	Function boolean createReportFileName(String sTestCase)
	//#	Purpose:	Create  MIS test Result name with timestamp. 
	//#     Purpose:        working with other Excel functions to handle test result in framework
	//# 	Parameters: 
	//#	Return :        file name
	//#	Author: Frank
	//#	Created:	April 10, 2018
	//#     Last modified: 
	//#     How to test it
	//##############################################################################################################################

	public static String createReportFileName(String sTestCase) throws Exception {
		String sFileName;
		String sFullPath;		
		String sFunction="|Class MISUtils | Method createFileName|";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");
		try{
			//String sFolder;
			//sFolder=Constant.Path_Config;
			String sKey;
			String sSection="PMIS_1_1_4_Single";
			//String sSection=Constant.Running_Build;
			sKey="TestResultPath";
			String sPath=System.getProperty("user.dir")+FileSystems.getConfigFromINI(sSection, sKey);
			//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\TestResult\\";
			//sKey="PrefixTestResult";
			//String sPrefix=FileSystems.getConfigFromINI(sSection, sKey);
			String sPrefix=sTestCase;
			sKey="FileExtTestREsult";
			String sExt=FileSystems.getConfigFromINI(sSection, sKey);
			sKey="ResultTimeStampFormat";
			
			String sTimeStamp=FileSystems.getConfigFromINI(sSection, sKey);
			String sFullTimeStamp=timeUtils.getTimeString(sTimeStamp);
			String sResultFileName=sPrefix +sFullTimeStamp+sExt;
			sFullPath=sPath+sResultFileName;
			
			  
			  			  			  
			if (Constant.bDebugMode) {
				System.out.println("The return value is---- " + sResultFileName + "----");
				Log.info("The return value is---- " + sResultFileName + "----");
				System.out.println("Function---"+sFunction+"--- gets succeed");
				Log.info("Function---"+sFunction+"--- gets succeed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
				  
		}catch (Exception e){
			sFullPath=null;
			if (Constant.bDebugMode) {
					
				System.out.println("Function---"+sFunction+"--- gets Failed");
				Log.info("Function---"+sFunction+"--- gets Failed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			Log.error(sFunction+"Exception desc : "+e.getMessage());
			throw (e);
		}
			  return sFullPath;

	}
	  
		
	}

