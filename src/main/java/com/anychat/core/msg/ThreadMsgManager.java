package com.anychat.core.msg;

import com.anychat.core.thread.AsyncThreadManager;
import com.anychat.core.thread.ThreadHandle;

import java.util.HashMap;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class ThreadMsgManager {
    public static HashMap<String, int[]> msgOpcodeType = new HashMap();

    public ThreadMsgManager() {
    }

    public static boolean addMapping(String msgOpCode, int[] threadPriority) {
        if (msgOpcodeType.containsKey(msgOpCode)) {
            return false;
        } else {
            if (threadPriority != null) {
                msgOpcodeType.put(msgOpCode, threadPriority);
            }

            return true;
        }
    }

    public static boolean dispatchThreadMsg(String msgOpCode, Object data, Object otherData) {
        if (!MsgManager.msgListenerMap.containsKey(msgOpCode)) {
            if (MsgManager.log != null) {
                MsgManager.log.warn("消息类型：" + msgOpCode + ",不存在，无法注册");
            }

            return false;
        } else {
            MsgPacket msgPacket = new MsgPacket(msgOpCode, data, otherData, MsgManager.USE_MSG_MONITOR);
            int[] msgTypeArray = (int[])msgOpcodeType.get(msgPacket.getMsgOpCode());
            if (msgTypeArray == null || msgTypeArray.length != 2) {
                msgTypeArray = AsyncThreadManager.getRandomThreadPriority();
            }

            msgPacket.putMonitor("分发至线程：" + msgTypeArray[0] + ",优先级：" + msgTypeArray[1]);
            ThreadHandle threadHandle = new ThreadHandle(msgPacket, MsgManager.method, (Object)null);
            boolean result = AsyncThreadManager.addHandle(threadHandle, msgTypeArray[0], msgTypeArray[1]);
            return result;
        }
    }
}
