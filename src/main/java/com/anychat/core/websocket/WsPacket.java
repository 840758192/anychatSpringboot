package com.anychat.core.websocket;

import com.anychat.core.log.RunMonitor;
import com.google.protobuf.Message;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class WsPacket {
    private String wsOpCode;
    private Message data;
    public Object session;
    public RunMonitor runMonitor;

    public WsPacket(String wsOpCode, Message data, boolean useWSMonitor) {
        this.wsOpCode = wsOpCode;
        this.data = data;
        if (useWSMonitor) {
            this.runMonitor = new RunMonitor("WS", this.wsOpCode);
            this.putMonitor("解析完WS包");
        }

    }

    public WsPacket(String wsOpCode, Message data) {
        this.wsOpCode = wsOpCode;
        this.data = data;
    }

    public void putMonitor(String content) {
        if (this.runMonitor != null) {
            this.runMonitor.putMonitor(content);
        }

    }

    public void openRunMonitor() {
        if (this.runMonitor == null) {
            this.runMonitor = new RunMonitor("WS", this.wsOpCode);
        }

    }

    public String getWsOpCode() {
        return this.wsOpCode;
    }

    public void setWsOpCode(String wsOpCode) {
        this.wsOpCode = wsOpCode;
    }

    public Message getData() {
        return this.data;
    }

    public void setData(Message data) {
        this.data = data;
    }

    public byte[] getByteData() {
        return this.data.toByteArray();
    }

    public void clear() {
        this.data = null;
        this.session = null;
        this.runMonitor = null;
    }
}
