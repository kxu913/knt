package com.ny6design.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ny6design.model.FeedBack;
import com.ny6design.mybatis.Page;

public interface FeedBackMapper {
    int deleteByPrimaryKey(Integer fmessageid);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(Integer fmessageid);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
    
    List<FeedBack> getRecommendFeedback(int count);
    
    int getTotalAccount();

	List<FeedBack> getAllFeedbackByPage(@Param("page")Page<FeedBack> page);

	List<FeedBack> findFeedbackBykeyword(@Param("keyword")String keyword,@Param("page")Page<FeedBack> page);
}