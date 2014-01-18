package com.ny6design.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.UserMessage;

public class UserMessageMapperServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	UserMessageMapperService userMessageMapperService;

	@Before
	public void init() {
		userMessageMapperService = Env.getBean("userMessageMapperService");
	}

	@Test
	public void testInsertMessage() {
		String message1 = "The \"CUSTOM MAKE JEWELRY ORDER\" was great! \"MAKE IN U.S.A.\" Finished Jewelry Order with small quantity and COMPARATIVE PRICE are what you looking for!";
		String message2 = "These bead strands are so perfect &amp; the quality is above all other suppliers!!! Can't wait to make them into some beautiful jewelry!!!";
		String message3 = "How amzing your stones are!! I love every bead that I have gotten &amp; the quality is unsurpassed!!! wow!!";
		String message4 = "I received my order quickly. It was well packed and I found all of my order packed and precious. Couldn't wait to get my hands on them. Great job NY6 Designs.";
		String message5 = "The necklace was beautiful!Item as described and received promptly, thank you for working hard!!!";
		String message6 = "I LOVE this website!!! Great quality!! I just wish they had more sets because I want to match everything!!I WILL shop again and again!!!";
		String message7 = "I recently became interested in making jewelry using beads so I visited retail stores in my area and was shocked to see how much beads cost. I went to the Ebay website with great reluctance to try to find beads at a reasonable price. After receiving my first shipment from"
				+ "NY6 Design, I realized that your beads were of a higher quality than the ones in the stores and your prices are great! I have been telling my friends who are interested in making jewelry from beads that they should check out your"
				+ "website before paying hugh prices in retail stores. Quality, value and great customer service are the three most important things I look for when spending money. NY6 has all three of these and you are #1 on my list of suppliers!!!";
		String message8 = "Thank you for your wonderful service. My order was delivered very quickly and with the extra care taken in packing everything arrived in perfect condition.";
		String message9 = "LOVEEEE THE BEADS, I LEFT A SUPER MARVELOUS FEEDBACK BECAUSE YOU GUYS DESERVED. I WILL KEEP SHOPPING WITH YOU GUYS. THANKS YOU SO MUCH FOR THE FAST SERVICE, THE EXCELLENT WELL PACKED"
				+ "AND TGHE CARE YOU PUT WHEN WRAPING AND SHIPPING THIS FOR ME. IT MAKE ME TRUST AND FEEL TRANQUIL WHEN BUYING WITH YOU.... CONGRATULATIONS AND KEEP IT UP GUYS. I SAVED YOU IN MY FAVORITE SELLER LIST AND WILL SEE YOU SOON IN THE SHOW ROOM"
				+ ";O) KIND REGARDS, CLAUDIA H";
		String message10 = "Quality of beads is excellent and choices are immense! Order enough items and shipping is free and cost of items reduces nicely. Will come back for more; highly recommend this seller!";
		UserMessage message = new UserMessage();
		message.setFdescription(message1);
		message.setFuserid(1);
		userMessageMapperService.insertMessage(message);

		UserMessage msg1 = new UserMessage();
		msg1.setFdescription(message2);
		msg1.setFuserid(1);
		userMessageMapperService.insertMessage(msg1);

		UserMessage msg2 = new UserMessage();
		msg2.setFdescription(message3);
		msg2.setFuserid(1);
		userMessageMapperService.insertMessage(msg2);

		UserMessage msg3 = new UserMessage();
		msg3.setFdescription(message4);
		msg3.setFuserid(1);
		userMessageMapperService.insertMessage(msg3);
		UserMessage msg4 = new UserMessage();
		msg4.setFdescription(message5);
		msg4.setFuserid(1);
		userMessageMapperService.insertMessage(msg4);

		UserMessage msg5 = new UserMessage();
		msg5.setFdescription(message6);
		msg5.setFuserid(1);
		userMessageMapperService.insertMessage(msg5);

		UserMessage msg6 = new UserMessage();
		msg6.setFdescription(message7);
		msg6.setFuserid(1);
		userMessageMapperService.insertMessage(msg6);

		UserMessage msg7 = new UserMessage();
		msg7.setFdescription(message8);
		msg7.setFuserid(1);
		userMessageMapperService.insertMessage(msg7);

		UserMessage msg8 = new UserMessage();
		msg8.setFdescription(message9);
		msg8.setFuserid(1);
		userMessageMapperService.insertMessage(msg8);

		UserMessage msg9 = new UserMessage();
		msg9.setFdescription(message10);
		msg9.setFuserid(1);
		userMessageMapperService.insertMessage(msg9);

	}
	
	@Test
	public void testGetLatestMessage(){
		List<UserMessage> list = userMessageMapperService.getLatestMessages(1);
		assertNotNull(list);
		assertEquals(1, list.size());
	}

}
