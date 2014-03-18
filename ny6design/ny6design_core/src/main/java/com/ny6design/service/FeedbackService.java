package com.ny6design.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ny6design.constant.Constants.WILDCARD;

import com.ny6design.mapper.FeedBackMapper;
import com.ny6design.model.FeedBack;
import com.ny6design.mybatis.Page;

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

	public List<FeedBack> getAllFeedback(Page<FeedBack> page) {
		return feedBackMapper.getAllFeedbackByPage(page);
	}

	public void submitFeedback(FeedBack feedback) {
		feedBackMapper.insert(feedback);
	}

	public int updateRecommend(int _feedbackId, String recommed) {
		FeedBack feedback = feedBackMapper.selectByPrimaryKey(_feedbackId);
		if (feedback != null) {
			feedback.setRecommend(Short.parseShort(recommed));
			return feedBackMapper.updateByPrimaryKey(feedback);
		}
		return 0;
	}

	public List<FeedBack> getFeedbackBykeyword(String keyword,Page<FeedBack> page) {
		if (StringUtils.isEmpty(keyword)) {
			return this.getAllFeedback(page);
		}
		return feedBackMapper.findFeedbackBykeyword(WILDCARD + keyword
				+ WILDCARD,page);
	}

	public int getTotalOfFeedback() {
		return feedBackMapper.getTotalAccount();
	}

}
