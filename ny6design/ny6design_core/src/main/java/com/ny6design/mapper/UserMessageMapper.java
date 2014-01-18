package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.UserMessage;

public interface UserMessageMapper {
    int deleteByPrimaryKey(Integer fmessageid);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Integer fmessageid);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);

	List<UserMessage> getLatestMessages(int count);
}