package com.dollop.bai.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.util.StringUtils;

@Service
public class CloudServiceImpl implements ICloudService {

	@Autowired
	public Cloudinary  cloudinary;

	@Override
	public String uploadFileInFolder(MultipartFile myFile, String destinationPath) {
		String randomName= (UUID.randomUUID().toString() + myFile.getOriginalFilename());
		String fileName = StringUtils.cleanPath(randomName);
		Map uploadResponse;
		try {
			uploadResponse = cloudinary.uploader().upload(myFile.getBytes(),
					  ObjectUtils.asMap("public_id", destinationPath +"/"+fileName)); 
			return (String)uploadResponse.get("secure_url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> uploadFileInFolder(List<MultipartFile> file, String destinationPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getImages(String fileName, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteImageFromCloudServer(String imageUrl) throws IOException {
		// TODO Auto-generated method stub

	}

}
