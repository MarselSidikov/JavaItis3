package ru.itis.handlers;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * 26.01.17
 * EchoHandler
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class EchoHandler extends TextWebSocketHandler {
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        System.out.println(session.getRemoteAddress());
        session.sendMessage(new TextMessage(textMessage.getPayload() + "HELLO"));
    }
}
