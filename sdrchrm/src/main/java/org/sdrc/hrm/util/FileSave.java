package org.sdrc.hrm.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author Subham Ashish (subham@sdrc.co.in)
 *	04-Jan-2018
 * 
 */

public class FileSave {
	
	/**
	 * @param fileArray
	 * @param dir
	 * @param fileName
	 * @return
	 * saving file and returning path
	 */
	public static String saveFile(byte[] fileArray,String dir,String fileName){
		
		File file = null;
		file=new File(dir);
		
		String fullPath = dir+""+fileName;
		
		try {
			if(!file.exists())
				file.mkdir();
			
			file = new File(fullPath);
			FileUtils.writeByteArrayToFile(file, fileArray);
			return fullPath;
			
		} catch (IOException e) {
			
			return "fail";
		}
		
	}
}
