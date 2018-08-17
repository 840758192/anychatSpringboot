package com.anychat.core.msg;

import java.util.Map;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public interface IMsgListener {
    Map<String, String> getMsgs() throws Exception;
}
