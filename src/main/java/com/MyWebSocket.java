package com;


import com.anychat.core.msg.ThreadMsgManager;
import com.anychat.core.msg.ThreadWSManager;
import com.anychat.core.websocket.*;
import com.anychat.org.msg.MsgOpCodeChat;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/7/5 0005
 * Copyright 2018 by landray & STIC
 */
@ServerEndpoint( value = "/ws",
        decoders = {WebSocketDeCoder.class},
        encoders = {WebSocketEnCoder.class})
@Component
public class MyWebSocket {

    public MyWebSocket() {
    }

    @OnOpen
    public void onOpen(Session session) {
        try {
            ThreadMsgManager.dispatchThreadMsg(WSMsg.WEBSOCKET_CLIENT_CREATE_CONNECT, (Object)null, session);
        } catch (Exception var3) {
            if (WSManager.log != null) {
                WSManager.log.error("MsgManager.dispatchMsg error", var3);
            }
        }
    }

    @OnMessage
    public void onMessage(Session session, WsPacket wsPacket) {
        wsPacket.session = session;
        ThreadWSManager.dispatchWS(wsPacket);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        try {
            ThreadMsgManager.dispatchThreadMsg(MsgOpCodeChat.USER_OFFLINE, (Object)null, session);
        } catch (Exception var4) {
            if (WSManager.log != null) {
                WSManager.log.error("MsgManager.dispatchMsg error", var4);
            }
        }

    }
}
