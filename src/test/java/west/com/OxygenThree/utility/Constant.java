package west.com.OxygenThree.utility;

//##############################################################################################################################
//#	Function/class class Constant
//#	Purpose:	 Store all static information 
//# Parameters: 
//#	Return : 
//# Stage    ---phase 1----
//#	Author: Frank
//#	Created:	September 27, 2017
//# Last modified: 
//# How to test it
//	
//	
//##############################################################################################################################

public class Constant {
	//global setting
	public static final boolean bDebugMode=true;
	//Google
	public static final String URL_Google = "http://www.google.ca";
	
	//provide section info for config ini
	public static final String Running_Build="PMIS_1_1_4_Single";
	//Online store Application
    public static final String URL_OnlineStore = "http://www.store.demoqa.com";
    public static final String Username_OnlineStore = "testuser_12345678";
    public static final String Password_OnlineStore ="Test@123";
	
    
    //MIS Application
	public static final String URL_PMIS = "http://database1/mis/";
	public static final String Username_PMIS = "admin";
	public static final String Password_PMIS ="Admin";
	public static final int iRptMaxExecuteDuration=300000;  //10 minutes
	public static final int iWaitDuration=1000;  
	public static final int iMaxWaitDuration=4000;  
	public static final String sExecutingMsg="Creating";
	public static final String sRunBtnInitial="Run";
	public static final String sErrResult1="Error";
	public static final String sErrResult2="(0KB)";
	//public static final String sURL="http://{0}"; parameterlize URL
	
	//public setting
	//public static final String sBrowserType="IE";
	public static final String sBrowserType="Mozilla"; //Candidate BrowserType
	
	//public static final String Path_TestData = System.getProperty("user.dir")+"\\src\\testData\\";
    public static final String Path_TestData = "F:\\RemoteRepoSquareOne\\OnlineStoreSquareOne\\src\\testData\\";
	public static final String File_TestData = "TestData.xlsx";
	
	public static final String Path_Config=System.getProperty("user.dir")+"\\src\\test\\java\\west\\com\\OxygenThree\\ConfigData\\";
	public static final String File_Config="ProjectConfig.ini";
	
	//public static final String Path_ScreenShot =System.getProperty("user.dir")+"\\Screenshots\\";
	public static final String Path_ScreenShot ="F:\\RemoteRepoSquareOne\\OnlineStoreSquareOne\\Screenshots\\";
	//public static final String Path_Geckodriver ="C:\\003_RunningEnvironment\\02_GeckoDriver16\\"; 
	//public static final String Path_IE ="C:\\003_RunningEnvironment\\06_IEExecutable\\IEDriverServer_Win32_2.41.0\\";
	
	public static final String Path_Geckodriver ="D:\\FRWeb\\003_RunningEnvironment\\02_GeckoDriver16\\"; 
	public static final String Path_IE ="D:\\FRWeb\\003_RunningEnvironment\\06_IEExecutable\\IEDriverServer_Win32_2.41.0\\";

}
