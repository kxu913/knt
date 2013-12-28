package com.knt.core;

import com.knt.util.SystemConfigUtil;

/**
 * 
 * @author kevin
 *
 */
public class SystemConfigAttributes {

	public SiteInfo getSiteInfo() {
		return SystemConfigUtil.getSiteInfo();
	}

	public String getSiteUrl() {
		SiteInfo info = getSiteInfo();
		if (info != null) {
			return info.getSiteUrl();
		}
		return null;
	}

}
