package ru.itis.example.renders;


import ru.itis.example.messages.Message;

import java.io.PrintWriter;

public class MessageRenderHatefulImpl implements MessageRenderer {

    private Message message;

    public MessageRenderHatefulImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.out.println("inno and sberteh is bad " + message.getMessage());
    }

    public void printMessage(PrintWriter writer) {
        writer.write("inno and sberteh is bad " + message.getMessage());
    }
}
