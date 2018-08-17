package com.anychat.org.dao.ext;

import com.anychat.org.model.base.ChatGroup;
import com.anychat.org.model.base.ChatGroupUserCriteria;

import java.util.List;


public interface ChatGroupUserMapperExt {
	List<ChatGroup> selectByExample(ChatGroupUserCriteria example);
}