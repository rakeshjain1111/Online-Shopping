package com.shop.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
   
	private static final String ABS_PATH ="C:\\Users\\hp\\git\\Online-Shopping\\onlineshopping\\src\\main\\webapp\\assets\\img\\";
	private static String REAL_PATH = "";

	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
	 	
		
		REAL_PATH = request.getServletContext().getRealPath("/assets/img/");
		
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			
			//project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
