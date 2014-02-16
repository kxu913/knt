package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.FeedBack;

public interface FeedBackMapper {
    int deleteByPrimaryKey(Integer fmessageid);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(Integer fmessageid);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
    
    List<FeedBack> getRecommendFeedback(int count);

	List<FeedBack> getAllFeedback();

	List<FeedBack> findFeedbackBykeyword(String keyword);
}