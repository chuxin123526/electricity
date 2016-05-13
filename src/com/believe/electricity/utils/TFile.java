package com.believe.electricity.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class TFile
{
	public static String saveFile(File file , String fileName , String basePath) throws Exception
	{
		//创建文件夹
		Date date =  new Date() ; 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/") ; 
		String datePath = simpleDateFormat.format(date) ;
		
		fileName = UUID.randomUUID().toString() + fileName ; 
		String path = basePath + "/" + datePath + fileName ; 
		
		System.out.println(path);
		File fileDictory = new File(basePath + "/" + datePath) ;
		if(!fileDictory.exists())
		{
			fileDictory.mkdirs(); 
		}
		File file2 = new File(path) ; 
		file2.createNewFile() ; 
		
		FileInputStream fileInputStream = new FileInputStream(file) ; 
		FileOutputStream fileOutputStream = new FileOutputStream(file2) ; 
		byte[] bytes = new byte[1024] ; 
		int length = 0 ; 
		while((length = fileInputStream.read(bytes))!=-1)
		{
			fileOutputStream.write(bytes, 0, length);
		}
		fileOutputStream.close(); 
		fileInputStream.close(); 
		
			
		return path ;
	}
	
}
