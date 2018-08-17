package com.anychat.core.msg;

import com.anychat.core.log.RunMonitor;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class MsgPacket {
    private String msgOpCode;
    private Object data;
    private Object otherData;
    public RunMonitor runMonitor;

    public MsgPacket(String msgOpCode, Object data, Object otherData, boolean useMsgMonitor) {
        this.msgOpCode = msgOpCode;
        this.data = data;
        this.otherData = otherData;
        if (useMsgMonitor) {
            this.runMonitor = new RunMonitor("Msg", msgOpCode);
            this.putMonitor("生成Msg消息包");
        }

    }

    public void putMonitor(String content) {
        if (this.runMonitor != null) {
            this.runMonitor.putMonitor(content);
        }

    }

    public void clear() {
        this.data = null;
        this.otherData = null;
        this.runMonitor = null;
    }

    public String getMsgOpCode() {
        return this.msgOpCode;
    }

    public void setMsgOpCode(String msgOpCode) {
        this.msgOpCode = msgOpCode;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getOtherData() {
        return this.otherData;
    }

    public void setOtherData(Object otherData) {
        this.otherData = otherData;
    }
}
