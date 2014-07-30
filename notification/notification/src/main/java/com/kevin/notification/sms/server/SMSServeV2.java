package com.kevin.notification.sms.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * create a SMS Server, need username and password, host and so on
 * 
 * @author kxu
 * 
 */
public class SMSServeV2 {
	private static Logger log = LoggerFactory.getLogger(SMSServeV2.class);
	private static String host;
	private static int port;
	private static String path;
	private static String defaultUserName;
	private static String defaultPassword;
	private static String validateMsg;
	private final String url;
	static {
		Properties p = new Properties();
		try {
			p.load(SMSServeV2.class.getClassLoader().getResourceAsStream("sms.properties"));
			host = p.getProperty("host");
			port = Integer.parseInt(p.getProperty("port"));
			path = p.getProperty("path");
			defaultUserName = p.getProperty("defaultUserName");
			defaultPassword = p.getProperty("defaultPassword");
			validateMsg = p.getProperty("validateMsg");
		} catch (IOException e) {
			log.error(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * user provided user name and password to build SMS server
	 * 
	 * @param userName
	 * @param password
	 */
	public SMSServeV2(String userName, String password) {
		StringBuffer sb = new StringBuffer(host);
		sb.append(":");
		sb.append(port);
		sb.append(String.format(path, new Object[] { userName, password }));
		url = sb.toString();

	}

	/**
	 * use default SMS server
	 */
	public SMSServeV2() {
		StringBuffer sb = new StringBuffer(host);
		sb.append(":");
		sb.append(port);
		sb.append(String.format(path, new Object[] { defaultUserName, defaultPassword }));
		url = sb.toString();

	}

	public String sendValidationMessage(String tel, int validateCode) {
		return this.sendMessage(tel, String.format(validateMsg, validateCode));
	}

	public String sendMessage(String tel, String content) {
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			String telURL = "&to=" + tel;
			String contentURL = "&content=" + URLEncoder.encode(content, "GB2312");
			String wholeURL = url + telURL + contentURL;
			log.info("Send URL: " + wholeURL);
			HttpGet get = new HttpGet(wholeURL);
			CloseableHttpResponse response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				return buffer.toString();
			}
			return response.getEntity().toString();
		} catch (Exception e) {
			log.error("Call " + url + " falied!" + e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				log.error("Close Httpclient failed!" + e);
			}
		}
		return null;
	}

}
