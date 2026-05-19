package com.prac.demo.config;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MiWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {

        session.sendMessage(
                new TextMessage("Bienvenido a la aplicación"));
    }
}