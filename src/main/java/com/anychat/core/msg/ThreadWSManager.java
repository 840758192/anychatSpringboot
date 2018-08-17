package com.anychat.core.msg;

import com.anychat.core.thread.AsyncThreadManager;
import com.anychat.core.thread.ThreadHandle;
import com.anychat.core.websocket.WSManager;
import com.anychat.core.websocket.WsPacket;

import java.util.HashMap;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class ThreadWSManager {
    public static HashMap<String, int[]> wsOpCodeType = new HashMap();

    public ThreadWSManager() {
    }

    public static boolean addThreadMapping(String wsOpCode, Class<?> clazz, int[] threadPriority) {
        if (!WSManager.wsOpCodeMap.containsKey(wsOpCode) && !wsOpCodeType.containsKey(wsOpCode)) {
            WSManager.wsOpCodeMap.put(wsOpCode, clazz);
            if (threadPriority != null) {
                wsOpCodeType.put(wsOpCode, threadPriority);
            }

            return true;
        } else {
            return false;
        }
    }

    public static boolean dispatchWS(WsPacket wsPacket) {
        if (wsPacket == null) {
            if (WSManager.log != null) {
                WSManager.log.warn("派发ws包为空");
            }

            return false;
        } else {
            wsPacket.openRunMonitor();
            int[] wsTypeArray = (int[])wsOpCodeType.get(wsPacket.getWsOpCode());
            if (wsTypeArray == null || wsTypeArray.length != 2) {
                wsTypeArray = AsyncThreadManager.getRandomThreadPriority();
            }

            wsPacket.putMonitor("分发至线程：" + wsTypeArray[0] + ",优先级：" + wsTypeArray[1]);
            ThreadHandle threadHandle = new ThreadHandle(wsPacket, WSManager.method, (Object)null);
            boolean result = AsyncThreadManager.addHandle(threadHandle, wsTypeArray[0], wsTypeArray[1]);
            return result;
        }
    }
}
