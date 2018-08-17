package com.anychat.core.websocket;

import java.util.Map;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public interface IWSListener {
    Map<String, String> getWSs() throws Exception;
}
