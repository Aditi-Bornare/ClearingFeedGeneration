package com.citi.cfg.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class UploadService 
{
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://CitiBridge//Project//files//";
//    private String fileName;
//    public UploadService(String fileName) 
//    {
//		super();
//		this.fileName = fileName;
//	}
	public boolean uploadFile(MultipartFile file)
    {
	    System.out.println(file);
	    System.out.println(file.getOriginalFilename());
	    if (file.isEmpty()) 
	    {
	        return false;
	    }
	
	    try 
	    {
	        // Get the file and save it somewhere
	        byte[] bytes = file.getBytes();
	        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	        Files.write(path, bytes);
	        return true;
	
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return false;
    }
}
