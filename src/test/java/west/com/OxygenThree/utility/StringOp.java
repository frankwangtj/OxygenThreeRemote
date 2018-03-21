package west.com.OxygenThree.utility;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class StringOp {
	//##############################################################################################################################
	//#	Function  String[] SplitStr(String sInput, String sDelimiter)
	//#	Purpose:	Split a string by given Delimiter (using regular expression)
	//# Parameters: sInput, sDelimiter
	//#	Return : String[]
	//#	Author: Frank
	//#	Created:	September 25, 2017
	//# Last modified: 
	//# Note: Link https://stackoverflow.com/questions/6086381/split-string-into-an-array-of-string
	//# How to test it
	//#	String sTest="hi I'm paul";
	//#	String sDelimiter="\\s+";   //split by space
	//#	String[] sResult = utility.StringOp.SplitStr(sTest, sDelimiter);
	//#	for (int i=0; i<sResult.length; i++) {
	//# 	System.out.println(sResult[i]);
	//#	}
	//#
	//#	String sTest="hi;I;m; paul;";
	//#	String sDelimiter="\\;";   //Split by ;
	//#	String[] sResult = utility.StringOp.SplitStr(sTest, sDelimiter);
	//#	for (int i=0; i<sResult.length; i++) {
	//#		System.out.println(sResult[i]);
	//#	}
	//#	String sTest="hi,I,m,paul,";
	//#	String sDelimiter="\\,";  //Split by ,
	//#	String[] sResult = utility.StringOp.SplitStr(sTest, sDelimiter);
	//#	for (int i=0; i<sResult.length; i++) {
	//#		System.out.println(sResult[i]);
	//#	}
	//##############################################################################################################################
	public static String[] getSplitStr(String arrayList, String sDelimiter) {
		String sFunction="|Class Utils.StringOp | Method getSplitStr |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		String[] SplitArray = null;
		try {
			SplitArray = arrayList.split(sDelimiter);
			if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets succeed");
				for (int i=0; i<SplitArray.length; i++) {
					System.out.println(SplitArray[i]);
				}
				Log.info("Function---"+sFunction+"--- gets succeed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			return SplitArray;
			
		} catch(PatternSyntaxException ex) {
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+ex.getMessage());
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.error(sFunction+"Exception desc : "+ex.getMessage());
			Log.info("Function---"+sFunction+"--- gets completed");
			throw (ex);
			
			
		}
		
		
		
	}

}
