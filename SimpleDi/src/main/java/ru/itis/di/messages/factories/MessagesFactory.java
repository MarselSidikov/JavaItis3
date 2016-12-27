package ru.itis.di.messages.factories;

import ru.itis.di.messages.messages.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessagesFactory {
    private static MessagesFactory instance;

    private Message message;

    static {
        instance = new MessagesFactory();
    }

    private MessagesFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis3\\SimpleDi\\src\\main\\resources\\ru.itis\\context.properties"));
            String messageClassName = properties.getProperty("message.class");
            message = (Message)Class.forName(messageClassName).newInstance();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessagesFactory getInstance() {
        return instance;
    }

    public Message getMessage() {
        return message;
    }
}
