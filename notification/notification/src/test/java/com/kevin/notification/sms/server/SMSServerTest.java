package com.kevin.notification.sms.server;

import static org.junit.Assert.*;

import org.junit.Test;

public class SMSServerTest {

	@Test
	public void testGetResponse() {
		SMSServer server = new SMSServer("service.winic.org/",8009,"treeyun","wind2014");
		System.out.println(server.getResponse("http://feeds.alliancenews.info:24413/content"));
	}

}
