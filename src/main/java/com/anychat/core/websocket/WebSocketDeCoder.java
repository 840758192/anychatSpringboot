package com.anychat.core.websocket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.nio.ByteBuffer;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class WebSocketDeCoder implements Decoder.Binary<WsPacket> {
    public WebSocketDeCoder() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

    @Override
    public WsPacket decode(ByteBuffer arg0) throws DecodeException {
        return WSCodeUtil.decodeJson(arg0);
    }

    @Override
    public boolean willDecode(ByteBuffer arg0) {
        return true;
    }
}
