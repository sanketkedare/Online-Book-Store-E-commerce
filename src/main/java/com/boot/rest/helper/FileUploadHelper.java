package com.boot.rest.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper 
{
//	public final String Upload_Dir = "C:\\Users\\Lenovo\\Desktop\\Imp files";
	public final String Upload_Dir = new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException{}

	public boolean uploadFile(MultipartFile multipartFile) 
	{
		boolean f = false;
		try 
		{
			Files.copy(multipartFile.getInputStream(),
					Paths.get(Upload_Dir + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			f = true;
			return f;
		}
		catch (Exception e) 
		{System.out.println(e);}
		
		return f;
	}

}
