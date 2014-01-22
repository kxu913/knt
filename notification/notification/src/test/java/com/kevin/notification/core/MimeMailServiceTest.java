package com.kevin.notification.core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kevin.notification.model.EmailNotify;

public class MimeMailServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/test.xml");
	MimeMailService mimeMailService;

	@Before
	public void init() {
		mimeMailService = (MimeMailService) context.getBean("mimeMailService");
	}

	@Test
	public void testSendTopic() throws MessagingException {
		EmailNotify notify = new EmailNotify();
		notify.setFromEmail("kxu913@gmail.com");
		notify.setSubject("test");
		notify.setToEmail("5522913@qq.com");
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("username", "kevin");
		context.put("link", "click me!");
		
		notify.setTemplateName("test.vm");
		notify.setContext(context);
		mimeMailService.sendPredefinedTemplateMail(notify);
	}

}
