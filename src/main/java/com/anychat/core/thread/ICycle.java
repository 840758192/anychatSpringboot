package com.anychat.core.thread;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public interface ICycle {
    void cycle() throws Exception;

    void onAdd() throws Exception;

    void onRemove() throws Exception;
}
