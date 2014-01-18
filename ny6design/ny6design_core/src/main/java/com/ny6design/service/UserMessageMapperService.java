package com.ny6design.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.UserMessageMapper;
import com.ny6design.model.UserMessage;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class UserMessageMapperService {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UserMessageMapper userMessageMapper;

	public void insertMessage(UserMessage message) {
		if (message.isValidMessage()) {
			if (log.isTraceEnabled()) {
				log.trace("Insert an message, the message is "
						+ message.getFdescription());
			}
			message.setFupdatetime(new Date());
			userMessageMapper.insert(message);
		} else {
			if (log.isTraceEnabled()) {
				log.trace("Insert an message, Message is invalid!");
			}
		}

	}

	public List<UserMessage> getLatestMessages(int count) {
		if (log.isTraceEnabled()) {
			log.trace("Get latest " + count + " message");
		}
		return userMessageMapper.getLatestMessages(count);
		
	}

}
