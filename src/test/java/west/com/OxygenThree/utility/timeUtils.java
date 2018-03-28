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
	  //# 	Parameters: 
	  //#	Return :  timestamp string
	  //#	Author: Frank
	  //#	Created:	March 28, 2018
	  //# Last modified: 
	  //# How to test it
	  //##############################################################################################################################

	  public static String getTimeString(String myDate, String returnFormat, String myFormat) throws Exception {
		  String sRtn="";
		  String sFunction="|Class Utils.TimeUtils | Method getTimeString |";
		  if (Constant.bDebugMode) {
			  System.out.println("Function---"+sFunction+"--- gets Started");
		  }
		  Log.info("Function---"+sFunction+"--- gets Started");
		  try{
			  Date date=null;
			  DateFormat dateFormat=new SimpleDateFormat(returnFormat);
			 
			  date = new SimpleDateFormat(myFormat, Locale.ENGLISH).parse(myDate);
			  sRtn=dateFormat.format(date);
			  			  			  
			  if (Constant.bDebugMode) {
				  System.out.println("The return value is---- " + sRtn + "----");
				  Log.info("The return value is---- " + sRtn + "----");
				  System.out.println("Function---"+sFunction+"--- gets succeed");
				  Log.info("Function---"+sFunction+"--- gets succeed");
				  System.out.println("Function---"+sFunction+"--- gets completed");
			  }
			  Log.info("Function---"+sFunction+"--- gets completed");
			  
		  }catch (Exception e){
			  sRtn = myDate;
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
