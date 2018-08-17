package com.anychat.core.thread;

import java.lang.reflect.Method;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class ThreadHandle implements IHandle {
    private Object packet;
    private Method method;
    private Object instance;

    public ThreadHandle(Object packet, Method method, Object instance) {
        this.packet = packet;
        this.method = method;
        this.instance = instance;
    }

    public Object getPacket() {
        return this.packet;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object getInstance() {
        return this.instance;
    }
}
