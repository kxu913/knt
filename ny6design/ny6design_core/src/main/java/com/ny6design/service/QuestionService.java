package com.ny6design.service;

import static com.ny6design.constant.Constants.WILDCARD;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.QuestionMapper;
import com.ny6design.model.Question;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	public void submitQuestion(Question question) {
		questionMapper.insert(question);
	}

	public void replyQuestion(Question question) {
		question.setStatus(1);
		question.setReplytime(new Date());
		questionMapper.updateByPrimaryKey(question);
	}

	public List<Question> findAllUnreplyQuestion() {
		return questionMapper.findQuestionsByStatus(0);
	}

	public List<Question> findAllUnreplyQuestionByKeyword(String keyword) {
		if (StringUtils.isEmpty(keyword)) {
			return this.findAllUnreplyQuestion();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keyword", WILDCARD + keyword + WILDCARD);
		params.put("status", 0);
		return questionMapper.findAllUnreplyQuestionByKeyword(params);
	}
}
