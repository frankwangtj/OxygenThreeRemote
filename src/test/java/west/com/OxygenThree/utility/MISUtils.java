package west.com.OxygenThree.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MISUtils {
	
	//##############################################################################################################################
	//#	Function boolean createMISTestResult(String sPath, String Sheetname)
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
	  
		
	}

