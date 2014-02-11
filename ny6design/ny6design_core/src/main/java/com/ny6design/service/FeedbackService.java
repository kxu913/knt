package com.ny6design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.FeedBackMapper;
import com.ny6design.model.FeedBack;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class FeedbackService {
	@Autowired
	private FeedBackMapper feedBackMapper;
	private final static int COUNT = 10;

	public List<FeedBack> getRecommendFeedback() {
		return feedBackMapper.getRecommendFeedback(COUNT);
	}

	public List<FeedBack> getAllFeedback() {
		return feedBackMapper.getAllFeedback();
	}

	public void submitFeedback(FeedBack feedback) {
		feedBackMapper.insert(feedback);
	}

}
