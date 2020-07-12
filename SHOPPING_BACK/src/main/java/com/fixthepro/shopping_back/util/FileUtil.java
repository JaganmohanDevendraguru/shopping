package com.fixthepro.shopping_back.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final String ABS_PATH = "D:\\Repos\\SHOPPING\\SHOPPING_FRONT\\src\\main\\resources\\static\\uploads\\";
	private static String REAL_PATH="";
	
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadProcess(MultipartFile file, String newName) {
		String fileType = file.getContentType();
		String originalName = file.getOriginalFilename();
		//file size
		long fileSize = file.getSize()/ 1024;
		//absolute path to store the file
		Path path = Paths.get(ABS_PATH);		
				try {
					//checking the file existence 
					if(Files.notExists(path))
						Files.createDirectory(path); //create the directory upon absence
					//upload to server
					//Files.write(filePath, file.getBytes());
					 file.transferTo(new File(ABS_PATH + newName));
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		log.info("Uploaded file " + fileType + " with the new name " + newName + " and the size is " + fileSize + "KB");
		return true;
	}
	
	public static String getFileName(MultipartFile file) {
		String originalName = file.getOriginalFilename();
		//file extension
		String extension = originalName.substring(originalName.lastIndexOf(".") + 1);
		String code = UUID.randomUUID().toString().substring(26).toUpperCase();
		return code+"."+extension;
	}
}
