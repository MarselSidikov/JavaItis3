package ru.itis.example.renders;


import ru.itis.example.messages.Message;

import java.io.PrintWriter;

public class MessageRenderLovelyImpl implements MessageRenderer {
    private Message message;

    public MessageRenderLovelyImpl(Message message) {
        this.message = message;
    }
    public void render() {
        System.out.println("<3 " + message.getMessage());
    }

    public void printMessage(PrintWriter writer) {
        writer.write("<3 " + message.getMessage());
    }
}
