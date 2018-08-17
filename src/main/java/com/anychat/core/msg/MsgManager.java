package com.anychat.core.msg;

import com.anychat.core.log.ILog;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class MsgManager {
    public static Map<String, ArrayList<Method>> msgListenerMap = new HashMap();
    private static Map<Method, Object> msgInstanceMap = new HashMap();
    public static Map<Class<?>, Object> msgClassInstanceMap = new HashMap();
    public static boolean USE_MSG_MONITOR;
    public static ILog log;
    public static Method method;

    public MsgManager() {
    }

    public static void init(boolean useMsgMonitor, ILog log) throws Exception {
        USE_MSG_MONITOR = useMsgMonitor;
        log = log;
        method = MsgManager.class.getMethod("handleMsg", MsgPacket.class);
    }

    public static boolean addMsgListener(IMsgListener msgListener) throws Exception {
        Map<String, String> msgs = msgListener.getMsgs();
        if (msgs == null) {
            if (log != null) {
                log.warn("IMsgListener：" + msgListener.getClass().getName() + "监控数据为空");
            }

            return false;
        } else {
            Object[] msgKeyArray = msgs.keySet().toArray();

            for(int i = 0; i < msgKeyArray.length; ++i) {
                String msg = String.valueOf(msgKeyArray[i]);
                Method method = msgListener.getClass().getMethod((String)msgs.get(msg), MsgPacket.class);
                if (msg != null && !msg.equals("")) {
                    ArrayList<Method> methodList = (ArrayList)msgListenerMap.get(msg);
                    if (methodList == null) {
                        methodList = new ArrayList();
                        msgListenerMap.put(msg, methodList);
                    }

                    if (!methodList.contains(method)) {
                        methodList.add(method);
                    } else if (log != null) {
                        log.warn("IMsgListener：" + method.getClass().getName() + "注册多遍，请及时处理");
                    }

                    if (!msgInstanceMap.containsKey(method)) {
                        msgInstanceMap.put(method, msgListener);
                    } else if (log != null) {
                        log.warn(method.getName() + "已经被实例化注册过，请及时处理");
                    }

                    msgClassInstanceMap.put(msgListener.getClass(), msgListener);
                } else if (log != null) {
                    log.warn("消息类型为空，无法注册");
                }
            }

            return true;
        }
    }

    public static boolean dispatchMsg(String msgOpCode, Object data, Object otherData) throws Exception {
        if (!msgListenerMap.containsKey(msgOpCode)) {
            if (log != null) {
                log.warn("消息类型：" + msgOpCode + ",不存在，无法注册");
            }

            return false;
        } else {
            MsgPacket msgPacket = new MsgPacket(msgOpCode, data, otherData, USE_MSG_MONITOR);
            msgPacket.putMonitor("在当前线程处理");
            return handleMsg(msgPacket);
        }
    }

    public static boolean handleMsg(MsgPacket msgPacket) throws Exception {
        msgPacket.putMonitor("开始处理");
        ArrayList<Method> methodList = (ArrayList)msgListenerMap.get(msgPacket.getMsgOpCode());
        if (methodList != null && methodList.size() != 0) {
            for(int i = 0; i < methodList.size(); ++i) {
                Method method = (Method)methodList.get(i);

                try {
                    msgPacket.putMonitor("开始处理：" + i + ",方法：" + method.getName());
                    method.invoke(msgInstanceMap.get(method), msgPacket);
                    msgPacket.putMonitor("处理完成：" + i + ",方法：" + method.getName());
                } catch (Exception var5) {
                    if (log != null) {
                        log.error("MsgPacket,code为：" + msgPacket.getMsgOpCode() + "，IMsgListener为：" + method.getClass().getName() + "处理失败", var5);
                    }
                }
            }

            msgPacket.putMonitor("处理全部完成");
            if (USE_MSG_MONITOR && log != null) {
                log.info(msgPacket.runMonitor.toString());
            }

            msgPacket.clear();
            return true;
        } else {
            if (log != null) {
                log.warn("MsgPacket，code为：" + msgPacket.getMsgOpCode() + "未找到处理函数");
            }

            return false;
        }
    }
}
