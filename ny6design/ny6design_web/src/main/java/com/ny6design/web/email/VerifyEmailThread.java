package com.ny6design.web.email;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kevin.notification.core.MimeMailService;
import com.kevin.notification.model.EmailNotify;

/**
 * used to send email to reset password!
 * 
 * @author kxu
 * 
 */
public class VerifyEmailThread implements Callable<Integer> {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	final EmailPropertiesFactory factory;
	final MimeMailService mimeMailService;
	final int userId;
	final String emailAddress;

	public VerifyEmailThread(EmailPropertiesFactory factory,
			MimeMailService mimeMailService, int userId, String emailAddress) {
		this.factory = factory;
		this.mimeMailService = mimeMailService;
		this.userId = userId;
		this.emailAddress = emailAddress;
	}

	@Override
	public Integer call() throws Exception {
		int status = -1;
		EmailNotify notify = new EmailNotify();
		notify.setFromEmail(factory.getValue("fromEmail"));
		notify.setSubject(factory.getValue("verifySubject"));
		notify.setToEmail(emailAddress);
		Map<String, Object> context = new HashMap<String, Object>();
		String link = factory.getValue("verifyLink");
		context.put("link", refactorLink(link));
		notify.setTemplateName(factory.getValue("verifyTemplate"));
		notify.setContext(context);
		try {
			mimeMailService.sendPredefinedTemplateMail(notify);
			status = 0;
		} catch (MessagingException e) {
			log.error("Send Reset Email failed!", e);
		}
		return status;
	}

	private String refactorLink(String _link) {
		return _link.replaceAll("#userId", "" + userId).replaceAll("#time",
				"" + System.currentTimeMillis());
	}

}
