package com.kevin.notification.model;

import java.util.Map;

/**
 * 邮件通知实体类
 * 
 * @author kevin
 * 
 */
public class EmailNotify {

	private Map<String, Object> context;
	private String toEmail;// 多个用户使用";"隔开
	private String fromEmail;
	private String subject; // 主题
	private String attachmentPath; // 附件
	private String templateName; // 自定义模板名称

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
