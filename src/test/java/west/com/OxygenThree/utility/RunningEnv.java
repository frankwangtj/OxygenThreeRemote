package west.com.OxygenThree.utility;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RunningEnv {
	//##############################################################################################################################
	//#	Function String getRunningMachineName()
	//#	Purpose:	Return running machine name 
	//# Parameters: 
	//#	Return : Running machine name
	//#	Author: Frank
	//#	Created:	March 13, 2018
	//# Last modified: 
	//# How to test it
	//##############################################################################################################################

			
	public static String getRunningMachineName(){
		String sFunction="|Class Utils.RunningEnv | Method getRunningMachineName |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		String hostname = "Unknown";

		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets succeed");
				Log.info("Function---"+sFunction+"--- gets succeed");
				System.out.println("The computer name is----"+hostname+"----");
				Log.info("The computer name is----"+hostname+"----");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			return hostname;
			
		}
		catch (UnknownHostException e)
		{
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
				System.out.println("Hostname can not be resolved");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Hostname can not be resolved");
			Log.error(sFunction+"Exception desc : "+e.getMessage());
			Log.info("Function---"+sFunction+"--- gets completed");
		
		}
		return hostname;
		
		
		
	}
}
		


