package com.anychat.core.websocket;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.Encoder.Text;
/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class WebSocketEnCoder implements Text<WsPacket>  {
    public WebSocketEnCoder() {
    }

    public void destroy() {
    }

    public void init(EndpointConfig arg0) {
    }

    public String encode(WsPacket arg0) throws EncodeException {
        return WSCodeUtil.encodeJson(arg0);
    }
}
