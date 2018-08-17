package com;

import com.anychat.core.http.HttpUtil;
import com.anychat.core.msg.MsgManager;
import com.anychat.core.thread.AsyncThreadManager;
import com.anychat.core.websocket.WSManager;
import com.anychat.org.log.HttpclientLog;
import com.anychat.org.log.MariadbLog;
import com.anychat.org.log.ThreadmsgLog;
import com.anychat.org.log.WebSocketLog;
import com.anychat.org.msg.MsgOpCodeChat;
import com.anychat.org.service.LoginChatService;
import com.anychat.org.service.MessageService;
import com.anychat.org.ws.WsOpCodeChat;
import org.springframework.boot.CommandLineRunner;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class ImConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        WebSocketLog log = null;
        try{
            log = new WebSocketLog();
            WSManager.init(log);
            ThreadmsgLog threadmsgLog = new ThreadmsgLog();

            MybatisManager.setLog(new MariadbLog());

            HttpUtil.init("UTF-8", new HttpclientLog());
            // 初始化线程消息
            AsyncThreadManager.init(100, 10, 3, 0, threadmsgLog);
            AsyncThreadManager.start();
            MsgManager.init(true, threadmsgLog);

            WsOpCodeChat.init();
            MsgOpCodeChat.init();
            LoginChatService loginChatService = new LoginChatService();
            MsgManager.addMsgListener(loginChatService);
            WSManager.addWSListener(loginChatService);
            WSManager.addWSListener(new MessageService());
        }catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}
