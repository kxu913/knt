package com.ny6design.web.utill;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ny6design.utility.RandomUtils;
import com.ny6design.utility.ScaleImage;

/**
 * for image upload
 * @author kevin
 * 
 */
public class ImageUploadUtil {

	private String imagePath = "/imageFile/"
			+ new SimpleDateFormat("yyyyMMdd").format(new Date()) + "";

	private static int THUMNAIL_WIDTH = 150;
	private static int THUMNAIL_HEIGHT = 150;

	

	public void uploadImage1(HttpServletRequest request, MultipartFile file,
			String getUploadContentType, String getUploadFileName)
			throws IOException {

		String getImagePath = request.getSession().getServletContext()
				.getRealPath(imagePath);

		File image = new File(getImagePath);
		if (!image.exists()) {
			image.mkdirs();
		}

		String fileNewName = generateFileName(getUploadFileName);
		imagePath = imagePath + "/" + fileNewName;

		BufferedImage srcBufferImage = ImageIO.read(file.getInputStream());
		BufferedImage scaledImage;
		ScaleImage scaleImage = ScaleImage.getInstance();
		int yw = srcBufferImage.getWidth();
		int yh = srcBufferImage.getHeight();
		int w = 400, h = 300;
		if (w > yw && h > yh) {
			@SuppressWarnings("resource")
			//TODO
			FileOutputStream fos = new FileOutputStream(getImagePath + "/"
					+ fileNewName);

			FileInputStream fis = (FileInputStream) file.getInputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} else {
			scaledImage = scaleImage.imageZoomOut(srcBufferImage, w, h);
			FileOutputStream out = new FileOutputStream(getImagePath + "/"
					+ fileNewName);
			ImageIO.write(scaledImage, "jpeg", out);

		}
	}

	public static String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());

		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + "_" + RandomUtils.generateMixString(6) + extension;
	}

	public static File makeThumnailPicDirs(String contextPath) {
		return makeImageDirs(contextPath, "fileupload/thumnails");
	}

	public static File makeOriginalPicDirs(String contextPath) {
		return makeImageDirs(contextPath, "fileupload/images");
	}

	public static File makeOtherFileDirs(String contextPath) {
		return makeImageDirs(contextPath, "fileupload/others");
	}

	public static File getParentPath(String contextPath, String fileExt) {

		if (fileExt.equals("jpg") || fileExt.equals("png")) {
			return ImageUploadUtil.makeOriginalPicDirs(contextPath);
		} else {
			return makeOtherFileDirs(contextPath);
		}

	}

	public static boolean htmlUpload(InputStream inputStream, File uploadFile) {
		try {
			byte[] buff = new byte[4096];
			FileOutputStream output = new FileOutputStream(uploadFile);
			int bytecount = 1;
			while ((bytecount = inputStream.read(buff, 0, 4096)) != -1) {
				output.write(buff, 0, bytecount);
			}
			output.flush();
			output.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean uploadJPGfile(BufferedImage img,
			File uploadFileLocation2) {

		try {
			if (img != null) {

				BufferedImage tag = new BufferedImage(THUMNAIL_WIDTH,
						THUMNAIL_HEIGHT, BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(img, 0, 0, THUMNAIL_WIDTH,
						THUMNAIL_HEIGHT, null); // ������С���ͼ
				FileOutputStream out = new FileOutputStream(uploadFileLocation2);
				ImageIO.write(tag, "jpg", out);

				out.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Create image folder separated by day.
	 * 
	 * @param contextPath
	 * @return
	 */
	private static File makeImageDirs(String contextPath, String imageFolder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String formatDate = format.format(new Date());

		String imagePath = imageFolder + File.separator + formatDate;

		File imageFile = new File(contextPath, imagePath);
		if (!imageFile.exists()) {
			imageFile.mkdirs();
		}
		return imageFile;

	}

	public String getImagepath() {
		return imagePath;
	}

}
