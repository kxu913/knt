package com.ny6design.web.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ny6design.web.utill.ImageUploadUtil;


@Controller
public class FileUpload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5038413691382387134L;
	
	Logger logger = Logger.getLogger(FileUpload.class);
	
	@RequestMapping(value = "/upload100", method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String returnValue ="";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/");
		
		String originalFileName = null;
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {

			MultipartFile mf = entity.getValue();
			originalFileName = mf.getOriginalFilename();
			String fileExt = originalFileName.substring(
					originalFileName.lastIndexOf(".") + 1).toLowerCase();

			// new file name			
			String newFileName = ImageUploadUtil.generateFileName(originalFileName);
			File uploadFolder = ImageUploadUtil.getParentPath(ctxPath, fileExt);
			File uploadFileLocation = new File(uploadFolder , newFileName);
			if (ImageUploadUtil.htmlUpload(mf.getInputStream(), uploadFileLocation)) {
				int index = uploadFileLocation.getAbsolutePath().indexOf(ctxPath);
				
				returnValue = uploadFileLocation.getAbsolutePath().substring(index + ctxPath.length());
				logger.debug("upload files successfuly:"+uploadFileLocation.getAbsolutePath());
				logger.debug("returnValue:"+returnValue);
			}
			
			if (fileExt.equals("jpg") || fileExt.equals("png")) {				

					File uploadFolder2 = ImageUploadUtil.makeThumnailPicDirs(ctxPath);
					
					BufferedImage bi = ImageIO.read(mf.getInputStream());
					if (bi != null) {
						uploadFileLocation = new File(uploadFolder2
								, newFileName);
						ImageUploadUtil.uploadJPGfile(bi, uploadFileLocation);
						
						int index = uploadFileLocation.getAbsolutePath().indexOf(ctxPath);
						returnValue = uploadFileLocation.getAbsolutePath().substring(index + ctxPath.length());
					}
			}

		}
		return returnValue;
	}
}
