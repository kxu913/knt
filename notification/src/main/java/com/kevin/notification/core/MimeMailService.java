package com.kevin.notification.core;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.kevin.notification.model.EmailNotify;
import com.kevin.notification.util.VelocityUtil;

/**
 * MIME邮件服务类.
 * 
 * 由Velocity引擎生成的的html格式邮件, 并带有附件.
 */
@Service
public class MimeMailService {

	private static final String DEFAULT_ENCODING = "utf-8";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	private String templateFileName;

	/**
	 * 发送预定义MIME格式的用户修改通知邮件.
	 * 
	 * @throws MessagingException
	 */
	public void sendPredefinedTemplateMail(Map<String, Object> context,
			String toEmail, String fromEmail, String subject, File attachment)
			throws MessagingException {

		MimeMessage msg = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true,
				DEFAULT_ENCODING);
		String[] toEmailArr = getMailArray(toEmail);
		helper.setTo(toEmailArr);
		helper.setFrom(fromEmail);
		helper.setSubject(subject);

		String content = generateContent(context);
		helper.setText(content, true);
		if (attachment != null) {
			helper.addAttachment(attachment.getName(), attachment);
		}

		mailSender.send(msg);
		logger.info("Predefined Subject:" + subject + ",Mail send to " + toEmail);
	}

	/**
	 * 发送预定义MIME格式的用户修改通知邮件.
	 * 
	 * @throws MessagingException
	 */
	public void sendPredefinedTemplateMail(EmailNotify notify)
			throws MessagingException {
		this.templateFileName = notify.getTemplateName();
		if (notify.getAttachmentPath() != null) {
			File attachment = new File(notify.getAttachmentPath());
			this.sendPredefinedTemplateMail(notify.getContext(),
					notify.getToEmail(), notify.getFromEmail(),
					notify.getSubject(), attachment);
		} else {
			this.sendPredefinedTemplateMail(notify.getContext(),
					notify.getToEmail(), notify.getFromEmail(),
					notify.getSubject(), null);
		}
	}

	/**
	 * 发送自定义MIME格式的用户邮件.
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendUserdefinedTemplateEmail(Map<String, Object> context,
			String address, String fromEmail, String subject, File attachment,
			String templateContent) throws MessagingException,
			UnsupportedEncodingException {

		MimeMessage msg = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true,
				DEFAULT_ENCODING);
		String[] toEmail = getMailArray(address);
		helper.setTo(toEmail);
		helper.setFrom(fromEmail);
		helper.setSubject(subject);

		String text = generateContentByTemplateContent(templateContent, context);
		helper.setText(text, true);
		// 添加附件 ，使用MimeUtility.encodeWord()防止附件名称的中文乱码问题
		if (attachment != null) {
			helper.addAttachment(MimeUtility.encodeWord(attachment.getName()),
					attachment);
		}

		mailSender.send(msg);
		logger.info("Userdefined Subject:" + subject + ",Mail send to"
				+ toEmail.toString());
	}

	public String[] getMailArray(String toEmails) {
		List<String> list = Lists.newArrayList();
		String[] addressArray = toEmails.split(";");
		for (String element : addressArray) {
			list.add(element);
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * 通过模板文件使用Velocity生成html格式内容.
	 */
	private String generateContent(Map<String, ?> context)
			throws MessagingException {
		return VelocityUtil.renderFile(templateFileName, velocityEngine,
				DEFAULT_ENCODING, context);
	}

	/**
	 * 通过模板内容使用Velocity生成html格式内容.
	 */
	private String generateContentByTemplateContent(String content,
			Map<String, ?> context) throws MessagingException {
		return VelocityUtil.renderTemplateContent(content, context);
	}

	/**
	 * Spring的MailSender.
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

}
