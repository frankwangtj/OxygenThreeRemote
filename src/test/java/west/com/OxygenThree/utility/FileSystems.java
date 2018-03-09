package west.com.OxygenThree.utility;

import java.nio.file.Paths;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import west.com.OxygenThree.utility.Constant;


public class FileSystems {
	//##############################################################################################################################
	//#	Function boolean isFolderExists(String sPath)
	//#	Purpose:	detect if a folder exists or not 
	//# Parameters: sPath
	//#	Return : true/false
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//	String sFolder="D:\FRTemp";
	//	System.out.println(String.valueOf(utility.FileSystems.isFolderExists(sFolder)));
	//##############################################################################################################################

		
	public static boolean isFolderExists(String sPath)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method isFolderExists |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		File fTemp=new File(sPath);
		boolean bReturn=false;
		try{
			if (fTemp.exists() && fTemp.isDirectory()) {
				Log.info("The folder--- "+sPath+" ---Exists");
				bReturn=true;
				if (Constant.bDebugMode) {
					System.out.println("The folder--- "+sPath+" ---Exists");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				return bReturn;
			}
			else {
				Log.info("The folder--- "+sPath+" ---NOT Exists");
				bReturn=false;
				if (Constant.bDebugMode) {
					System.out.println("The folder--- "+sPath+" ---NOT Exists");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				return bReturn;
			}
		}catch (Exception e){
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.error(sFunction+" ---Exception desc : "+e.getMessage());
			Log.info("Function---"+sFunction+"--- gets completed");
			throw (e);
		}
	}
	
	//##############################################################################################################################
	//#	Function boolean isFileExists(String sFile)
	//#	Purpose:	detect if a file existed or not 
	//# Parameters: sFile
	//#	Return : true/false
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//	String sFile="D:/FRTemp/omni.ja";
	//	System.out.println(String.valueOf(utility.FileSystems.isFileExists(sFile)));
	//##############################################################################################################################

		
	public static boolean isFileExists(String sFile)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method isFileExists |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		File fTemp=new File(sFile);
		boolean bReturn=false;
		try{
			if (fTemp.exists() && fTemp.isFile()) {
				Log.info("The file--- "+sFile+" ---Exists");
				if (Constant.bDebugMode) {
					System.out.println("The file--- "+sFile+" ---Exists");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				bReturn=true;
				return bReturn;
			}
			else {
				Log.info("The file--- "+sFile+" ---NOT Exists");
				if (Constant.bDebugMode) {
					System.out.println("The file--- "+sFile+" ---NOT Exists");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				bReturn=false;
				return bReturn;
			}
		}catch (Exception e){
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			Log.error("Class Utils.FileSystems | Method isFileExists | Exception desc : "+e.getMessage());
			throw (e);
		}
	}
	
	//##############################################################################################################################
	//#	Function long getFileSize(String sFile)
	//#	Purpose:	get a file size in KB, MB or GB depends on the actual size 
	//# Parameters: sFile
	//#	Return : size of the file in long
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//   String sFiler="D:/FRTemp/omni.ja";
	//   System.out.println(String.valueOf(utility.FileSystems.getFileSize(sFile)));
	//##############################################################################################################################

	public static long getFileSize(String sPath, String sFile)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method getFileSize |";
		String sFullPath;
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");
		sFullPath=sPath+"\\"+sFile;
		File fTemp=new File(sFullPath);
		long iSize;
		String sSize;
		try{
			if (fTemp.exists() && fTemp.isFile()) {
				iSize=fTemp.length();
				if (Constant.bDebugMode) {
					sSize=Formating.sizeConverting(iSize);
					//System.out.println("The File size is "+String.valueOf(iSize));
					//System.out.println("origin value");
					//Log.info("The File size is "+String.valueOf(iSize)+" bytes");
					//System.out.println(Formating.sizeConverting(iSize));
					//System.out.println("GetSize 1");
					//Log.info(Formating.sizeConverting(iSize));
						
					System.out.println(sSize);
					Log.info(sSize);
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				return iSize;
			}
			else {
				if (Constant.bDebugMode) {
					System.out.println("The File--- "+sFile+" ---NOT Exists");
					Log.info("The File--- "+sFile+" ---NOT Exists");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				iSize=0;
				return iSize;
			}
		}catch (Exception e){
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.error(sFunction+"--- Exception desc : "+e.getMessage());
			Log.info("Function---"+sFunction+"--- gets completed");
			throw (e);
		}
	}
}
