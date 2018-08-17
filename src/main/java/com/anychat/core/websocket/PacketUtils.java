package com.anychat.core.websocket;

import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;
import com.googlecode.protobuf.format.util.TextUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class PacketUtils {
    public static JsonFormat jsonFormat = new JsonFormat();

    public PacketUtils() {
    }

    public static Message jsonToProtoBuf(String jsonStr, Message.Builder builder) {
        InputStream inputStream = null;

        Message var4;
        try {
            inputStream = TextUtils.toInputStream(jsonStr);
            jsonFormat.merge(inputStream, builder);
            Message message = builder.build();
            var4 = message;
            return var4;
        } catch (Exception var14) {
            if (WSManager.log != null) {
                WSManager.log.error("json转换成protobuf,异常", var14);
            }

            var4 = null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException var13) {
                    if (WSManager.log != null) {
                        WSManager.log.error("json转换成protobuf,关闭输入流失败", var13);
                    }
                }
            }

        }

        return var4;
    }

    public static String protoBufToJson(Message message) {
        return jsonFormat.printToString(message);
    }
}
