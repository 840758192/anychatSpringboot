package com.anychat.core.thread;

import java.lang.reflect.Method;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public interface IHandle {
    Object getPacket();

    Method getMethod();

    Object getInstance();
}
