package west.com.OxygenThree.utility;

import java.text.DecimalFormat;
public class Formating {
	public static String sizeConverting (long iSize){
		String sFunction="|Class Utility.Formating | Method sizeConverting |";
		String hrSize = "";
	    double m = iSize/1024.0;
	    DecimalFormat dec = new DecimalFormat("0.00");
	    
	    float sizeKb = 1024.0f;
	    float sizeMo = sizeKb * sizeKb;
	    float sizeGo = sizeMo * sizeKb;
	    float sizeTerra = sizeGo * sizeKb;
	    
	    if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	

	    if(iSize < sizeMo) {
	    	if (dec.format(iSize / sizeKb).equalsIgnoreCase("0.00")) {
	    		if (Constant.bDebugMode) {
					System.out.println("The size is---1kb ");
					Log.info("The size is---1kb ");
					System.out.println("Function---"+sFunction+"--- gets completed");
					
				}
				Log.info("Function---"+sFunction+"--- gets completed");
	    		return "1kb";
	    	}
	    	else {
	    		if (Constant.bDebugMode) {
					System.out.println("The size is---"+dec.format(iSize / sizeKb)+ " Kb");
					Log.info("The size is---"+dec.format(iSize / sizeKb)+ " Kb");
					System.out.println("Function---"+sFunction+"--- gets completed");
					
				}
				Log.info("Function---"+sFunction+"--- gets completed");
	    		return dec.format(iSize / sizeKb)+ " Kb";
	    	}
	    }		
	        
	    else if(iSize < sizeGo) {
	    	if (Constant.bDebugMode) {
				System.out.println("The size is---"+dec.format(iSize / sizeMo) + " MB");
				Log.info("The size is---"+dec.format(iSize / sizeMo) + " MB");
				System.out.println("Function---"+sFunction+"--- gets completed");
				
			}
			Log.info("Function---"+sFunction+"--- gets completed");
	        return dec.format(iSize / sizeMo) + " MB";
	    }
	    
	    else if(iSize < sizeTerra) {
	      	if (Constant.bDebugMode) {
	        		System.out.println("The size is---"+dec.format(iSize / sizeGo) + " GB");
	        		Log.info("The size is---"+dec.format(iSize / sizeGo) + " GB");
	        		System.out.println("Function---"+sFunction+"--- gets completed");
	        		
	        	}
	        	Log.info("Function---"+sFunction+"--- gets completed");
	        	return dec.format(iSize / sizeGo) + " GB";
	    }
	        
	        	
	    	if (Constant.bDebugMode) {
	    		System.out.println("The size is---0Kb");
	    		Log.info("The size is---0kb");
	    		System.out.println("Function---"+sFunction+"--- gets completed");
	    	}
	    	Log.info("Function---"+sFunction+"--- gets completed"); 
	    	return "0kb";
	    	
	    
	    
	
	    }
}
