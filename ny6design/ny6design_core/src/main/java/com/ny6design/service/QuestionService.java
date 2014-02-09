package com.ny6design.service;

import java.util.Date;
import java.util.List;

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
	
	public void submitQuestion(Question question){
		questionMapper.insert(question);
	}
	
	public void replyQuestion(Question question){
		question.setStatus(1);
		question.setReplytime(new Date());
		questionMapper.updateByPrimaryKey(question);
	}
	
	public List<Question> findAllUnreplyQuestion(){
		return questionMapper.findAllUnreplyQuestion();
	}
}
