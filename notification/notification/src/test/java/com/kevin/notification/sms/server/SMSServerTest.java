package com.kevin.notification.sms.server;

import static org.junit.Assert.*;

import org.junit.Test;

public class SMSServerTest {

	@Test
	public void testGetResponse() {
		SMSServer server = new SMSServer("feeds.alliancenews.info",24413,"morningstar","Y28dHm7IZiCQX4R");
		System.out.println(server.getResponse("http://feeds.alliancenews.info:24413/content"));
	}

}
