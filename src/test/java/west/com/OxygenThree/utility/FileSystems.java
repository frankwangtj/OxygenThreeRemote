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

}
