package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import ru.itis.model.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class ChatController {

    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/chat")
    public void getMessage(MyMessage message) {
        System.out.println("Get message " + message.getText() +  " from " + message.getFrom());
        template.convertAndSend("/topic/messages", new MyMessage("server", message.getText()));
    }
}
