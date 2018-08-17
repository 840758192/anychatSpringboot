package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * @author lijian
 * @version V1.0 创建时间：2018/7/5 0005
 * Copyright 2018 by landray & STIC
 */
@Configuration
public class WebSocketConfigs {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
