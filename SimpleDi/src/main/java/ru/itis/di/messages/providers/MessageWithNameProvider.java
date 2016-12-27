package ru.itis.di.messages.providers;

import ru.itis.di.messages.messages.Message;

public class MessageWithNameProvider implements Provider {
    private String name;
    private Message message;

    public MessageWithNameProvider(Message message, String name) {
        this.message = message;
        this.name = name;
    }

    public void show() {
        System.out.println(message.getMessage() + ", " + name);
    }
}
