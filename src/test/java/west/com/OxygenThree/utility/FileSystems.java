package west.com.OxygenThree.utility;

import java.nio.file.Paths;
import java.io.IOException;
import java.io.File;
import java.io.FileFilter;	//for getLastModifiedFile
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import west.com.OxygenThree.utility.Constant;
import java.io.BufferedReader; 	//For readfile
import java.io.FileReader;     	//For readfile
import java.util.ArrayList;		//For array
import java.util.Arrays;		//For array
import org.apache.commons.io.filefilter.WildcardFileFilter; //for getLastModifiedFile
import org.apache.commons.io.comparator.LastModifiedFileComparator; //for getLastModifiedFile


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
			Log.error(sFunction+"Exception desc : "+e.getMessage());
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
	
	//##############################################################################################################################
	//#	Function boolean copyAFile(String sSrcFile, String sDestFile)
	//#	Purpose:	copy an existed file to a new file 
	//# Parameters: sSrcFile, sDestFile
	//#	Return : true/false
	//# Note the file name is full path name plus file name with extension name
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//  String sOri="D:/FRTemp/temp.txt";
	//  String sDest=sOri+"_QTP";
	//  utility.FileSystems.copyAFile(sOri, sDest );
	//##############################################################################################################################
				
		
	public static boolean copyAFile(String sSrcFolder, String sSrcFile, String sDestFolder, String sDestFile, boolean bPrefix)throws Exception{
		//File fTempsrc=new File(sSrcFile);
		String sFunction="|Class Utils.FileSystems | Method copyAFile |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		boolean bReturn=false;
		boolean bExist=false;
		String sActualSrcFile=sSrcFolder+"\\"+sSrcFile;
		String sActualDestFile=sDestFolder+"\\"+sDestFile;
		try{
			bExist=FileSystems.isFileExists(sActualSrcFile);
				if (!bExist) {
					bReturn=false;
					if (Constant.bDebugMode) {
						System.out.println("Source file--- "+sActualSrcFile+"---is not existed");
						Log.info("Source file--- "+sActualSrcFile+"---is not existed");
						System.out.println("Function---"+sFunction+"--- gets Failed");
						Log.info("Function---"+sFunction+"--- gets Failed");
						System.out.println("Function---"+sFunction+"--- gets completed");
					}
					Log.info("Function---"+sFunction+"--- gets completed");
					return bReturn;
				}
				else {
					if (!bPrefix) {
						bExist=FileSystems.isFileExists(sActualDestFile);
						if (!bExist) {
							Path pFrom=Paths.get(sActualSrcFile);
							Path pTo=Paths.get(sActualDestFile);
							 //overwrite the destination file if it exists, and copy
					        // the file attributes, including the rwx permissions
							CopyOption [] options = new CopyOption[] {
									StandardCopyOption.REPLACE_EXISTING, 
									StandardCopyOption.COPY_ATTRIBUTES
							};
							Files.copy(pFrom, pTo, options);
							if (Constant.bDebugMode) {
								System.out.println("Function---"+sFunction+"--- gets succeed");
								Log.info("Function---"+sFunction+"--- gets succeed");
								System.out.println("Function---"+sFunction+"--- gets completed");
							}
							Log.info("Function---"+sFunction+"--- gets completed");
							bReturn=true;
							return bReturn;
						}
						else {
							bReturn=false;
							if (Constant.bDebugMode) {
								System.out.println("Destination file--- "+sActualDestFile+"--- Existed");
								Log.info("Destination file--- "+sActualDestFile+"--- Existed");
								System.out.println("Function---"+sFunction+"--- gets Failed");
								Log.info("Function---"+sFunction+"--- gets Failed");
								System.out.println("Function---"+sFunction+"--- gets completed");
							}
							Log.info("Function---"+sFunction+"--- gets completed");
							return bReturn;
						}
						
					}
					else {
						sActualDestFile=sDestFolder+"\\"+sDestFile+"_"+sSrcFile;
						bExist=FileSystems.isFileExists(sActualDestFile);
						if (!bExist) {
							Path pFrom=Paths.get(sActualSrcFile);
							Path pTo=Paths.get(sActualDestFile);
							//overwrite the destination file if it exists, and copy
							// the file attributes, including the rwx permissions
							CopyOption [] options = new CopyOption[] {
								StandardCopyOption.REPLACE_EXISTING, 
								StandardCopyOption.COPY_ATTRIBUTES
							};
							Files.copy(pFrom, pTo, options);
							if (Constant.bDebugMode) {
								System.out.println("Function---"+sFunction+"--- gets succeed");
								Log.info("Function---"+sFunction+"--- gets succeed");
								System.out.println("Function---"+sFunction+"--- gets completed");
							}
							Log.info("Function---"+sFunction+"--- gets completed");
							bReturn=true;
							return bReturn;
						
						}
						bReturn=false;
						if (Constant.bDebugMode) {
							System.out.println("Destination file--- "+sActualDestFile+"--- Existed");
							Log.info("Destination file--- "+sActualDestFile+"--- Existed");
							System.out.println("Function---"+sFunction+"--- gets Failed");
							Log.info("Function---"+sFunction+"--- gets Failed");
							System.out.println("Function---"+sFunction+"--- gets completed");
						}
						Log.info("Function---"+sFunction+"--- gets completed");
						return bReturn;
					}
				}
					
					
			}catch (Exception e){
				if (Constant.bDebugMode) {
					System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.error(sFunction+"Exception desc : "+e.getMessage());
				Log.info("Function---"+sFunction+"--- gets completed");
				throw (e);
			}
		}
	

	//##############################################################################################################################
	//#	Function String[] readAFile(String sFile)
	//#	Purpose:	Read a file line by line into an array 
	//# Parameters: sFile
	//#	Return : String []
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//  String sOri="D:/FRTemp/temp.txt";
	//  String[] sRead=utility.FileSystems.readAFile(sOri);
	//  for (int i=0; i<sRead.length; ++i)
	//  {
	//	  System.out.println(sRead[i]);
	//  }
	//##############################################################################################################################
	
	
	public static String[] readAFile(String sFile)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method readAFile |";
		boolean bExists;
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");
		
		try{
			bExists=FileSystems.isFileExists(sFile);
			if (bExists) {
				FileReader fileReader = new FileReader(sFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				List<String> lines = new ArrayList<String>();
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					lines.add(line);
				}
				bufferedReader.close();
				if (Constant.bDebugMode) {
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				return lines.toArray(new String[lines.size()]);
			}
			else {
				if (Constant.bDebugMode) {
					System.out.println("File---"+sFile+"--- Not Exist");
					Log.info("File---"+sFile+"--- Not Exist");
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				return null;
			}
				
	    
			
		}catch (Exception e){
			if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets Failed");
				Log.info("Function---"+sFunction+"--- gets Failed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			Log.error(sFunction+"Exception desc : "+e.getMessage());
			throw (e);
		}
	}
	
	//##############################################################################################################################
	//#	Function boolean deleteAFile(String sFile)
	//#	Purpose:	delete an existed file  
	//# Parameters: sFile
	//#	Return : true/false
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//  String sOri="D:/FRTemp/temp.txt";
	//  utility.FileSystems.deleteAFile(sOri);
	//##############################################################################################################################
					
			
	public static boolean deleteAFile(String sFile)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method deleteAFile |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		boolean bReturn=false;
		boolean bExist=false;
		try{
			bExist=FileSystems.isFileExists(sFile);
			if (!bExist) {
				bReturn=false;
				if (Constant.bDebugMode) {
					System.out.println("File--- "+sFile+"---is not existed.The File can not be deleted");
					Log.info("File--- "+sFile+"---is not existed.The File can not be deleted");
					System.out.println("Function---"+sFunction+"--- gets Failed");
					Log.info("Function---"+sFunction+"--- gets Failed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				return bReturn;
			}
			else {
				File fToBeDeleted = new File(sFile);
				fToBeDeleted.delete();
				if (Constant.bDebugMode) {
					System.out.println("Function---"+sFunction+"--- gets succeed");
					Log.info("Function---"+sFunction+"--- gets succeed");
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.info("Function---"+sFunction+"--- gets completed");
				bReturn=true;
				return bReturn;
			}
		}catch (Exception e){
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.error(sFunction+"Exception desc : "+e.getMessage());
			Log.info("Function---"+sFunction+"--- gets completed");
			throw (e);
		}
	}
	
	//##############################################################################################################################
	//#	Function String getLastModifiedFile(String sPath, String sExt)
	//#	Purpose:    return the last modified file name with/without extension name
	//# Parameters: sPath, sExt
	//#	Return : String fileName
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# NOTE: When files and folders are combined, the result is incorrect.
	//#       Please sort by extension
	//# How to test it
	//  --With filter
	//	String sOri="D:/FRTemp/";
	//  String sExt="txt";
	//	System.out.println(utility.FileSystems.getLastModifiedFile(sOri, sExt));
	//  --With wildcard
	//	String sOri="D:/FRTemp/";
	//  String sExt="*";
	//	System.out.println(utility.FileSystems.getLastModifiedFile(sOri, sExt));
	//	--remote machine
	//  String sFolder="//recdb1/Test/";
	//  String sExt="*";
	//  System.out.println(utility.FileSystems.getLastModifiedFile(sFolder, sExt));
	//##############################################################################################################################
			
			
	public static String getLastModifiedFile(String sPath, String sExt)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method getLastModifiedFile |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		boolean bExiste=false;	
		String sMsg;
		String sFile;
		try{
			bExiste=FileSystems.isFolderExists(sPath);
				if (!bExiste) {
					sMsg="The folder--- "+sPath+" ---Not Exists.";
					if (Constant.bDebugMode) {
						System.out.println(sMsg);
						Log.info(sMsg);
						System.out.println("Function---"+sFunction+"--- gets Failed");
						Log.info("Function---"+sFunction+"--- gets Failed");
						System.out.println("Function---"+sFunction+"--- gets completed");
					}
					Log.info("Function---"+sFunction+"--- gets completed");
					sMsg="NOT EXISTED";
					return sMsg;
				}
				else {
					File fNewestFile = null;
					File fDir = new File(sPath);
					FileFilter ffilefilter=new WildcardFileFilter("*."+sExt);
					File [] files=fDir.listFiles(ffilefilter);
					if (files.length>0) {
						Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
						fNewestFile=files[0];
					}
					sFile=files[0].getName();
					if (Constant.bDebugMode) {
						System.out.println("Function---"+sFunction+"--- gets completed");
						Log.info("The latest modified file is---"+sFile+"---");
					}
					Log.info("Function---"+sFunction+"--- gets completed");
					
					return sFile;
					
				}							    
					
			}catch (Exception e){
				if (Constant.bDebugMode) {
					System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.error(sFunction+"Exception desc : "+e.getMessage());
				Log.info("Function---"+sFunction+"--- gets completed");
				throw (e);
			}
		}
	
	//##############################################################################################################################
	//#	Function String getFileNamesInAFolder(String sPath, String sExt)
	//#	Purpose:    return the file name list  with/without extension name
	//# Parameters: sPath, sExt
	//#	Return : Array fileName list
	//#	Author: Frank
	//#	Created:	September 15, 2017
	//# Last modified: 
	//# How to test it
	//  --With filter
	//	String sOri="D:/FRTemp/";
	//  String sExt="txt";
	//	System.out.println(utility.FileSystems.getLastModifiedFile(sOri, sExt));
	//  --With wildcard
	//	String sOri="D:/FRTemp/";
	//  String sExt="*";
	//	System.out.println(utility.FileSystems.getLastModifiedFile(sOri, sExt));
	//	--remote machine
	//  String sFolder="//recdb1/Test/";
	//  String sExt="*";
	//  System.out.println(utility.FileSystems.getLastModifiedFile(sFolder, sExt));
	//##############################################################################################################################
				
				
	public static String[] getFileNamesInAFolder(String sPath, String sExt)throws Exception{
		String sFunction="|Class Utils.FileSystems | Method getFileNamesInAFolder|";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");	
		boolean bExiste=false;	
		String sMsg;
		String [] sReturn =null;
		String [] sReturn1 = null;
		String sFile;
		try{
			bExiste=FileSystems.isFolderExists(sPath);
				if (!bExiste) {
					sMsg="The folder--- "+sPath+" ---Not Exists.";
					if (Constant.bDebugMode) {
						System.out.println(sMsg);
						Log.info(sMsg);
						System.out.println("Function---"+sFunction+"--- gets Failed");
						Log.info("Function---"+sFunction+"--- gets Failed");
						System.out.println("Function---"+sFunction+"--- gets completed");
					}
					Log.info("Function---"+sFunction+"--- gets completed");
					//sReturn[0]="NOT EXISTED";
					//return sReturn;
					return null;
				}
				else {
					File fNewestFile = null;
					File fDir = new File(sPath);
					FileFilter ffilefilter=new WildcardFileFilter("*."+sExt);
					File [] files=fDir.listFiles(ffilefilter);
					if (files.length>0) {
						//Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
						//fNewestFile=files[0];
						sReturn1 = new String [files.length];
						for (int i=0; i<files.length; ++i)
						{
							sReturn1[i] =files[i].getName();
						}
					}
					if (Constant.bDebugMode) {
						System.out.println("Function---"+sFunction+"--- gets completed");
						
					}
					Log.info("Function---"+sFunction+"--- gets completed");
						
					return sReturn1;
						
				}
					
						    
						
			}catch (Exception e){
				if (Constant.bDebugMode) {
					System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
					System.out.println("Function---"+sFunction+"--- gets completed");
				}
				Log.error(sFunction+"Exception desc : "+e.getMessage());
				Log.info("Function---"+sFunction+"--- gets completed");
				throw (e);
			}
		}
		
}
