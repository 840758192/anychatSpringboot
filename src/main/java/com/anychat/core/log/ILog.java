package com.anychat.core.log;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public interface ILog {
    void warn(String var1);

    void error(String var1, Throwable var2);

    void info(String var1);
}
