package com.kevin.notification.sms.server;

import static org.junit.Assert.*;

import org.junit.Test;

public class SMSServeV2Test {

	@Test
	public void testSendMessage() {
		System.out.println(new SMSServeV2().sendMessage("15818594398", "请输入一下数字：123456"));
	}

}
