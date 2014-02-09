package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

	List<Question> findQuestionsByStatus(int status);
}