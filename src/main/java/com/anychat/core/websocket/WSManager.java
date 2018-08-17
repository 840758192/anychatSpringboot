package com.anychat.core.websocket;

import com.anychat.core.log.ILog;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class WSManager {
    private static Map<String, Method> wsListenerMap = new HashMap();
    private static Map<Method, Object> wsInstanceMap = new HashMap();
    public static HashMap<String, Class<?>> wsOpCodeMap = new HashMap();
    public static ILog log;
    public static Method method;

    public WSManager() {
    }

    public static void init(ILog log) throws Exception {
        log = log;
        method = WSManager.class.getMethod("handleWS", WsPacket.class);
    }

    public static boolean addMapping(String wsOpCode, Class<?> clazz) {
        if (wsOpCodeMap.containsKey(wsOpCode)) {
            return false;
        } else {
            wsOpCodeMap.put(wsOpCode, clazz);
            return true;
        }
    }

    public static boolean addWSListener(IWSListener wsListener) throws Exception {
        Map<String, String> wss = wsListener.getWSs();
        if (wss != null) {
            Object[] wsKeyArray = wss.keySet().toArray();

            for(int i = 0; i < wsKeyArray.length; ++i) {
                String ws = String.valueOf(wsKeyArray[i]);
                Method method = wsListener.getClass().getMethod((String)wss.get(ws), WsPacket.class);
                if (!wsOpCodeMap.containsKey(ws)) {
                    if (log != null) {
                        log.warn("消息类型：" + ws + ",不存在，无法注册");
                    }
                } else {
                    if (!wsListenerMap.containsKey(ws)) {
                        wsListenerMap.put(ws, method);
                    } else if (log != null) {
                        log.warn("IWSListener：" + ws + "包含多个，请及时处理");
                    }

                    if (!wsInstanceMap.containsKey(method)) {
                        wsInstanceMap.put(method, wsListener);
                    } else if (log != null) {
                        log.warn(method.getName() + "已经被实例化注册过，请及时处理");
                    }
                }
            }

            return true;
        } else {
            if (log != null) {
                log.warn("IWSListener：" + wsListener.getClass().getName() + "关注ws为空");
            }

            return false;
        }
    }

    public static boolean dispatchWS(WsPacket wsPacket) {
        if (wsPacket == null) {
            if (log != null) {
                log.warn("派发ws包为空");
            }

            return false;
        } else {
            wsPacket.openRunMonitor();
            return handleWS(wsPacket);
        }
    }

    public static boolean handleWS(WsPacket wsPacket) {
        wsPacket.putMonitor("开始处理");
        Method method = (Method)wsListenerMap.get(wsPacket.getWsOpCode());
        if (method == null) {
            if (log != null) {
                log.warn("WsPacket，code为：" + wsPacket.getWsOpCode() + "未找到处理函数");
            }

            return false;
        } else {
            try {
                method.invoke(wsInstanceMap.get(method), wsPacket);
                wsPacket.putMonitor("处理完成");
                if (log != null) {
                    log.info(wsPacket.runMonitor.toString());
                }
            } catch (Exception var3) {
                if (log != null) {
                    log.error("WsPacket,code为：" + wsPacket.getWsOpCode() + "，IWSListener为：" + method.getClass().getName() + "处理失败", var3);
                }
            }

            wsPacket.clear();
            return true;
        }
    }
}
