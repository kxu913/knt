package com.knt.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.StringUtils;

/**
 * configure site information
 * 
 * @author kevin
 * @see 
 * 
 */
@XmlRootElement(name = "siteInfo")
@XmlType(propOrder = { "siteName", "siteUrl", "keywords", "description",
		"copyright" })
public class SiteInfo implements Serializable {

	private static final long serialVersionUID = 2576257739582928671L;

	private String siteName;
	private String siteUrl;
	private String keywords;
	private String description;
	private String copyright;

	@XmlElement
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName == null ? null : siteName.trim();
	}

	@XmlElement
	public String getSiteUrl() {
		if (StringUtils.endsWith(siteUrl, "/")) {
			siteUrl = StringUtils.substringBeforeLast(siteUrl, "/");
		}
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl == null ? null : siteUrl.trim();
	}

	@XmlElement
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords == null ? null : keywords.trim();
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	@XmlElement
	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright == null ? null : copyright.trim();
	}

}
