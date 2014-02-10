package com.ny6design.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ny6design.model.UserMessage;
import com.ny6design.service.UserMessageMapperService;

/**
 * 
 * @author kevin
 * 
 */
public class MessageController {
	@Autowired
	UserMessageMapperService userMessageMapperService;

	@ResponseBody
	@RequestMapping("/latestMessage")
	public List<UserMessage> getCategoryList() {
		List<UserMessage> list = userMessageMapperService.getLatestMessages(10);
		return list;
	}
}
