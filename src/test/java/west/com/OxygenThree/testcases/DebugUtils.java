package west.com.OxygenThree.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.*;

import west.com.OxygenThree.utility.FileSystems;
import west.com.OxygenThree.utility.ExcelUtils;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.*;
import west.com.OxygenThree.utility.Log;
import west.com.OxygenThree.utility.MISUtils;
import west.com.OxygenThree.utility.RunningEnv;
import west.com.OxygenThree.utility.StringOp;
import west.com.OxygenThree.utility.timeUtils;
import west.com.OxygenThree.utility.timeUtils.*;

public class DebugUtils {
	//static WebDriver driver;
	
	// In order to use the PageFactory, first declare some fields on a PageObject that are WebElements
	//static WebElement log;
	//static WebElement pwd;
	//static WebElement submit;
	//static WebElement account;
	//static WebElement account_logout;
	String sFunction="|Class-testcases|Method-DebugUtils| ";


	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void ExecuteDebugUtils() {
				
		//Log.info("Launch onlinestore website");
		//driver.get("http://www.store.demoqa.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// In order for this code to work and not throw a NullPointerException because 
		// the "log", "pwd" nd "submit" fields aren't instantiated, we need to initialise the PageObject
		//PageFactory.initElements(driver, RunTestCase_POFV1.class);
		// Once Instantiated, we can now use the above created WebElements
		
		//OnlineStore_HomePage.lnk_MyAccount(driver).click();
		//account.click();
		
		//Thread.sleep(2000);
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    File System Starts                                  &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		
		//Verify Function isFolderExist
		//-------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\test";
		//Boolean bExist;
		//try {
		//	bExist=FileSystems.isFolderExists(sFolder);
			
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-------------------------------------------------------------------------
		//Verify Function getFileSize
		//-------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//String sFile="testx.txt";
		//long lSize;
		//try {
		//	 lSize=FileSystems.getFileSize(sFolder, sFile);
			
		//} catch (Exception e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//------------------------------------------------------------------------
		
		//Verify Function isFileExists
		//-------------------------------------------------------------------------
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\SipLog.txt";
		//boolean bExists;
		//try {
		//	bExists=FileSystems.isFileExists(sActFile);
		//} catch (Exception e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-------------------------------------------------------------------------------
		
		//Verify Function copyAFile
		//------------------------------------------------------------------------------
		//String sSrcFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//Verify Src File is non Exist
		//String sSrcF="Text.txt";
		//String sDestFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//String sDestF="Test.txt";
		//boolean bPrefix=false;
		//boolean bExists;
		//Verify Copy to a new name without prefix --RunTwo times to check dest exist
		//String sSrcF="Test123.txt";
		//String sDestFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//String sDestF="FunTest123.txt";
		//boolean bPrefix=false;
		//boolean bExists;
		
		//boolean bExists;
		//Verify Copy to a new name without prefix --RunTwo times to check dest exist
		//String sSrcF="Test123.txt";
		//String sDestFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//String sDestF="QTP";
		//boolean bPrefix=true;
		//boolean bExists;
		//try {
		//	bExists=FileSystems.copyAFile(sSrcFolder, sSrcF, sDestFolder, sDestF, bPrefix);
			
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		//Verify Function readAFile
		//-------------------------------------------------------------------------
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\Test123.txt";
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\empty.txt";
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\empty1000.txt";
		//boolean bExists;
		//try {
		//	String[] sRead=FileSystems.readAFile(sActFile);
		//	if ((sRead !=null) &&  (sRead.length>0)) {
		//		System.out.println("The array is started");
		//		for (int i=0; i<sRead.length; i++) {
		//			System.out.println(sRead[i]);
		//		}
		//		System.out.println("The array is completed");
		//	}
			
		//} catch (Exception e) {
			//	// TODO Auto-generated catch block
		//		e.printStackTrace();
		//}
		//-------------------------------------------------------------------------------
		//Verify Function deleteAFile
		//------------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//String sSrcF="Empty256.txt";
		//String sSrcF="Empty.txt";
		//String sActualF=sFolder+"\\"+sSrcF;
		//boolean bExists;
		//try {
		//	bExists=FileSystems.deleteAFile(sActualF);					
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		//Verify Function getLastModifedFile
		//------------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//boolean bExists;
		//String sLastFile;
		//Verify sExt=exe
		//String sExt="exe";
		//Verify sExt=txt
		//String sExt="txt";
		//Verify sExt=*
		//String sExt="*";
		//Verify combination in a folder
		//String sExt="*";
		//sFolder="D:\\FRWeb\\003_RunningEnvironment\\03_EclipseMars";
		//try {
		//	sLastFile=FileSystems.getLastModifiedFile(sFolder, sExt);
		//	System.out.println(sLastFile);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		//Verify Function getFileNamesInAFolder
		//-------------------------------------------------------------------------
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\Test123.txt";
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\empty.txt";
		//String sActFile="C:\\007_Temp";
		//String sExt="txt";
		//boolean bExists;
		//try {
		//	String[] sFileList=FileSystems.getFileNamesInAFolder(sActFile, sExt);
		//	if ((sFileList !=null) &&  (sFileList.length>0)) {
		//		System.out.println("The array is started");
		//		for (int i=0; i<sFileList.length; i++) {
		//			System.out.println(sFileList[i]);
		//		}
		//		System.out.println("The array is completed");
		//	}
				
		//} catch (Exception e) {
			//	// TODO Auto-generated catch block
		//		e.printStackTrace();
		//}
		//--------------------------------------------------------------------------------------
		//Verify Function getKeyValueFromINI
		//------------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//boolean bExists;
		//String sSection="PMIS_1_1_4_Single";
		//String sKey="PMIS_URL";
		//String sRtn;
		//try {
		//	//sRtn=FileSystems.getKeyValueFromINI(sSection, sKey);
		//	sRtn=FileSystems.getConfigFromINI(sSection, sKey);
		//	System.out.println(sRtn);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		
		//Verify Function getFileCount
		//-------------------------------------------------------------------------
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\Test123.txt";
		//String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\empty.txt";
		//String sActFile="C:\\007_Temp";
		//String sExt="*";
		//boolean bExists;
		//int iCount;
		//try {
		//	iCount=FileSystems.getFileCount(sActFile, sExt);
				
						
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//--------------------------------------------------------------------------------------
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    File System Ends !!!!!                              &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    RunningEnv Starts                                  &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		
		//Verify Function getRunningMachineName
		//------------------------------------------------------------------------------
		//String sPC;
		//try {
		//	sPC=RunningEnv.getRunningMachineName();
		//	System.out.println(sPC);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
				
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    RunningEnv Ends !!!!!                              &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
				
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    ExcelUtils Starts                                  &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
				
				
		//Verify Function setExcelFile
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\NOExiste.xlsx";
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_DataDriven_Login.xlsx";
		//String sSheet="sheet1";
		//boolean bRtn;
		//try {
		//	bRtn=ExcelUtils.setExcelFile(sPath, sSheet);
		//	System.out.println(String.valueOf(bRtn));
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
						
		//Verify Function getCellData
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_DataDriven_Login.xlsx";
		//String sSheet="sheet1";
		//boolean bRtn;
		//String sValue;
		//	try {
		//		bRtn=ExcelUtils.setExcelFile(sPath, sSheet);
		//		System.out.println(String.valueOf(bRtn));
		//		if (bRtn) {
		//			sValue=ExcelUtils.getCellData(0, 2);
		//			System.out.println(sValue);
		//		}
		//	} catch (Exception e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		//-----------------------------------------------------------------------------------------
			
		//Verify Function setCellData
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_DataDriven_Login.xlsx";
		//String sSheet="sheet1";
		//boolean bRtn;
		//String sValue;
		//try {
		//	bRtn=ExcelUtils.setExcelFile(sPath, sSheet);
		//	System.out.println(String.valueOf(bRtn));
		//	if (bRtn) {
		//		bRtn=ExcelUtils.setCellData(sPath, "test2", 7,5);
		//		System.out.println(String.valueOf(bRtn));
		//	}
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		//Verify Function getRowContains
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_DataDriven_Login.xlsx";
		//String sSheet="sheet1";
		//boolean bRtn;
		//String sValue;
		//int iFound;
		//try {
		//	bRtn=ExcelUtils.setExcelFile(sPath, sSheet);
		//	System.out.println(String.valueOf(bRtn));
		//	if (bRtn) {
		//		iFound=ExcelUtils.getRowContains("RunTestCase_OnlineStoreLogin", 2, 1);
		//		System.out.println(String.valueOf(iFound));
		//	}
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		//Verify Function getRowUsed
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_DataDriven_Login.xlsx";
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\TestResult\\MISTestResult_2018_04_04_13_28_02.xlsx"; 
		//String sSheet="sheet1";
		//String sSheet="MISTestResult";
		//boolean bRtn;
		//String sValue;
		//int iUsed;
		//try {
		//	bRtn=ExcelUtils.setExcelFile(sPath, sSheet);
		//	System.out.println(String.valueOf(bRtn));
		//	if (bRtn) {
		//		iUsed=ExcelUtils.getRowUsed();
		//		System.out.println(String.valueOf(iUsed));
		//	}
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		//Verify Function createAnExcel
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_TestResult.xlsx";
		//String sSheet="Result";
		//boolean bRtn;
		//String sValue;
		//String sFormat="";
		//String sFormat="Report Names|Test Result";
		//String sDelimiter="\\|";  //Split by ,
		
		//int iUsed;
		//try {
		//	bRtn=ExcelUtils.CreateAnExcel(sPath, sSheet, sFormat,sDelimiter);
		//	System.out.println(String.valueOf(bRtn));
			
		
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------

				
		
		
				
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    ExcelUtils Ends !!!!!                              &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    StringOp Starts                                  &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================

		
		//Verify Function createAnExcel
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_TestResult.xlsx";
		//String sTest="hi,I,m,paul,Second";
		//String sDelimiter="\\,";  //Split by ,
		
				
		
		//try {
		//	String[] sResult = StringOp.getSplitStr(sTest, sDelimiter);
		//	for (int i=0; i<sResult.length; i++) {
		//		System.out.println(sResult[i]);
		//	}
			
					
				
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------

		
		
		
		
		
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    StringOp Ends !!!!!                              &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    TimeUtils Starts                                  &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================

				
		//Verify Function getTimeString
		//------------------------------------------------------------------------------
		//String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\DataDrivenDataSet\\OnlineStore_TestResult.xlsx";
		//String sTest="hi,I,m,paul,Second";
		//String sDelimiter="\\,";  //Split by ,
			
						
				
		//try {
		//	String sFormat="yyyy_MM_dd_HH_mm_ss";
		//  System.out.println("date:"+ timeUtils.getTimeString(sFormat));
							
						
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------

				
				
				
				
				
				
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    TimeUtils Ends !!!!!                              &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    MISUtils Starts                                  &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
		
		
		//Verify Function createReportFileName
		//------------------------------------------------------------------------------
				
							
										
								
		try {
		String sName;
		String sTest="ListAllReports";
		sName= MISUtils.createReportFileName(sTest);
		System.out.println(sName);
						
										
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-----------------------------------------------------------------------------------------
				
				//Verify Function appendRowData
				//------------------------------------------------------------------------------
						
						
		//Verify Function createMISTestResult
		//------------------------------------------------------------------------------
		
					
								
						
		//try {
		//	boolean bRtn1;
		//	bRtn1= MISUtils.createMISTestResult();
			
									
								
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-----------------------------------------------------------------------------------------
		
		//Verify Function appendRowData
		//------------------------------------------------------------------------------
				
						
										
								
		//try {
		//	boolean bRtn1;
		//	 String sKey;
		//	 String sSection="PMIS_1_1_4_Single";
		//	sKey="TestResultPath";
		//	String sPath=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\TestResult\\MISTestResult_2018_04_04_13_28_02.xlsx"; 
			//String sFile=System.getProperty("user.dir")+FileSystems.getConfigFromINI(sSection, sKey);
			//String sFile1="MISTestResult_2018_04_04_13_28_02.xlsx";
		//	String sSheet="MISTestResult";
		//	String arrInfo="Call Summary|test Result|Test Result|";
		//	bRtn1= MISUtils.appendRowData(sPath, sSheet, arrInfo);
					
											
										
		//	} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		//-----------------------------------------------------------------------------------------


						
						
						
						
						
						
		//==============================================================================================
		//&&&&&&&&&&&&&&&&&&    MISUtils Ends !!!!!                              &&&&&&&&&&&&&&&&&&&&
		//==============================================================================================
								
						
				

		
	}
	@BeforeMethod
	public void beforeMethod() {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
    	// http://www.toolsqa.com/log4j-logging/
		//Log4j should be initialize at least once!!!
		DOMConfigurator.configure("log4j.xml");
		//System.setProperty("webdriver.gecko.driver","D:\\FRWeb\\003_RunningEnvironment\\02_GeckoDriver16\\geckodriver.exe");
		//driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Start to test--" +sFunction);
		Log.info("Start to test--" +sFunction);
		
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Complete the test--"+sFunction);
		Log.info("Complete the test--"+sFunction);
		//driver.quit();
	}

}
