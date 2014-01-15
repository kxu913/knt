package com.knt.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.knt.core.SiteInfo;
import com.knt.mapper.JaxbMapper;

/**
 * util for system configuration
 * 
 * @author kevin
 * 
 */
public class SystemConfigUtil {

	private static final String CACHE_CONFIG_SITEINFO = "cacheConfigSiteInfo";

	public static SiteInfo getSiteInfo() {
		SiteInfo site = (SiteInfo) EhcacheCacheUtil.getObject(
				EhcacheCacheUtil.PERSISTENT_CACHE_NAME, CACHE_CONFIG_SITEINFO);
		if (site == null) {
			site = (SiteInfo) fromXml(SiteInfo.class, site,
					"/config/system-site.xml");
			EhcacheCacheUtil.putObject(EhcacheCacheUtil.PERSISTENT_CACHE_NAME,
					CACHE_CONFIG_SITEINFO, site);
		}
		return site;
	}

	public static void updateSiteInfo(SiteInfo siteInfo) {
		update(siteInfo, "/config/system-site.xml", CACHE_CONFIG_SITEINFO);
	}

	private static void update(Object obj, String filePath, String cacheKey) {
		String strXml = JaxbMapper.toXml(obj, "UTF-8");
		try {
			FileUtils.writeStringToFile(getResourceFile(filePath), strXml,
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		EhcacheCacheUtil.putObject(EhcacheCacheUtil.PERSISTENT_CACHE_NAME,
				cacheKey, obj);
	}

	private static Object fromXml(Class<?> clazz, Object obj, String filePath) {
		if (obj == null) {
			File file = getResourceFile(filePath);
			if (file.exists()) {
				Document document = null;
				SAXReader saxReader = new SAXReader();
				try {
					document = saxReader.read(file);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				obj = JaxbMapper.fromXml(document.asXML(), clazz);
			}
		}

		return obj;
	}

	private static File getResourceFile(String path) {
		File file = null;
		Resource resource = new ClassPathResource(path);
		try {
			if (resource.exists()) {
				file = resource.getFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}

}
