package com.anychat.org.dao.ext;

import com.anychat.org.model.base.Chat;
import com.anychat.org.model.ext.ChatCriteriaExt;

import java.util.List;


public interface ChatMapperExt {

	long countByExample(ChatCriteriaExt example);

	List<Chat> selectByExample(ChatCriteriaExt example);
}