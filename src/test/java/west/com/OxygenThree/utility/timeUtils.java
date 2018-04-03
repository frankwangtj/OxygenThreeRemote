package west.com.OxygenThree.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import west.com.OxygenThree.utility.Constant;
import west.com.OxygenThree.utility.Log;

public class timeUtils {
	 //##############################################################################################################################
	  //#	Function String getTimeString ()
	  //#	Purpose:	the String of timestamp. 
	  //# 	Purpose:    create file name with the timestring    
	  //# 	Parameters:  String returnFormat
	  //#                Format is "yyyy_MM_dd_HH_mm_ss"
	  //#	Return :  timestamp with underscore string
	  //#	Author: Frank
	  //#	Created:	March 28, 2018
	  //# Last modified: 
	  //# How to test it
	  //##############################################################################################################################

	  public static String getTimeString(String returnFormat) throws Exception {
		  String sRtn="";
		  String sFunction="|Class Utils.TimeUtils | Method getTimeString |";
		  if (Constant.bDebugMode) {
			  System.out.println("Function---"+sFunction+"--- gets Started");
		  }
		  Log.info("Function---"+sFunction+"--- gets Started");
		  try{
			  SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
			  dateFormatter = new SimpleDateFormat(returnFormat);
			  Date dNow = new Date();
			  sRtn=dateFormatter.format(dNow);
			  
			 		  			  			  
			  if (Constant.bDebugMode) {
				  System.out.println("The return value is---- " + sRtn + "----");
				  Log.info("The return value is---- " + sRtn + "----");
				  System.out.println("Function---"+sFunction+"--- gets succeed");
				  Log.info("Function---"+sFunction+"--- gets succeed");
				  System.out.println("Function---"+sFunction+"--- gets completed");
			  }
			  Log.info("Function---"+sFunction+"--- gets completed");
			  
		  }catch (Exception e){
			  sRtn = "failed";
			  if (Constant.bDebugMode) {
				
				  System.out.println("Function---"+sFunction+"--- gets Failed");
				  Log.info("Function---"+sFunction+"--- gets Failed");
				  System.out.println("Function---"+sFunction+"--- gets completed");
			  }
			  Log.info("Function---"+sFunction+"--- gets completed");
			  Log.error(sFunction+"Exception desc : "+e.getMessage());
			  throw (e);
		  }
		  return sRtn;

	  }
	  

}
