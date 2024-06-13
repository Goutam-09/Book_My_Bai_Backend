package com.dollop.bai.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudService {

	public String uploadFileInFolder(MultipartFile file, String destinationPath);
	
	public List<String> uploadFileInFolder(List<MultipartFile> file, String destinationPath);

	public InputStream getImages(String fileName, String destination);
	
	public void  deleteImageFromCloudServer(String imageUrl) throws IOException ;
}
